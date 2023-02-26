package com.example.server02.service;

import com.example.server02.helper.FileServiceHelper;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.tika.mime.MimeTypeException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.*;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class FileService {
    private final WebClient webClient;
    private final FileServiceHelper fileServiceHelper;
    public FileService(WebClient webClient, FileServiceHelper fileServiceHelper) {
        this.webClient = webClient;
        this.fileServiceHelper = fileServiceHelper;
    }

    public ResponseEntity<byte[]> getFileResponseFromServer01(String token){
        return webClient
                .get()
                .uri("/getfile")
                .header("Authorization" , token)
                .retrieve()
                .toEntity(byte[].class)
                .block();
    }

    public byte[] writeAndSaveFile(ResponseEntity<byte[]> fileResponseServer01 , String newContent) throws IOException, MimeTypeException {
        String mimeTypeString = String.valueOf(fileResponseServer01.getHeaders().getContentType());
        String extension = fileServiceHelper.getExtension(mimeTypeString);

        File file = new File("D:\\intellij\\server_file_task\\location_b\\temp"+extension);
        if(!file.exists()){
            file.createNewFile();
        }

        FileOutputStream fout = new FileOutputStream(file);
        fout.write(Objects.requireNonNull(fileResponseServer01.getBody()));

        FileInputStream fin = new FileInputStream(file);

        if(extension.equals(".pdf")){
    //        writing in pdf
            PDDocument document = PDDocument.load(file);
            fileServiceHelper.addPageToPDFDocument(document , newContent);
            document.save(file);
            document.close();
        }

        byte[] newFile = fin.readAllBytes();
//      if not close then we cannot delete tmp file from disk if server02 is running
        fin.close();
        fout.close();
        return newFile;
    }

    public String getAndSave(String userName , String password) throws IOException {
//        get token
        Map<String , String> bodyValue = new HashMap<>();
        bodyValue.put("userName" , userName);
        bodyValue.put("password" , password);

        String token = webClient
                .post()
                .uri("/token")
                .bodyValue(bodyValue)
                .retrieve()
                .bodyToMono(String.class)
                .block();
//  get file
    byte[] bytes = webClient
                .get()
                .uri("/getfile")
                .header("Authorization" , "Bearer "+token)
                .retrieve()
                .bodyToMono(byte[].class)
                .block();
//    save file
        FileOutputStream fout = new FileOutputStream("D:\\intellij\\server_file_task\\location_b\\get.pdf");
        fout.write(Objects.requireNonNull(bytes));
        fout.close();
        return "file saved sucessfully";
    }

    public String get() throws IOException {
        String fileString = webClient
                .get()
                .uri("/file")
                .retrieve()
                .bodyToMono(String.class)
                .block();

        byte[] bytes = Base64.getDecoder().decode(fileString.getBytes());
        FileOutputStream fout = new FileOutputStream("D:\\intellij\\server_file_task\\location_b\\download.pdf");
        fout.write(bytes);
        fout.close();
        return "file saved sucessfully";
    }

}
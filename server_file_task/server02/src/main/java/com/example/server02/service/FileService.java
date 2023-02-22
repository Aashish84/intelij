package com.example.server02.service;

import com.example.server02.helper.FileServiceHelper;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.tika.mime.MimeTypeException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

@Service
public class FileService {
    private final WebClient webClient;
    private final FileServiceHelper fileServiceHelper;
    public FileService(WebClient webClient, FileServiceHelper fileServiceHelper) {
        this.webClient = webClient;
        this.fileServiceHelper = fileServiceHelper;
    }

    public ResponseEntity<byte[]> getFileResponseFromServer01(){
        return webClient
                .get()
                .uri("/getfile")
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
}



//        write in pdf file
//        PDFTextStripper stripper = new PDFTextStripper();
//        String text =  stripper.getText(document);
//        System.out.println(text);
package com.example.server02.controller;

import com.example.server02.service.FileService;
import org.apache.tika.mime.MimeTypeException;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Base64;
import java.util.Map;
import java.util.Objects;

@RestController
public class FileController {
    private final FileService fileService;
    private final WebClient webClient;

    public FileController(FileService fileService, WebClient webClient) {
        this.fileService = fileService;
        this.webClient = webClient;
    }

    @GetMapping("/getfileserver01")
    public ResponseEntity<?> getFile(){
        Path path = Paths.get("D:\\intellij\\server_file_task\\location_b\\download.pdf");
        Flux<DataBuffer> dataBufferFlux = webClient
                .get()
                .uri("/getfile")
                .retrieve()
                .bodyToFlux(DataBuffer.class);
        DataBufferUtils.write(dataBufferFlux, path , StandardOpenOption.CREATE_NEW);
        return ResponseEntity.status(HttpStatus.OK)
                .body("file downloaded");
    }

//    all file
    @GetMapping("/getfile_server01")
    public ResponseEntity<?> getFileServer01(@RequestBody Map<String , String > requestContent) throws IOException, MimeTypeException {
        ResponseEntity<byte[]> fileResponseServer01 = fileService.getFileResponseFromServer01();
        byte[] tempFileBytes = fileService.writeAndSaveFile(fileResponseServer01 , requestContent.get("content"));
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(Objects.requireNonNull(fileResponseServer01.getHeaders().getContentType()))
                .body(tempFileBytes);
    }

//    static
    @GetMapping("/get")
    public ResponseEntity<?> get() throws IOException {
        byte[] bytes = webClient
                .get()
                .uri("/getfile")
                .retrieve()
                .bodyToMono(byte[].class)
                .block();
        FileOutputStream fout = new FileOutputStream("D:\\intellij\\server_file_task\\location_b\\get.pdf");
        fout.write(Objects.requireNonNull(bytes));
        fout.close();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("file uploaded sucessfully");

    }
    @GetMapping("/get02")
    public ResponseEntity<?> get02() throws IOException {
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
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("file uploaded sucessfully");
    }

}

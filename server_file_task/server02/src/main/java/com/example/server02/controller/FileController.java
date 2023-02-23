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
       return ResponseEntity
                .status(HttpStatus.OK)
                .body(fileService.getAndSave());

    }
    @GetMapping("/get02")
    public ResponseEntity<?> get02() throws IOException {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(fileService.get());
    }

}

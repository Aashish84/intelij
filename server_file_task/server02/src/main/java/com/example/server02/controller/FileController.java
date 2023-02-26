package com.example.server02.controller;

import com.example.server02.service.FileService;
import com.example.server02.service.TokenService;
import org.apache.tika.mime.MimeTypeException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

@RestController
public class FileController {
    private final FileService fileService;
    private final TokenService tokenService;
    public FileController(FileService fileService, WebClient webClient, TokenService tokenService) {
        this.fileService = fileService;
        this.tokenService = tokenService;
    }

    @PostMapping("/gettoken_server01")
    public ResponseEntity<?> getTokenServerOne(@RequestParam String userName , @RequestParam String password){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(tokenService.getTokenServerOne(userName ,password));
    }

//    all file
    @GetMapping("/getfile_server01")
    public ResponseEntity<?> getFileServer01(@RequestBody Map<String , String > requestContent , @RequestHeader(HttpHeaders.AUTHORIZATION) String token) throws IOException, MimeTypeException {
        ResponseEntity<byte[]> fileResponseServer01 = fileService.getFileResponseFromServer01(token);
        byte[] tempFileBytes = fileService.writeAndSaveFile(fileResponseServer01 , requestContent.get("content"));
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(Objects.requireNonNull(fileResponseServer01.getHeaders().getContentType()))
                .body(tempFileBytes);
    }

//    static
    @GetMapping("/get")
    public ResponseEntity<?> get(@RequestParam String userName , @RequestParam String password) throws IOException {
       return ResponseEntity
                .status(HttpStatus.OK)
                .body(fileService.getAndSave(userName , password));

    }

    @GetMapping("/get02")
    public ResponseEntity<?> get02() throws IOException {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(fileService.get());
    }

}

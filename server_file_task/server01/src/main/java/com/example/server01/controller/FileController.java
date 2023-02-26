package com.example.server01.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@RestController
public class FileController {
    @GetMapping("/test")
    public ResponseEntity<?> test(){
        return ResponseEntity.status(HttpStatus.OK)
                .body("hello from test");
    }

    @GetMapping("/getfile")
    public ResponseEntity<?> getFile() throws IOException {
        File file = new File("D:\\intellij\\server_file_task\\location_a\\hello.pdf");
        FileInputStream fin = new FileInputStream(file);
        byte [] bytes = fin.readAllBytes();
        String mimeType = URLConnection.guessContentTypeFromName(file.getName());
        fin.close();
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.valueOf(mimeType))
                .body(bytes);
    }

    @GetMapping("/file")
    public String get() throws IOException {
//        File file = new File("D:\\intellij\\server_file_task\\location_a\\hello.pdf");
        FileInputStream fin = new FileInputStream("D:/intellij/server_file_task/location_a/AashishKrThapa.pdf");
        byte[] fileBytes = fin.readAllBytes();
        String st = Base64.getEncoder().encodeToString(fileBytes);
        fin.close();
        return st;
    }
}

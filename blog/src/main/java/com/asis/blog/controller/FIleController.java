package com.asis.blog.controller;

import com.asis.blog.entity.FileData;
import com.asis.blog.service.serviceimpl.FileDataService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class FIleController {
    private final FileDataService fileDataService;

    public FIleController(FileDataService fileDataService) {
        this.fileDataService = fileDataService;
    }

    @PostMapping("/addfile")
    public ResponseEntity<?> uploadImage(@RequestParam("file")MultipartFile file) throws IOException {
        String res = fileDataService.uploadFile(file);
        return new ResponseEntity<>(res , HttpStatus.OK);
    }

    @GetMapping("/getfile/{fileName}")
    public ResponseEntity<?> downloadImage(@PathVariable String fileName){
        FileData fileData = fileDataService.downloadFile(fileName);
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.valueOf(fileData.getType()))
                .body(fileData.getFileData());
    }
}

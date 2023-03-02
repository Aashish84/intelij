package com.example.dockerdemo.controller;

import com.example.dockerdemo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
public class TestController {
    @GetMapping("/test")
    public ResponseEntity<?> test(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("test");
    }

    @GetMapping("/get")
    public ResponseEntity<?> get() throws SQLException {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new UserService().get());
    }
}

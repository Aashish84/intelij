package com.example.demo_server_a.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/server_a/hello")
    public ResponseEntity<String> testHello(){
        return ResponseEntity.ok("hello from server A");
    }
}

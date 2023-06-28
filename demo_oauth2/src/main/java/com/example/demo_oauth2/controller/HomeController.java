package com.example.demo_oauth2.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    public ResponseEntity<String> home(){
        return ResponseEntity.ok("hello , home");
    }
    @GetMapping("/secure")
    public ResponseEntity<String> secure(){
        return ResponseEntity.ok("hello , secure");
    }
}

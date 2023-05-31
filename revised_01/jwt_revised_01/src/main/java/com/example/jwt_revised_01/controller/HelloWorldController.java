package com.example.jwt_revised_01.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @GetMapping("/hello")
    public ResponseEntity<String> hello(){
        return ResponseEntity.ok("hello");
    }
    @GetMapping("/world")
    public ResponseEntity<String> world(){
        return ResponseEntity.ok("world");
    }
}

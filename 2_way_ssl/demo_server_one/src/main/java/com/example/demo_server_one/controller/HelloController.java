package com.example.demo_server_one.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public ResponseEntity<String> testHello(){
        return ResponseEntity.ok("hello_from_one_way_ssl");
    }
}

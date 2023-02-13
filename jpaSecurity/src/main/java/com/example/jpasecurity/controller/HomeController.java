package com.example.jpasecurity.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping
    public ResponseEntity<?> home(){
        return new ResponseEntity<>("home" , HttpStatus.OK);
    }
    @GetMapping("/free")
    public ResponseEntity<?> free(){
        return new ResponseEntity<>("this is free endpoint" , HttpStatus.OK);
    }
}

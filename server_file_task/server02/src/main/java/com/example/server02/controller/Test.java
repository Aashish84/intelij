package com.example.server02.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {
    @GetMapping
    public ResponseEntity<?> home(){
        return ResponseEntity.status(HttpStatus.OK).body("home server02");
    }
}

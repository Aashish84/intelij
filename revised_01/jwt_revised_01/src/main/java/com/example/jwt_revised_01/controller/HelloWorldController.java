package com.example.jwt_revised_01.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class HelloWorldController {
    @GetMapping("/hello")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public ResponseEntity<String> hello(){
        return ResponseEntity.ok("hello");
    }
    @GetMapping("/world")
    public ResponseEntity<String> world(){
        return ResponseEntity.ok("world");
    }
}

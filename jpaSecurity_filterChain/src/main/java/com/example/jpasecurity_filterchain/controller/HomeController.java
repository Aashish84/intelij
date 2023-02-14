package com.example.jpasecurity_filterchain.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
        return new ResponseEntity<>("free" , HttpStatus.OK);
    }
    @GetMapping("/user-only")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<?> userOnly(){
        return new ResponseEntity<>("user-only" , HttpStatus.OK);
    }

    @GetMapping("admin-only")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> adminOnly(){
        return new ResponseEntity<>("admin-only" , HttpStatus.OK);
    }
 }

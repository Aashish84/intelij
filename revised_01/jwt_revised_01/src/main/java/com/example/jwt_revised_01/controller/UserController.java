package com.example.jwt_revised_01.controller;

import com.example.jwt_revised_01.entity.AuthUser;
import com.example.jwt_revised_01.service.AuthUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private final AuthUserService authUserService;
    @GetMapping
    public ResponseEntity<?> getAllUser(){
        return ResponseEntity.ok(authUserService.fetchAllAuthUsers());
    }
    @PostMapping("/register")
    public ResponseEntity<?> saveUser(@RequestBody AuthUser user){
        return ResponseEntity.status(HttpStatus.CREATED).body(authUserService.createAuthUser(user));
    }
}

package com.example.demo_security_v3.controller;

import com.example.demo_security_v3.entity.AuthUser;
import com.example.demo_security_v3.repo.AuthUserRepo;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TestController {
    private final AuthUserRepo authUserRepo;
    private final PasswordEncoder encoder;
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody AuthUser authUser){
        authUser.setPassword(encoder.encode(authUser.getPassword()));
        return ResponseEntity.status(HttpStatus.CREATED).body(authUserRepo.save(authUser));
    }
    @GetMapping("/")
    public ResponseEntity<?> home(){
        return ResponseEntity.ok("home");
    }
    @GetMapping("/private")
    public ResponseEntity<?> testPrivate(){
        return ResponseEntity.ok("private");
    }
    @GetMapping("/admin")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<?> testOnlyAdmin(){
        return ResponseEntity.ok("admin");
    }
    @GetMapping("/only-user")
    @PreAuthorize("hasAnyRole('USER')")
    public ResponseEntity<?> testUserOnly(){
        return ResponseEntity.ok("user only");
    }
}

package com.example.server01.controller;

import com.example.server01.service.JWTService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AuthController {
    private final JWTService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthController(JWTService jwtService, AuthenticationManager authenticationManager) {
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/token")
    public ResponseEntity<?> getToken(@RequestBody Map<String, String> authUser) throws Exception {
        if ((((((!authUser.containsKey("userName") || !authUser.containsKey("password") || authUser.size() != 2)))))) {
            throw new Exception("invalid user only userName and password");
        }
        Authentication authenticate = authenticationManager
                .authenticate(
                        new UsernamePasswordAuthenticationToken(authUser.get("userName"), authUser.get("password"))
                );
        if (!authenticate.isAuthenticated()) {
            throw new UsernameNotFoundException("invalid user");
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(
                        jwtService.generateToken(authUser.get("userName"))
                );
    }
}

package com.example.jpasecurity.controller;

import com.example.jpasecurity.service.TokenService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    private final TokenService tokenService;

    public AuthController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @PostMapping("/token")
    public String token(Authentication authentication){
//        return "from token";
        return tokenService.generateToken(authentication);
    }

    @GetMapping("/token-decode")
    public String tokenDecode(Authentication authentication){
        System.out.println(authentication.isAuthenticated());
        System.out.println(authentication.getDetails());
        System.out.println(authentication.getName());
        return authentication.getName();
    }
}

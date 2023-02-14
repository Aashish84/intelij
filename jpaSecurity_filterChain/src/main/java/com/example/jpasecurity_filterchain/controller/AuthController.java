package com.example.jpasecurity_filterchain.controller;

import com.example.jpasecurity_filterchain.dto.AuthUser;
import com.example.jpasecurity_filterchain.service.JWTService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    private final JWTService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthController(JWTService jwtService, AuthenticationManager authenticationManager) {
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/token")
    public ResponseEntity<?> getToken(@RequestBody AuthUser authUser){
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authUser.getUserName(), authUser.getPassword()));
        if(!authenticate.isAuthenticated()){
            throw new UsernameNotFoundException("invalid user ");
        }
        return new ResponseEntity<>(jwtService.generateToken(authUser.getUserName()) , HttpStatus.OK);
    }
}

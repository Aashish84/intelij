package com.example.jwt_revised_01.controller;

import com.example.jwt_revised_01.entity.User;
import com.example.jwt_revised_01.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping
    public ResponseEntity<?> getAllUser(){
        return ResponseEntity.ok(userService.allUser());
    }
    @PostMapping
    public ResponseEntity<?> saveUser(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(user));
    }
}

package com.example.test.controller;

import com.example.test.entity.User;
import com.example.test.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class UserController {
    private final UserService userService;
    @GetMapping("/user")
    public ResponseEntity<?> getAllUser(){
        return ResponseEntity.ok(userService.getAllUser());
    }
    @PostMapping("/user")
    public ResponseEntity<?> saveUser(@RequestBody User user){
        return ResponseEntity.ok(userService.saveUser(user));
    }
}

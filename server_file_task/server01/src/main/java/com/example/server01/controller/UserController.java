package com.example.server01.controller;

import com.example.server01.entity.User;
import com.example.server01.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/user")
    public ResponseEntity<?> allUser(){
        return new ResponseEntity<>(userService.allUser() , HttpStatus.OK);
    }
    @PostMapping("/user")
    public ResponseEntity<?> addUser(@RequestBody User user){
        return new ResponseEntity<>(userService.addUser(user) , HttpStatus.CREATED);
    }
}

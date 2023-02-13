package com.example.jpasecurity.controller;

import com.example.jpasecurity.entity.User;
import com.example.jpasecurity.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<?> allUser(){
        return new ResponseEntity<>(userService.allUser() , HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<?> saveUser(@RequestBody User user){
        return new ResponseEntity<>(userService.saveUser(user) , HttpStatus.CREATED);
    }
}

package com.example.demodto.controller;

import com.example.demodto.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user-location")
    public ResponseEntity<?> getAllUsersLocation(){
        return new ResponseEntity<>(userService.getAllUserLocation() , HttpStatus.OK );
    }

}

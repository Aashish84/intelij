package com.asis.blog.controller;

import com.asis.blog.dto.UserDto;
import com.asis.blog.entity.User;
import com.asis.blog.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("/users")
    public ResponseEntity<?> getAllUser(){
        return new ResponseEntity<>(userService.getAllUser() , HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<?> addUser(@RequestBody User user){
//        return new ResponseEntity<>(userDto,HttpStatus.CREATED);
        return new ResponseEntity<>(userService.addUser(user) , HttpStatus.CREATED);
    }
}

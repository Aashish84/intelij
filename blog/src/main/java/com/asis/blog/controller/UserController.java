package com.asis.blog.controller;

import com.asis.blog.entity.User;
import com.asis.blog.exception.CustomException;
import com.asis.blog.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return new ResponseEntity<>(userService.addUser(user) , HttpStatus.CREATED);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable ("id") Long id){
        return new ResponseEntity<>(userService.deleteUser(id) , HttpStatus.OK);
    }

    @PatchMapping("/users/{id}")
    public ResponseEntity<?> updateUser(@PathVariable("id") Long id , @RequestBody User user) throws CustomException {
        return new ResponseEntity<>(userService.updateUser(id , user) , HttpStatus.OK);
    }
}

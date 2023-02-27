package com.example.eventhandlerfromscratch.controller;

import com.example.eventhandlerfromscratch.model.User;
import com.example.eventhandlerfromscratch.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getString")
    public ResponseEntity<?> getAllUser() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(userService.getAllUser());
    }
    @GetMapping("/get")
    public ResponseEntity<?> allUser() throws SQLException {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.allUser());
    }

    @PostMapping("/add")
    public ResponseEntity<?> saveUser(@RequestBody User user) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userService.saveUser(user) + " row inserted");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateUser(@PathVariable int id, @RequestBody User user) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.updateUser(id, user) + " row updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.deleteUser(id) + " row deleted");
    }
}

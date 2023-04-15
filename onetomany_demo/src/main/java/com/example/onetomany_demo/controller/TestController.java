package com.example.onetomany_demo.controller;

import com.example.onetomany_demo.entity.Test;
import com.example.onetomany_demo.service.TestService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/test")
public class TestController {
    private final TestService testService;
    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(testService.allTest());
    }
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Test test){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(testService.save(test));
    }
}

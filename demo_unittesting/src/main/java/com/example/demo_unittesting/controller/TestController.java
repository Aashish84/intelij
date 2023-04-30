package com.example.demo_unittesting.controller;

import com.example.demo_unittesting.entity.Test;
import com.example.demo_unittesting.repo.TestRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    private final TestRepo testRepo;

    public TestController(TestRepo testRepo) {
        this.testRepo = testRepo;
    }

    @GetMapping("/get")
    public ResponseEntity<?> getAll(){
        Test t = new Test();
        t.setName("test1");
        testRepo.save(t);
        return ResponseEntity.ok(testRepo.findAll());
    }
}

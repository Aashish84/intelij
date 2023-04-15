package com.example.onetomany_demo.controller;

import com.example.onetomany_demo.service.TestVdmsDevice;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/device")
public class TestVdmsDeviceController {
    private final TestVdmsDevice customerService;
    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(customerService.getAllCustomer());
    }
    @PostMapping
    public ResponseEntity<?> save(@RequestBody com.example.onetomany_demo.entity.TestVdmsDevice testVdmsDevice){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(customerService.saveCustomer(testVdmsDevice));
    }
}

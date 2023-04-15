package com.example.test.controller;

import com.example.test.entity.Laptop;
import com.example.test.service.LaptopService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
public class LaptopController {
    private final LaptopService laptopService;
    @GetMapping("/laptop")
    public ResponseEntity<?> getALlLaptop(){
        return ResponseEntity.ok(laptopService.getAllLaptop());
    }
    @PostMapping("/laptop")
    public ResponseEntity<?> saveLaptop(@RequestBody Laptop laptop){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(laptopService.saveLaptop(laptop));
    }
}

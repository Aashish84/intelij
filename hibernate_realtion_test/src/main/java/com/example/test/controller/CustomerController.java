package com.example.test.controller;

import com.example.test.entity.Customer;
import com.example.test.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;
    @GetMapping
    public ResponseEntity<?> getAllCustomer(){
        return ResponseEntity.ok(customerService.getAllCustomer());
    }
    @PostMapping
    public ResponseEntity<?> saveCustomer(@RequestBody Customer customer){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(customerService.saveCustomer(customer));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable long id){
        return ResponseEntity.ok(customerService.deleteCustomer(id));
    }
}

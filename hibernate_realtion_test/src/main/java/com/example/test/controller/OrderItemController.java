package com.example.test.controller;

import com.example.test.entity.OrderItem;
import com.example.test.service.OrderItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/order")
public class OrderItemController {
    private final OrderItemService orderItemService;
    @GetMapping
    public ResponseEntity<?> getALlOrder(){
        return ResponseEntity.ok(orderItemService.getAllOrders());
    }
    @PostMapping
    public ResponseEntity<?> saveOrder(@RequestBody OrderItem orderItem){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(orderItemService.saveOrder(orderItem));
    }
}

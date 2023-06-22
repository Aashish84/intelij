package com.example.demo_rabbitmq.controller;

import com.example.demo_rabbitmq.dto.InspectionDto;
import com.example.demo_rabbitmq.producer.RabbitMQProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    private final RabbitMQProducer rabbitMQProducer;

    public MessageController(RabbitMQProducer rabbitMQProducer) {
        this.rabbitMQProducer = rabbitMQProducer;
    }
    @GetMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestBody InspectionDto inspectionDto){
        rabbitMQProducer.sendMessage(inspectionDto);
        return ResponseEntity.ok("message sent");
    }
}

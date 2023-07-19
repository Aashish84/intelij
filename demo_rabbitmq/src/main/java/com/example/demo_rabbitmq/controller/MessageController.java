package com.example.demo_rabbitmq.controller;


import com.example.demo_rabbitmq.producer.RabbitMQProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class MessageController {
    private final RabbitMQProducer rabbitMQProducer;

    public MessageController(RabbitMQProducer rabbitMQProducer) {
        this.rabbitMQProducer = rabbitMQProducer;
    }

    @GetMapping("/")
    public ResponseEntity<String> home(){
        return ResponseEntity.ok("hello");
    }
    @GetMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestBody Map<String, Object> msg) {
        rabbitMQProducer.sendMessages(msg);
        return ResponseEntity.ok("message sent");
    }
    @GetMapping("/publish/list")
    public ResponseEntity<String> sendMessage(@RequestBody List<Map<String, Object>> msgList) {
        rabbitMQProducer.sendMessages(msgList);
        return ResponseEntity.ok("message sent");
    }
}

package com.example.demo_confluentkafka_producer.controller;

import com.example.demo_confluentkafka_producer.producer.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {
    private final KafkaProducer producer;

    public ProducerController(KafkaProducer producer) {
        this.producer = producer;
    }

    @GetMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestParam String msg){
        producer.sendMessage(msg);
        return ResponseEntity.ok("hello");
    }
}

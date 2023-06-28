package com.example.demo_rabbitmq.controller;

import com.example.demo_rabbitmq.dto.*;
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
    @GetMapping("/publish/inspection")
    public ResponseEntity<String> sendMessage(@RequestBody InspectionDto inspectionDto){
        rabbitMQProducer.sendMessage(inspectionDto);
        return ResponseEntity.ok("message sent");
    }
    @GetMapping("/publish/service")
    public ResponseEntity<String> sendService(@RequestBody ServiceDto serviceDto){
        rabbitMQProducer.sendMessage(serviceDto);
        return ResponseEntity.ok("message sent");
    }
    @GetMapping("/publish/sensor")
    public ResponseEntity<String> sendSensor(@RequestBody SensorDto serviceDto){
        rabbitMQProducer.sendMessage(serviceDto);
        return ResponseEntity.ok("message sent");
    }
    @GetMapping("/publish/engineering_assets")
    public ResponseEntity<String> sendEngineeringAsset(@RequestBody EngineeringAssetsDto dto){
        rabbitMQProducer.sendMessage(dto);
        return ResponseEntity.ok("message sent");
    }
    @GetMapping("/publish/daintree")
    public ResponseEntity<String> sendDaintree(@RequestBody DaintreeDto dto){
        rabbitMQProducer.sendMessage(dto);
        return ResponseEntity.ok("message sent");
    }
}

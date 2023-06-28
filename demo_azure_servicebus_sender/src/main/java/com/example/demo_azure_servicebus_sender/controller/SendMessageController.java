package com.example.demo_azure_servicebus_sender.controller;

import com.example.demo_azure_servicebus_sender.service.SendMessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendMessageController {
    private final SendMessageService sendMessageService;

    public SendMessageController(SendMessageService sendMessageService) {
        this.sendMessageService = sendMessageService;
    }

    @GetMapping("/send")
    public ResponseEntity<?> sendMessage(@RequestParam("msg") String msg){
        sendMessageService.sendMessage(msg);
        return ResponseEntity.ok("message sent");
    }
}

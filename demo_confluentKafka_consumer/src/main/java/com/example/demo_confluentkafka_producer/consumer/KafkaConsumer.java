package com.example.demo_confluentkafka_producer.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    @KafkaListener(topics = "topic_61" , containerFactory = "kafkaListenerContainerFactory")
    public void listen(String message){
        System.out.println("Message recived ::::::::  "+message);
    }
}

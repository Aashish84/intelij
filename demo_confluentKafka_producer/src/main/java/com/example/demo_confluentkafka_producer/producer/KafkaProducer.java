package com.example.demo_confluentkafka_producer.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaProducer {
    public final KafkaTemplate<String , String> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
        public void sendMessage(String message){
        ListenableFuture<SendResult<String, String>> topic61 = kafkaTemplate.send("topic_61", message);
        topic61.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onFailure(Throwable ex) {
                System.out.println("message failed to sent");
            }

            @Override
            public void onSuccess(SendResult<String, String> result) {
                System.out.println("message sent successfully");
            }
        });
    }
}


package com.example.demo_confluentkafka_producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
//@EnableKafka
public class DemoConfluentKafkaProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoConfluentKafkaProducerApplication.class, args);
    }

}

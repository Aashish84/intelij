package com.example.demo_confluentkafka_producer.config;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class KafkaConfig {
    @Bean
    public ConsumerFactory<String,String> consumerFactory(KafkaProperties kafkaProperties){
        List<String> bootstrapServers = new ArrayList<>();
        bootstrapServers.add("EXTERNAL://3.89.70.147:9093");
        kafkaProperties.setBootstrapServers(bootstrapServers);
        System.out.println(kafkaProperties.getBootstrapServers());
        return new DefaultKafkaConsumerFactory<>(kafkaProperties.buildConsumerProperties());
    }
    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String,String>> kafkaListenerContainerFactory(KafkaProperties kafkaProperties){
        ConcurrentKafkaListenerContainerFactory<String,String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory(kafkaProperties));
        return factory;
    }
}

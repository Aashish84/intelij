package com.example.demo_rabbitmq.producer;

import com.example.demo_rabbitmq.dto.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQProducer {
    @Value("${rabbitmq.exchange.name}")
    private String exchange;
    @Value("${rabbitmq.routing.key}")
    private String routingKey;
    private final RabbitTemplate rabbitTemplate;
    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQProducer.class);

    public RabbitMQProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    public void sendMessage(EngineeringAssetsDto inspectionDto){
        rabbitTemplate.convertAndSend(exchange , routingKey , inspectionDto);
        LOGGER.info("message sent "+ inspectionDto.toString());
    }
    public void sendMessage(InspectionDto inspectionDto){
        rabbitTemplate.convertAndSend(exchange , routingKey , inspectionDto);
        LOGGER.info("message sent "+ inspectionDto.toString());
    }
    public void sendMessage(SensorDto inspectionDto){
        rabbitTemplate.convertAndSend(exchange , routingKey , inspectionDto);
        LOGGER.info("message sent "+ inspectionDto.toString());
    }
    public void sendMessage(ServiceDto inspectionDto){
        rabbitTemplate.convertAndSend(exchange , routingKey , inspectionDto);
        LOGGER.info("message sent "+ inspectionDto.toString());
    }
    public void sendMessage(DaintreeDto inspectionDto){
        rabbitTemplate.convertAndSend(exchange , routingKey , inspectionDto);
        LOGGER.info("message sent "+ inspectionDto.toString());
    }
}

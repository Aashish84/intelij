package com.example.demo_rabbitmq.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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

    public void sendMessages(List<Map<String, Object>> msgList) {
        for (Map<String, Object> msg : msgList) {
            rabbitTemplate.convertAndSend(exchange, routingKey, msg);
            LOGGER.info("message sent " + msg);
        }
    }

    public void sendMessages(Map<String, Object> msg) {
        rabbitTemplate.convertAndSend(exchange, routingKey, msg);
        LOGGER.info("message sent " + msg);

    }
}

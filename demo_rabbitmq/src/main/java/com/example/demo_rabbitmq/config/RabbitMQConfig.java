package com.example.demo_rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    @Value("${rabbitmq.queue.name}")
    private String queue;
    @Value("${rabbitmq.exchange.name}")
    private String exchange;
    @Value("${rabbitmq.routing.key}")
    private String routingKey;
    @Bean
     public Queue queue(){
         return new Queue(queue , false);
     }
     @Bean
     public TopicExchange exchange(){
         return new TopicExchange(exchange);
     }
     @Bean
     public Binding binding(Queue queue , TopicExchange exchange){
        return BindingBuilder
                .bind(queue)
                .to(exchange)
                .with(routingKey);
     }
     @Bean
     public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
     }
     @Bean
     public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory , MessageConverter messageConverter){
         RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
         rabbitTemplate.setMessageConverter(messageConverter);
         return rabbitTemplate;
     }
}

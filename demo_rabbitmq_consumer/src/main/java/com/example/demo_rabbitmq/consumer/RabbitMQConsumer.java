package com.example.demo_rabbitmq.consumer;

import com.example.demo_rabbitmq.dto.InspectionDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RabbitMQConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQConsumer.class);
    @RabbitListener(queues = {"${rabbitmq.queue.name}"})
    public void consume(List<InspectionDto> inspectionDtos){
//        System.out.println(inspectionDtos.size());
//        for(InspectionDto inspectionDto : inspectionDtos){
//            LOGGER.info("recived message -> "+inspectionDto);
//        }
        if (inspectionDtos.size() == 1) {
            InspectionDto inspectionDto = inspectionDtos.get(0);
            LOGGER.warn("Received single message -> " + inspectionDto);
        } else {
            System.out.println(inspectionDtos.size());
            for (InspectionDto inspectionDto : inspectionDtos) {
                LOGGER.warn("Received message in batch -> " + inspectionDto);
            }
        }
    }
}

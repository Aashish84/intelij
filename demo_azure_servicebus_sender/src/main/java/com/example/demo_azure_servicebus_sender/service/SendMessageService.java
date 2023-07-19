package com.example.demo_azure_servicebus_sender.service;

import com.azure.messaging.servicebus.ServiceBusClientBuilder;
import com.azure.messaging.servicebus.ServiceBusMessage;
import com.azure.messaging.servicebus.ServiceBusSenderClient;
import org.springframework.stereotype.Service;

@Service
public class SendMessageService {
    private static final String CONNECTION_STRING = "Endpoint=sb://demo-accesssystems.servicebus.windows.net/;SharedAccessKeyName=test;SharedAccessKey=+wxFgQy3wsIJFw4R8fN5h8VQcsqgbmmA9+ASbF3ivJ8=;EntityPath=test";
    private static final String QUEUE_NAME = "test";

    public void sendMessage(String message) {
        ServiceBusSenderClient client = new ServiceBusClientBuilder()
                .connectionString(CONNECTION_STRING)
                .sender()
                .queueName(QUEUE_NAME)
                .buildClient();
        for (int i = 0; i < 45; i++) {
            client.sendMessage(new ServiceBusMessage("{\"id\":\""+i+"\"}"));
        }
        System.out.println("msg sent");
    }
}

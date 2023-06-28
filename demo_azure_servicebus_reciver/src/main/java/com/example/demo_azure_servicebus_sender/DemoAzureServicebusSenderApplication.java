package com.example.demo_azure_servicebus_sender;

import com.azure.messaging.servicebus.*;
import jakarta.jms.BytesMessage;
import jakarta.jms.ConnectionFactory;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@EnableJms
public class DemoAzureServicebusSenderApplication {
    private static final String CONNECTION_STRING = "Endpoint=sb://demo-accesssystems.servicebus.windows.net/;SharedAccessKeyName=test;SharedAccessKey=+wxFgQy3wsIJFw4R8fN5h8VQcsqgbmmA9+ASbF3ivJ8=;EntityPath=test";
    private static final String QUEUE_NAME = "test";
    private static final Logger LOGGER = LoggerFactory.getLogger(DemoAzureServicebusSenderApplication.class);
    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(DemoAzureServicebusSenderApplication.class, args);
    }
    @JmsListener(destination = QUEUE_NAME , containerFactory = "jmsListenerContainerFactory")
    public void receiveMessage(Message message) throws JMSException {
        BytesMessage bytesMessage = (BytesMessage) message;
        byte[] bytes = new byte[(int) bytesMessage.getBodyLength()];
        bytesMessage.readBytes(bytes);
        String text = new String(bytes);
        LOGGER.info("message received: {}",text);
    }

}

//        reciveMessage();

//    static void reciveMessage() throws InterruptedException {
//        CountDownLatch countDownLatch = new CountDownLatch(1);
//        ServiceBusProcessorClient client = new ServiceBusClientBuilder()
//                .connectionString(CONNECTION_STRING)
//                .processor()
//                .queueName(QUEUE_NAME)
//                .processMessage(context -> processMessage(context))
//                .processError(serviceBusErrorContext -> processError(serviceBusErrorContext , countDownLatch))
//                .buildProcessorClient();
//        System.out.println("starting process ");
//        client.start();
//    }
//    private static void processMessage(ServiceBusReceivedMessageContext context){
//        ServiceBusReceivedMessage message = context.getMessage();
//        System.out.printf("message  session : %s , Sequence : %s, contents : %s%n" , message.getMessageId() , message.getSequenceNumber() , message.getBody());
//    }
//    private static void processError(ServiceBusErrorContext context , CountDownLatch countDownLatch){   }

//        TimeUnit.SECONDS.sleep(100);
//        System.out.println("closing process");
//        client.close();

package com.example.demo_azure_servicebus_sender;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;

import javax.jms.BytesMessage;
import javax.jms.JMSException;
import javax.jms.Message;
import java.util.*;


@SpringBootApplication
@EnableJms
public class DemoAzureServicebusSenderApplication {
    private static final String QUEUE_NAME = "test";
    private static final Logger LOGGER = LoggerFactory.getLogger(DemoAzureServicebusSenderApplication.class);
    List<String> list = Collections.synchronizedList(new ArrayList<>());
    public static void main(String[] args){
        SpringApplication.run(DemoAzureServicebusSenderApplication.class, args);
//        new Timer().schedule(new TimerTask() {
//            @Override
//            public void run() {
//                DemoAzureServicebusSenderApplication app = new DemoAzureServicebusSenderApplication();
//                if(app.list.size()!=0){
//                    try {
//                        app.processData();
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                }
//            }
//        },0, 5000);
    }
    @JmsListener(destination = QUEUE_NAME , containerFactory = "jmsListenerContainerFactory")
    public void receiveMessage(Message message) throws JMSException, InterruptedException {

//        if(list.size() == 10 ){
//            processData();
//        }

        long jmsTimestamp = message.getJMSTimestamp();
        System.out.println("============="+ jmsTimestamp);
        BytesMessage bytesMessage = (BytesMessage) message;
        byte[] bytes = new byte[(int) bytesMessage.getBodyLength()];
        bytesMessage.readBytes(bytes);
        String text = new String(bytes);
//        list.add(text);
        LOGGER.info("message received: {}",text);
    }

    public void processData() throws InterruptedException {
            Thread.sleep(5000);
            System.out.println("******* data processed ******");
            list.clear();
    }
}

package com.example.binlog_mysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;


@SpringBootApplication
public class BinlogMysqlApplication {

    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext context = SpringApplication.run(BinlogMysqlApplication.class, args);
        BinLogRun binLogRun = context.getBean(BinLogRun.class);
        binLogRun.doSomething();
    }

}

//            if (data instanceof WriteRowsEventData || data instanceof UpdateRowsEventData) {
//                System.out.println(data);
//                System.out.println("Change detected: \n" + event.toString());
//                System.out.println("++++++++++++++++++");
//            }


//client.registerEventListener(new BinaryLogClient.EventListener(){
//    @Override
//    public void onEvent(Event event){}
//});

//  if (data instanceof WriteRowsEventData || data instanceof UpdateRowsEventData || data instanceof DeleteRowsEventData) {


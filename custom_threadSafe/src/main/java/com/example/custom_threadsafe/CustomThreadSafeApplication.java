package com.example.custom_threadsafe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class CustomThreadSafeApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(CustomThreadSafeApplication.class, args);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        Arrays.stream(beanDefinitionNames).forEach(System.out::println);
    }

}

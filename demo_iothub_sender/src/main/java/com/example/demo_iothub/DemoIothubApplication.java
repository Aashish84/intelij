package com.example.demo_iothub;

import com.microsoft.azure.sdk.iot.device.exceptions.IotHubClientException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class DemoIothubApplication {
    public static void main(String[] args) throws IotHubClientException, IOException {
        SpringApplication.run(DemoIothubApplication.class, args);
    }

}

package com.example.demo_iothub;

import com.microsoft.azure.sdk.iot.device.DeviceClient;
import com.microsoft.azure.sdk.iot.device.IotHubClientProtocol;
import com.microsoft.azure.sdk.iot.device.exceptions.IotHubClientException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class DemoIothubApplication {
    private static final String IOT_HUB_CONNECTION_STRING = "HostName=testhub-access-systems.azure-devices.net;DeviceId=testdevice-accesssystems;SharedAccessKey=roFMjlzQZEyW8Oox9q7zJeGYWvXKqaHMWDxk598eOXg=";
    public static void main(String[] args) throws IotHubClientException, IOException {
        SpringApplication.run(DemoIothubApplication.class, args);

        DeviceClient client = new DeviceClient(IOT_HUB_CONNECTION_STRING, IotHubClientProtocol.MQTT);
        MessageCallback  messageCallback = new MessageCallback();
        client.setMessageCallback(messageCallback, null);
        client.open(true);
        System.out.println("IoT Hub Data Consumer started. Waiting for messages...");
        System.out.println("Press ENTER to exit.");
        System.in.read();
        client.close();
    }

}

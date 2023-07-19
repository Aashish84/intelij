package com.example.demo_iothub.controller;

import com.microsoft.azure.sdk.iot.device.DeviceClient;
import com.microsoft.azure.sdk.iot.device.IotHubClientProtocol;
import com.microsoft.azure.sdk.iot.device.Message;
import com.microsoft.azure.sdk.iot.device.exceptions.IotHubClientException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
//    private static final String IOT_HUB_CONNECTION_STRING = "HostName=testhub-access-systems.azure-devices.net;DeviceId=testdevice-accesssystems;SharedAccessKey=roFMjlzQZEyW8Oox9q7zJeGYWvXKqaHMWDxk598eOXg=";
    private static final String IOT_HUB_CONNECTION_STRING = "HostName=testhub-access-systems.azure-devices.net;DeviceId=test-device_2;SharedAccessKey=1d0teV2Kv06NR50Q6IA5BWWEtvWQNZVbw69SIsVKeJ4=";

    @GetMapping("/test")
    public String sendMessage(@RequestParam int count) throws IotHubClientException, InterruptedException {
        DeviceClient client = new DeviceClient(IOT_HUB_CONNECTION_STRING, IotHubClientProtocol.MQTT);
        client.open(false);
        String msg2 = "{\n" +
                "    \"alertMessage\": \"quest 1? - No; quest 2? - No; \",\n" +
                "}";

        for (int i = 0; i < count; i++) {
//            Message messageIOT = new Message();
            client.sendEventAsync(new Message(" id " + i + " " + msg2), (message1, e, o) -> {
                if (e != null) {
                    System.out.println("Stat - " + e.getStatusCode());
                }
            }, null);
        }
        Thread.sleep(3000);
        client.close();
        return "message sent";
    }
}


//        ModuleClient client = new ModuleClient(IOT_HUB_CONNECTION_STRING , IotHubClientProtocol.MQTT);
//        Message m = new Message(msg);
//        client.sendEvent(m);
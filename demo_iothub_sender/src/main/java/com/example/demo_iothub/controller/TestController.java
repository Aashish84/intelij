package com.example.demo_iothub.controller;

import com.microsoft.azure.sdk.iot.device.DeviceClient;
import com.microsoft.azure.sdk.iot.device.IotHubClientProtocol;
import com.microsoft.azure.sdk.iot.device.Message;
import com.microsoft.azure.sdk.iot.device.ModuleClient;
import com.microsoft.azure.sdk.iot.device.exceptions.IotHubClientException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
//    private static final String IOT_HUB_CONNECTION_STRING = "HostName=testhub-access-systems.azure-devices.net;DeviceId=testdevice-accesssystems;ModuleId=module-1;SharedAccessKey=YigpFS3K+E/3ilJk7hlejGlx/ZspZNsHB+Z955gYjRk=";
    private static final String IOT_HUB_CONNECTION_STRING = "HostName=testhub-access-systems.azure-devices.net;DeviceId=testdevice-accesssystems;SharedAccessKey=j5Q2JOZTVDix6wGAC+CeNu7Mdt5mhWgabHHoPJjiJ7g=";
    @GetMapping("/test")
    public String sendMessage(@RequestParam("msg") String msg) throws IotHubClientException, InterruptedException {
        System.out.println("===================="+msg);
        DeviceClient client = new DeviceClient(IOT_HUB_CONNECTION_STRING, IotHubClientProtocol.MQTT);
//        ModuleClient client = new ModuleClient(IOT_HUB_CONNECTION_STRING , IotHubClientProtocol.MQTT);
//        Message m = new Message(msg);
        client.open(false);
//        client.sendEvent(m);
        client.sendEventAsync(new Message(msg), (message1, e, o) -> {
            System.out.println(message1+"********************");
            System.out.println("^^^^^^^^^^^^^^^"+e);
            System.out.println("^^^^^^^^^^^^^^^"+o);
            if(e!=null) {
                System.out.println("Stat - " + e.getStatusCode());
            }
        }, null);

//        Thread.sleep(10000);
        client.close();
        return "message sent";
    }
}

package com.example.demo_iothub;

import com.microsoft.azure.sdk.iot.device.IotHubMessageResult;
import com.microsoft.azure.sdk.iot.device.Message;

public class MessageCallback implements com.microsoft.azure.sdk.iot.device.MessageCallback {
    @Override
    public IotHubMessageResult onCloudToDeviceMessageReceived(Message message, Object o) {
        System.out.println("Received message: " + new String(message.getBytes(), Message.DEFAULT_IOTHUB_MESSAGE_CHARSET));
        return IotHubMessageResult.COMPLETE;
    }
}

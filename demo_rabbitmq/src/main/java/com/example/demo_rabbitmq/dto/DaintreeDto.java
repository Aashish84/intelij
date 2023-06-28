package com.example.demo_rabbitmq.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DaintreeDto {
    private int id;

    private String assetName;

    private String assetId;

    private String alertMessage;

    private String priority;

    private String alertTimestamp;

    private String category;

    private String status;

    private String updatedTimestamp;

    private String vdmsId;

    private String dockerName;

    private String locationId;

    private String locationName;

    private String buildingId;

    private String buildingName;

    private String floorId;
    private String iocType;
    private String floorName;

    private String iocId;

    private String unit;
    private String value;
}

//{
//        "alertMessage": "IOC_DAINTREE - test Update - ss - Fri 23 Jun 2023 15:15",
//        "alertType": "sensor_alert",
//        "alertedTimestamp": 1687513531158,
//        "assetId": "VDMS708_host_6e:06:22:d2:30:6c",
//        "assetName": "IOC_DAINTREE",
//        "buildingId": "c43c476a-a20e-11ed-8590-8131f3bfd037",
//        "buildingName": "Demo Building",
//        "category": "mobile",
//        "dockerName": "host",
//        "floorId": "d9da7d3e-a20e-11ed-8590-f7ef4e6bd4ab",
//        "floorName": "Demo Floor",
//        "iocType": "daintree",
//        "locationId": "47bf334a-a5e5-11ed-977d-fd6c5017a784",
//        "locationName": "Room 111",
//        "priority": "high",
//        "unit": "%",
//        "value": "50",
//        "vdmsId": "VDMS708",
//
//        /******** We are giving these extra details, if required u can use ************/
//
//        "primaryId": "Humidity",
//        "protocol": "my_devices",
//        "secondaryId": "a81758fffe05b9af",
//        "sensorId": "a81758fffe05b9af",
//        "sensorName": "test Update"
//}

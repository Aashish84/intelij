package com.example.demo_rabbitmq.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SensorDto {
    private Long id;
    private String primaryId;
    private String secondaryId;
    private String protocol;
    private String assetName;
    private String assetId;
    private String alertMessage;
    private String priority;
    private String alertTimestamp;
    private String category;

    private String updatedTimestamp;

    private String value;

    private String unit;

    private String vdmsId;

    private String dockerName;

    private String locationId;
    private String locationName;
    private String floorId;
    private String floorName;
    private String buildingId;
    private String buildingName;
    private String iocId;
    private String iocType;
}

//{
//        "alertMessage": "IOC_TEST_SENSOR - Room 617 - ss - Fri 23 Jun 2023 15:12",
//        "alertType": "sensor_alert",
//        "alertedTimestamp": 1687513337244,
//        "assetId": "VDMS708_host_00:10:7f:3c:fe:4f",
//        "assetName": "IOC_TEST_SENSOR",
//        "buildingId": "c43c476a-a20e-11ed-8590-8131f3bfd037",
//        "buildingName": "Demo Building",
//        "category": "temperature",
//        "dockerName": "host",
//        "floorId": "d9da7d3e-a20e-11ed-8590-f7ef4e6bd4ab",
//        "floorName": "Demo Floor",
//        "iocType": "sensor",
//        "locationId": "2ed75b5b-a5e6-11ed-977d-295591708373",
//        "locationName": "Breakfast Area",
//        "primaryId": "Cool Setting",
//        "priority": "medium",
//        "protocol": "pelican",
//        "secondaryId": "2S3-B8LD",
//        "unit": "°F",
//        "value": "67",
//        "vdmsId": "VDMS708",
//
//        /******** We are giving these extra details, if required u can use ************/
//
//        "sensorId": "2S3-B8LD",
//        "sensorName": "Room 617"
//}
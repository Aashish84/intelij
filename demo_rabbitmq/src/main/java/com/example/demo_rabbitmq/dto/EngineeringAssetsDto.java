package com.example.demo_rabbitmq.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EngineeringAssetsDto {
    String alertMessage;
    String alertType;
    Long alertTimestamp;
    String assetId;
    String assetName;
    String buildingId;
    String buildingName;
    String category;
    String dockerName;
    String floorId;
    String floorName;
    String iocType;
    String locationId;
    String locationName;
    String priority;
    String unit;
    String value;
    String vdmsId;
    String iocId;
    String status;
    String updatedTimestamp;

}
//{
//        "alertMessage": "IOC_TEST_MANAGE_ASSETS - Room 601 - aaaaaaa - Fri 23 Jun 2023 14:57",
//        "alertType": "sensor_alert",
//        "alertedTimestamp": 1687512446114,
//        "assetId": "VDMS708_host_00:23:24:7e:54:c9",
//        "assetName": "IOC_TEST_MANAGE_ASSETS",
//        "buildingId": "c43c476a-a20e-11ed-8590-8131f3bfd037",
//        "buildingName": "Demo Building",
//        "category": "photo_display",
//        "dockerName": "host",
//        "floorId": "d9da7d3e-a20e-11ed-8590-f7ef4e6bd4ab",
//        "floorName": "Demo Floor",
//        "iocType": "engineering_asset",
//        "locationId": "fcc42c2d-a20e-11ed-8590-b197fe04a25b",
//        "locationName": "Conference Room",
//        "priority": "medium",
//        "unit": "°F",
//        "value": "69",
//        "vdmsId": "VDMS708",
//
//        /******** We are giving these extra details, if required u can use ************/
//        "primaryId": "Cool Setting",
//        "protocol": "pelican",
//        "secondaryId": "2S3-B8KE",
//        "sensorId": "2S3-B8KE",
//        "sensorName": "Room 601"
//
//}

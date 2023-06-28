package com.example.demo_rabbitmq.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ServiceDto {
    int id;
    private String itemType;
    private String locationName;
    private String locationId;
    private String serviceName;

    private String alertMessage;

    private String result;

    private String status;

    private String priority;
    private String recordChecklistId;
    private  String assigneeName;
    private  String assigneeEmail;
    private Long completedDate;
    private  Long updatedTimestamp;

    private  String category;
    String vdmsId;
    private Long requestedDate;
    private  String dockerName;
    List<String> workorderId;
    private String assetId;
    private String assetName;
    private String floorId;
    private String floorName;
    private String buildingId;
    private String buildingName;
    private String iocId;
    private String iocType;
}
//{
//        "alertMessage":"testingggggggggggggggggggg",
//        "alertType":"service_request_completed",
//        "assetId":"VDMS708_host_00:03:7f:12:c6:15",
//        "assetName":"Deepa Laptop",
//        "assigneeEmail":"deepa.salian@sclera.io",
//        "assigneeName":"Deepa M Salian",
//        "buildingId":"c43c476a-a20e-11ed-8590-8131f3bfd037",
//        "buildingName":"Demo Building",
//        "category":"fire_alarm",
//        "completedDate":1687512201841,
//        "dockerName":"host",
//        "floorId":"d9da7d3e-a20e-11ed-8590-f7ef4e6bd4ab",
//        "floorName":"Demo Floor",
//        "iocType":"service",
//        "itemType":"asset",
//        "locationId":"2ed75b5b-a5e6-11ed-977d-295591708373",
//        "locationName":"Breakfast Area",
//        "priority":"low",
//        "recordChecklistId":"719d787c-11a7-11ee-99b4-bb1ef30200be",
//        "requestedDate":1687512135837,
//        "serviceName":"Service Fire Alaram",
//        "status":"completed",
//        "vdmsId":"VDMS708",
//        "workorderId":[
//        "730449"
//        ]
//}
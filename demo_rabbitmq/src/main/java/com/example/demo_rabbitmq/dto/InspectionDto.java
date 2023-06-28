package com.example.demo_rabbitmq.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class InspectionDto {
    private int id;

    String itemType;

    String locationId;

    String locationName;

    String alertMessage;

    String result;

    String status;

    String priority;

    String inspectionName;

    String inspectionId;

    String recordChecklistId;

    String assigneeName;

    String assigneeEmail;

    String dueDate;

    String completedDate;

    String updatedTimestamp;

    String category;

    String vdmsId;

    String dockerName;

    private List<String> workorderId;

    String startDate;

    String assetId;

    String assetName;

    String floorId;

    String floorName;

    private String buildingId;

    private String buildingName;

    private String iocId;
    String iocType;
}

//{
//        "alertMessage": "quest 1? - No; quest 2? - No; ",
//        "alertType": "inspection_failed",
//        "assetId": "VDMS708_test_FIRE_EXTINGUISHER_10lb_ABC__Room_101_108272910196778",
//        "assetName": "FIRE EXTINGUISHER (10lb. ABC)_Room  101",
//        "assigneeEmail": "ashwin.rao@accessonline.io",
//        "assigneeName": "Ashwin",
//        "buildingId": "c43c476a-a20e-11ed-8590-8131f3bfd037",
//        "buildingName": "Demo Building",
//        "category": "meeting_room",
//        "completedDate": 1687511527213,
//        "dockerName": "www",
//        "dueDate": 1688063400000,
//        "floorId": "d9da7d3e-a20e-11ed-8590-f7ef4e6bd4ab",
//        "floorName": "Demo Floor",
//        "inspectionId": "58da94ca-11a5-11ee-a6f5-ad3661f004b6",
//        "inspectionName": "IOC inspection",
//        "iocType": "inspection",
//        "itemType": "asset",
//        "locationId": "aeaf773a-a5e2-11ed-977d-df6d040d6454",
//        "locationName": "Room 101",
//        "priority": "medium",
//        "recordChecklistId": "58f23b93-11a5-11ee-a6f5-0b4c3177d492",
//        "result": "Fail",
//        "startDate": 1687511235461,
//        "status": "completed",
//        "vdmsId": "VDMS708",
//        "workorderId": [
//        "730445"
//        ]
//        }

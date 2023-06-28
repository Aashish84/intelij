package com.example.demo_rabbitmq.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class InspectionDto {
    int id;

    String assetOrLocationName;

    String assetOrLocationId;

    String itemType;
    String location;

    String locationName;

    String locationId;

    String description;

    String result;

    String status;

    String priority;

    String inspectionName;

    String inspectionId;

    String recordChecklistId;

    String assigneeName;

    String assigneeEmail;

    Long dueDate;

    Long completedDate;

    Long timestamp;

    String category;

    String vdmsId;

    String buildingId;

    String buildingName;

    String floorId;

    String floorName;

    String dockerName;

    String alertType;

    String propertyName;
}

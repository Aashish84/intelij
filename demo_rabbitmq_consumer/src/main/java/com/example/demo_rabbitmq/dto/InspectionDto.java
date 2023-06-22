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
}

package com.example.demo_rabbitmq.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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

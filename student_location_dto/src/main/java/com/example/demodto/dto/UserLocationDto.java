package com.example.demodto.dto;

import lombok.Data;

@Data
public class UserLocationDto {
    private Long userId;
    private String email;
    private String place;
    private double longitude;
    private double latitude;

}

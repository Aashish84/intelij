package com.asis.blog.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DummyDto {
    private Long addressId;
    private String country;
    private String province;
    private String district;
    public DummyDto(Long addressId){
        this.addressId = addressId;
    }
}

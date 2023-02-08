package com.asis.blog.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDto {
    private Long addressId;
    private String country;
    private String province;
    private String district;
}

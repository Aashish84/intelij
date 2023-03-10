package com.asis.blog.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter

public class AddressDto {
    private Long addressId;
    private String country;
    private String province;
    private String district;

    @Override
    public String toString() {
        return "{" +
                "\"addressId\":\"" + addressId + "\""+
                ","+ "\"country\":\"" + country + "\""+
                ","+ "\"province\":\"" + province + "\""+
                ","+ "\"district\":\"" + district + "\""+
                "}";
    }

}

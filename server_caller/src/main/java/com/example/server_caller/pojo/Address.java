package com.example.server_caller.pojo;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Address {
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

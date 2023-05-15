package com.example.demo_pdf.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class Series {
    private String countryName;
    private double[] data;
}

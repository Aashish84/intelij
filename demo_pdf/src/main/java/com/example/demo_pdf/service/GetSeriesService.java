package com.example.demo_pdf.service;

import com.example.demo_pdf.pojo.Series;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetSeriesService {
    public List<Series> getSeries(){
        List<Series> list = new ArrayList<>();
        list.add(new Series()
                .setCountryName("Tokyo")
                .setData(new double[]{49.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5, 216.4,
                        194.1, 95.6, 54.4})
        );
        list.add(new Series()
                .setCountryName("New York")
                .setData(new double[]{83.6, 78.8, 98.5, 93.4, 106.0, 84.5, 105.0, 104.3, 91.2, 83.5,
                        106.6, 92.3})
        );
        list.add(new Series()
                .setCountryName("London")
                .setData(new double[]{48.9, 38.8, 39.3, 41.4, 47.0, 48.3, 59.0, 59.6, 52.4, 65.2, 59.3,
                        51.2})
        );
        list.add(new Series()
                .setCountryName("Berlin")
                .setData(new double[]{42.4, 33.2, 34.5, 39.7, 52.6, 75.5, 57.4, 60.4, 47.6, 39.1, 46.8,
                        51.1})
        );
        return  list;
    }
}

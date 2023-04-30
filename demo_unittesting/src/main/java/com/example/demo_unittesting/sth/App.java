package com.example.demo_unittesting.sth;

import org.springframework.stereotype.Component;

@Component
public class App {
    public boolean isRectangleAreaOdd(Rectangle rectangle){
        rectangle.setBreadth(2);
        rectangle.setLength(2);
        int area = rectangle.getArea();
        return area % 2 == 0;
    }
}

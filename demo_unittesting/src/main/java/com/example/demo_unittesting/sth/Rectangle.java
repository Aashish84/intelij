package com.example.demo_unittesting.sth;

import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Component
public class Rectangle {
    private int length;
    private int breadth;
    public int getArea(){
        return this.length*this.breadth;
    }
}

package com.example.demo_unittesting.sth;

import com.example.demo_unittesting.sth.Rectangle;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class RectangleTest {
    @Autowired
    private Rectangle rectangle;
    @Test
    public void basicAreaTest(){
        rectangle.setLength(2);
        rectangle.setBreadth(2);
        assertEquals(4,rectangle.getArea(),"basic area test error");
    }
}
package com.example.demo_unittesting.sth;

import com.example.demo_unittesting.sth.App;
import com.example.demo_unittesting.sth.Rectangle;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AppTest {
    @Autowired
    private App app;
//    private final Rectangle rectangle = mock(Rectangle.class);
    private static Rectangle rectangle;
    @BeforeAll
    static void setup(){
        rectangle = mock(Rectangle.class);
    }
    @Test
    public void testIsRectangleAreaOdd(){
        when(rectangle.getArea()).thenReturn(4);

        boolean result = app.isRectangleAreaOdd(rectangle);
        assertTrue(result);
    }
}
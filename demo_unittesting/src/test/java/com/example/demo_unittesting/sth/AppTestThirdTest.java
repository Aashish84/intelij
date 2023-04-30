package com.example.demo_unittesting.sth;

import com.example.demo_unittesting.sth.App;
import com.example.demo_unittesting.sth.Rectangle;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doReturn;

@SpringBootTest
public class AppTestThirdTest {
    @Autowired
    private App app;
    @Mock
    private Rectangle rectangle;
    @Test
    public void testIsRectangleAreaOdd(){
//        when(rectangle.getArea()).thenReturn(4);
        doReturn(4).when(rectangle).getArea();
        assertTrue(app.isRectangleAreaOdd(rectangle));
    }
}

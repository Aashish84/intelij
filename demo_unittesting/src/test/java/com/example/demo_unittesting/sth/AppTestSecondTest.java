package com.example.demo_unittesting.sth;

import com.example.demo_unittesting.sth.App;
import com.example.demo_unittesting.sth.Rectangle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AppTestSecondTest {
    @Autowired
    private App app;
    @Mock
    private Rectangle rectangle;
    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void testIsRectangleAreaOdd(){
        when(rectangle.getArea()).thenReturn(4);

        boolean result = app.isRectangleAreaOdd(rectangle);
        assertTrue(result);
    }
}
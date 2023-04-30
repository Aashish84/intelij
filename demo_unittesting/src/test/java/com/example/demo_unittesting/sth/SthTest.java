package com.example.demo_unittesting.sth;

import com.example.demo_unittesting.sth.Sth;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class SthTest {
    @Autowired
    private Sth ob;
    @Test
    public void basicAddition(){
        assertEquals(2,ob.add(1,1),"basic addition error");
    }
    @Test
    public void negativeAddition(){
        System.out.println();
        assertEquals(-1,ob.add(1,-2),"negative value additon error");
    }
    @Test
    public void nullTest(){
        assertThrows(Exception.class, this::invokeAddMethod , "null testError");
        assertThrows(Exception.class , () -> ob.add(null,null) , "null test error");
    }
    private void invokeAddMethod(){
        ob.add(null,null);
    }
    @Test
    public void whenOneParameterNullThenAddShouldWork(){
        assertEquals(2,ob.add(null,2),"singleNullTest Error");
        assertEquals(1,ob.add(1,null),"singleNullTest Error");
    }
}

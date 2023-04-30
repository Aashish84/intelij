package com.example.demo_unittesting.sth;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class DemoListTest {
//    private DemoList demoList;
//    @BeforeAll
//    void setup(){
//        demoList = new DemoList();
//    }
    @Test
    public void testOneHourOperation(){
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);

        DemoList.oneHourOperation(1, 2, 3);

//        Assertions.assertEquals(expected, toSendEmail);
    }
}
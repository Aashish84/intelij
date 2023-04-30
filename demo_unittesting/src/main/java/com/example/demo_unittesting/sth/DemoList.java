package com.example.demo_unittesting.sth;

import java.util.ArrayList;
import java.util.List;

public class DemoList {
    public static void main(String[] args) {
        oneHourOperation(1,2,3);
    }
    public static void oneHourOperation(int...a){
        List<Integer> toSendEmail = new ArrayList<>();
        for(int i : a){
            toSendEmail.add(i);
        }
//        toSendEmail.forEach(x -> System.out.println(x));
        toSendEmail.forEach(System.out::println);
    }
}

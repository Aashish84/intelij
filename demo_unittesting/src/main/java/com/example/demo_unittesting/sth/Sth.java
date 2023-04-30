package com.example.demo_unittesting.sth;

import org.springframework.stereotype.Component;

@Component
public class Sth {
    public Integer add(Integer a , Integer b){
        if(a==null && b==null) throw new NullPointerException("both null value");
        if(a == null) return b;
        if(b == null) return a;
        return a + b;
    }
}

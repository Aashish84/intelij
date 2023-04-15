package com.example.onetomany_demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "testty")
public class Testty {
    @Column(name = "test")
    private String test;

    @Column(name = "roll")
    private Integer roll;

    public String getTest() {
        return this.test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public Integer getRoll() {
        return this.roll;
    }

    public void setRoll(Integer roll) {
        this.roll = roll;
    }
}

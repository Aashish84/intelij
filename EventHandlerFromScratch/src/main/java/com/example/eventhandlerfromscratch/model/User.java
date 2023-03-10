package com.example.eventhandlerfromscratch.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {
    private int id;
    private String name;
    private String email;
    private int age;
    private float salary;
}

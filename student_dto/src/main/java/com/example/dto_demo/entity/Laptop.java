package com.example.dto_demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Laptop {

    @Id
    private int id;
    private String model;
}

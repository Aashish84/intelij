package com.example.test.service;

import com.example.test.entity.Laptop;

import java.util.List;

public interface LaptopService {
    List<Laptop> getAllLaptop();
    Laptop saveLaptop(Laptop laptop);
}

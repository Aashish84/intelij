package com.example.onetomany_demo.service;

import com.example.onetomany_demo.entity.Test;

import java.util.List;

public interface TestService {
    List<Test> allTest();
    Test save(Test test);
}

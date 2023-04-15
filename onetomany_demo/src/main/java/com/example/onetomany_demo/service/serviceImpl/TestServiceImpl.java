package com.example.onetomany_demo.service.serviceImpl;

import com.example.onetomany_demo.entity.Test;
import com.example.onetomany_demo.reporitory.TestRepository;
import com.example.onetomany_demo.service.TestService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class TestServiceImpl implements TestService {
    private final TestRepository testRepository;
    @Override
    public List<Test> allTest() {
        return testRepository.findAll();
    }

    @Override
    public Test save(Test test) {
        return testRepository.save(test);
    }
}

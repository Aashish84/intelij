package com.example.onetomany_demo.service.serviceImpl;

import com.example.onetomany_demo.reporitory.TestVdmsDeviceRepository;
import com.example.onetomany_demo.service.TestVdmsDevice;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class TestVdmsDeviceImpl implements TestVdmsDevice {
    private final TestVdmsDeviceRepository repository;
    @Override
    public List<com.example.onetomany_demo.entity.TestVdmsDevice> getAllCustomer() {
        return repository.findAll();
    }

    @Override
    public com.example.onetomany_demo.entity.TestVdmsDevice saveCustomer(com.example.onetomany_demo.entity.TestVdmsDevice testVdmsDevice) {
        return repository.save(testVdmsDevice);
    }
}

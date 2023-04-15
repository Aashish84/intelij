package com.example.onetomany_demo.service;

import java.util.List;

public interface TestVdmsDevice {
    List<com.example.onetomany_demo.entity.TestVdmsDevice> getAllCustomer();
    com.example.onetomany_demo.entity.TestVdmsDevice saveCustomer(com.example.onetomany_demo.entity.TestVdmsDevice testVdmsDevice);
}

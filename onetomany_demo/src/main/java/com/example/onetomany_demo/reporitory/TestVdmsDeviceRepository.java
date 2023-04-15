package com.example.onetomany_demo.reporitory;

import com.example.onetomany_demo.entity.TestVdmsDevice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestVdmsDeviceRepository extends JpaRepository<TestVdmsDevice, String> {
}

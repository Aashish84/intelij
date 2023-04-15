package com.example.test.service.serviceImpl;

import com.example.test.entity.Laptop;
import com.example.test.repository.LaptopRepository;
import com.example.test.service.LaptopService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class LaptopServiceImpl implements LaptopService {
    private final LaptopRepository laptopRepository;
    @Override
    public List<Laptop> getAllLaptop() {
        return laptopRepository.findAll();
    }

    @Override
    public Laptop saveLaptop(Laptop laptop) {
        return laptopRepository.save(laptop);
    }
}

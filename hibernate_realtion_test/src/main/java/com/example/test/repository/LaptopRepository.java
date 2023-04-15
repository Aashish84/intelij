package com.example.test.repository;

import com.example.test.entity.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaptopRepository extends JpaRepository<Laptop , Long> {
}

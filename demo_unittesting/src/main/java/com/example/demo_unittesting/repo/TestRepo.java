package com.example.demo_unittesting.repo;

import com.example.demo_unittesting.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepo extends JpaRepository<Test,Long> {
}

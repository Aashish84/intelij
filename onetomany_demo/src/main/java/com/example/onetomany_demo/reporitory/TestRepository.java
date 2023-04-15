package com.example.onetomany_demo.reporitory;

import com.example.onetomany_demo.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test , Integer> {
}

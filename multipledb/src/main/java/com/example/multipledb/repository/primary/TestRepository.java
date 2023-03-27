package com.example.multipledb.repository.primary;

import com.example.multipledb.entity.primary.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test , Long> {
}

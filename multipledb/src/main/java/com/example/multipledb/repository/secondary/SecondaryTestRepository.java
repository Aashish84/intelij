package com.example.multipledb.repository.secondary;

import com.example.multipledb.entity.secondary.SecondaryTest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecondaryTestRepository extends JpaRepository<SecondaryTest , Long> {
}

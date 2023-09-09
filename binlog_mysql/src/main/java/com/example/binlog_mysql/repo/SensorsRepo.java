package com.example.binlog_mysql.repo;

import com.example.binlog_mysql.models.Sensors;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorsRepo extends JpaRepository<Sensors , Long> {
}

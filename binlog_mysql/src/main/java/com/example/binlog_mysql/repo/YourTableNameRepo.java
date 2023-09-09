package com.example.binlog_mysql.repo;

import com.example.binlog_mysql.models.YourTableName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface YourTableNameRepo extends JpaRepository<YourTableName, Integer> {
}

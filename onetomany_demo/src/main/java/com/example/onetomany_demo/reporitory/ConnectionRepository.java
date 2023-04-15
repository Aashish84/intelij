package com.example.onetomany_demo.reporitory;

import com.example.onetomany_demo.entity.Connection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConnectionRepository extends JpaRepository<Connection, String> {
}

package com.example.demo_security_v3.repo;

import com.example.demo_security_v3.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role , Long> {
}

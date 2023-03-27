package com.example.multipledb.repository.primary;

import com.example.multipledb.entity.primary.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin , Long> {
}

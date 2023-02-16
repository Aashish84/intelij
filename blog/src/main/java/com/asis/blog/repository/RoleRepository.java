package com.asis.blog.repository;

import com.asis.blog.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role , Long> {
}

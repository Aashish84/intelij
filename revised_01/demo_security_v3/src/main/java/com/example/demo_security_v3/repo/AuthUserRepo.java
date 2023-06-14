package com.example.demo_security_v3.repo;

import com.example.demo_security_v3.entity.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthUserRepo extends JpaRepository<AuthUser, Long> {
    Optional<AuthUser> findByEmail(String email);
}

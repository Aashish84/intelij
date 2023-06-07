package com.example.jwt_revised_01.repo;

import com.example.jwt_revised_01.entity.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthUserRepo extends JpaRepository<AuthUser,Long> {
    Optional<AuthUser> findByEmail(String email);
}
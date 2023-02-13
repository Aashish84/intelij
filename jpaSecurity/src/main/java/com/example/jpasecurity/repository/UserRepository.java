package com.example.jpasecurity.repository;

import com.example.jpasecurity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User , Long> {
    Optional<User> findByUserName(String userName);
}

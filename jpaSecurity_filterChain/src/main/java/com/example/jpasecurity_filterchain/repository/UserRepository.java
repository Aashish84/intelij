package com.example.jpasecurity_filterchain.repository;

import com.example.jpasecurity_filterchain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User , Long> {
    Optional<User> findByUserName(String username);

}

package com.example.multipledb.controller;

import com.example.multipledb.entity.primary.Admin;
import com.example.multipledb.entity.secondary.User;
import com.example.multipledb.repository.primary.AdminRepository;
import com.example.multipledb.repository.secondary.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class SaveTest {
    private final AdminRepository adminRepository;
    private final UserRepository userRepository;
    @GetMapping("/admin")
    public List<Admin> get(){
        Admin admin = new Admin();
        admin.setName("admin");
        admin.setEmail("admin@admin.com");
        adminRepository.save(admin);
        return adminRepository.findAll();
    }
    @GetMapping("/user")
    public List<User> getAllUser(){
        User user = new User();
        user.setName("user");
        user.setEmail("user@user.com");
        userRepository.save(user);
        return userRepository.findAll();
    }
}

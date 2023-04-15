package com.example.test.service;

import com.example.test.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();
    User saveUser(User user);
}

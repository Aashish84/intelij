package com.example.jpasecurity.service;

import com.example.jpasecurity.entity.User;

import java.util.List;

public interface UserService {
    List<User> allUser();
    User saveUser(User user);
}

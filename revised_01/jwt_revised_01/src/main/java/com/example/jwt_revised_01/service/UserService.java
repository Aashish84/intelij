package com.example.jwt_revised_01.service;

import com.example.jwt_revised_01.entity.User;

import java.util.List;

public interface UserService {
    List<User> allUser();
    User saveUser(User user);
}

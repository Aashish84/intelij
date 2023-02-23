package com.example.server01.service;

import com.example.server01.entity.User;
import java.util.List;

public interface UserService {
    List<User> allUser();
    User addUser(User user);
}

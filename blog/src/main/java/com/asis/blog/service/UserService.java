package com.asis.blog.service;

import com.asis.blog.dto.UserDto;
import com.asis.blog.entity.User;

import java.util.List;

public interface UserService {
    List<UserDto> getAllUser();
    UserDto addUser(User user);
}

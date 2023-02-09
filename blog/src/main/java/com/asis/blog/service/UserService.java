package com.asis.blog.service;

import com.asis.blog.dto.UserDto;
import com.asis.blog.entity.User;
import com.asis.blog.exception.CustomException;

import java.util.List;

public interface UserService {
    List<UserDto> getAllUser();
    UserDto addUser(User user);
    String deleteUser(Long id);
    UserDto updateUser(Long id , User user) throws CustomException;
}

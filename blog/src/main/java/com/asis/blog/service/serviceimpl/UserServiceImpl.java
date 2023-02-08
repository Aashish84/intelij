package com.asis.blog.service.serviceimpl;

import com.asis.blog.dto.UserDto;
import com.asis.blog.entity.User;
import com.asis.blog.mapper.UserMapper;
import com.asis.blog.repository.UserRepository;
import com.asis.blog.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper = UserMapper.INSTANCE;
    @Override
    public List<UserDto> getAllUser() {
        List<User> allUser = userRepository.findAll();
        return userMapper.entitiesToDtos(allUser);
    }
    @Override
    public UserDto addUser(User user) {
//        User user = UserMapper.INSTANCE.dtoToEntity(userDto);
        User newUser = userRepository.save(user);
        return userMapper.entityToDto(newUser);
    }
}

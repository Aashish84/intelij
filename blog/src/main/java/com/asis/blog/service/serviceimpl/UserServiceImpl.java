package com.asis.blog.service.serviceimpl;

import com.asis.blog.dto.UserDto;
import com.asis.blog.entity.User;
import com.asis.blog.exception.CustomException;
import com.asis.blog.mapper.UserMapper;
import com.asis.blog.repository.UserRepository;
import com.asis.blog.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

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

    @Override
    public String deleteUser(Long id) {
        userRepository.deleteById(id);
        return "user deleted of id : "+id;
    }

    @Override
    public UserDto updateUser(Long id, User user) throws CustomException {
        Optional<User> byId = userRepository.findById(id);
        if(byId.isPresent()){
            user.setAddress(byId.get().getAddress());
            user.setBlogs(byId.get().getBlogs());
            user.setId(byId.get().getId());
            return userMapper.entityToDto(userRepository.save(user));

        }

        throw new CustomException("could not of id : "+id);
    }
}

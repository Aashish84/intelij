package com.example.demodto.service;

import com.example.demodto.dto.UserLocationDto;
import com.example.demodto.model.User;
import com.example.demodto.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<UserLocationDto> getAllUserLocation(){

//        List<UserLocationDto> result = new ArrayList<>();
//        List<User> all = userRepository.findAll();
//        for(User user : all){
//            UserLocationDto userLocationDto = entityToDto(user);
//            result.add(userLocationDto);
//        }
//        return result;

        return userRepository.findAll()
                .stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());

    }

    private UserLocationDto entityToDto(User user){
        UserLocationDto userLocationDto = new UserLocationDto();

        userLocationDto.setUserId(user.getId());
        userLocationDto.setEmail(user.getEmail());
        userLocationDto.setPlace(user.getLocation().getPlace());
        userLocationDto.setLatitude(user.getLocation().getLatitude());
        userLocationDto.setLongitude(user.getLocation().getLongitude());

        return userLocationDto;
    }
}

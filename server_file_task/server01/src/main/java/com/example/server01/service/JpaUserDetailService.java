package com.example.server01.service;

import com.example.server01.entity.SecurityUser;
import com.example.server01.entity.User;
import com.example.server01.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JpaUserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    public JpaUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userByName = userRepository.findByUserName(username);
        return userByName
                .map(SecurityUser::new)
                .orElseThrow(() -> new UsernameNotFoundException("user not found of name "+username));
    }
}

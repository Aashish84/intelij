package com.example.jpasecurity_filterchain.service;

import com.example.jpasecurity_filterchain.entity.SecurityUser;
import com.example.jpasecurity_filterchain.entity.User;
import com.example.jpasecurity_filterchain.repository.UserRepository;
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
        Optional<User> byUserName = userRepository.findByUserName(username);
        System.out.println(byUserName.get().getUserName());
        return byUserName.map(SecurityUser::new)
                .orElseThrow(()->new UsernameNotFoundException("user not found of user name : "+username));
    }
}

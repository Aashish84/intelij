package com.example.jpasecurity.service;

import com.example.jpasecurity.entity.SecurityUser;
import com.example.jpasecurity.entity.User;
import com.example.jpasecurity.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JpaUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public JpaUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(username+" === from loadUserByUsername");
        Optional<User> byUserName = userRepository.findByUserName(username);
        if(!byUserName.isPresent()){
            throw new UsernameNotFoundException("user not found :"+username);
        }
        SecurityUser securityUser = new SecurityUser(byUserName.get());
        return securityUser;
//        return userRepository.findByUserName(username)
//                .map(SecurityUser::new)
//                .orElseThrow(()->new UsernameNotFoundException("user not found :"+username));
    }
}

package com.example.demo_security_v3.service;

import com.example.demo_security_v3.config.AuthUserDetails;
import com.example.demo_security_v3.entity.AuthUser;
import com.example.demo_security_v3.repo.AuthUserRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class AuthUserDetailsService implements UserDetailsService {
    private final AuthUserRepo authUserRepo;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<AuthUser> byEmail = authUserRepo.findByEmail(email);
        return byEmail
                .map(AuthUserDetails::new)
                .orElseThrow(()->new UsernameNotFoundException("user not found or email"+email));
    }
}

package com.example.jwt_revised_01.service.serviceimpl;

import com.example.jwt_revised_01.config.SecurityUserDetails;
import com.example.jwt_revised_01.entity.AuthUser;
import com.example.jwt_revised_01.repo.AuthUserRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomUserDetailService implements UserDetailsService {
    private final AuthUserRepo authUserRepo;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<AuthUser> userByEmail = authUserRepo.findByEmail(email);
        return userByEmail.map(SecurityUserDetails::new)
                .orElseThrow(()->new UsernameNotFoundException("user not found of email"+email));
    }
}

// security file

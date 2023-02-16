package com.asis.blog.service.serviceimpl;

import com.asis.blog.entity.SecurityUser;
import com.asis.blog.entity.User;
import com.asis.blog.repository.UserRepository;
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
        Optional<User> userByName = userRepository.findByName(username);
        return userByName.map(SecurityUser::new)
                .orElseThrow(() -> new UsernameNotFoundException("user not found of name :"+username));
    }
}

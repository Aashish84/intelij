package com.example.jwt_revised_01.config;

import com.example.jwt_revised_01.entity.AuthUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class SecurityUserDetails implements UserDetails {
    private final String name;
    private final String password;
    private final List<GrantedAuthority> authorities;

    public SecurityUserDetails(AuthUser user) {
        this.name = user.getEmail();
        this.password = user.getPassword();
        List<GrantedAuthority> tempAuth = new ArrayList<>();
        user.getAuthUserRoles().forEach(e -> tempAuth.add(new SimpleGrantedAuthority(e.getRole())));
        this.authorities = tempAuth;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

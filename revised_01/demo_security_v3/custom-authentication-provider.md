### custom authentication provider [link](https://www.baeldung.com/spring-security-authentication-provider)

#### usecase:
Spring Security provides a variety of options for performing authentication. These options follow a simple contract; an Authentication request is processed by an AuthenticationProvider, and a fully authenticated object with full credentials is returned.

The standard and most common implementation is the DaoAuthenticationProvider, which retrieves the user details from a simple, read-only user DAO, the UserDetailsService. This User Details Service only has access to the username in order to retrieve the full user entity, which is enough for most scenarios.

More custom scenarios will still need to access the full Authentication request to be able to perform the authentication process. For example, when authenticating against some external, third party service (such as Crowd), both the username and password from the authentication request will be necessary.

## SecurityConfig
```java
package com.example.demo_security_v3.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@AllArgsConstructor
public class SecurityConfig {
    private final CustomAuthenticationProvider customAuthenticationProvider;
    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity httpSecurity) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = httpSecurity.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.authenticationProvider(customAuthenticationProvider);
        return authenticationManagerBuilder.build();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/register").permitAll();
                    auth.anyRequest().authenticated();
                })
                .formLogin(Customizer.withDefaults())
                .build();
    }
}
```
## CustomAuthenticationProvider class
```java
package com.example.demo_security_v3.config;

import com.example.demo_security_v3.entity.AuthUser;
import com.example.demo_security_v3.repo.AuthUserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider {
    private final PasswordEncoder encoder;
    private final AuthUserRepo authUserRepo;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();
        String password = authentication.getCredentials().toString();
        AuthUser authUser = authUserRepo.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("user " + email + " not found"));
        List<GrantedAuthority> temp = new ArrayList<>();
        authUser.getRoles().forEach(e -> temp.add(new SimpleGrantedAuthority(e.getRole())));

        if(encoder.matches(password , authUser.getPassword()))
            return new UsernamePasswordAuthenticationToken(email , password , temp);
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
```

## PasswordEncoder config
```java
package com.example.demo_security_v3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordEncoderConfig {
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}

/*
 * password encoder is in separate configuration class to avoid circular dependency error
 * */
```
### Security config

```java

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@AllArgsConstructor
public class SecurityConfig {
    private final AuthUserDetailsService authUserDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
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

    @Bean
    public AuthenticationProvider authenticationProvider(PasswordEncoder passwordEncoder) {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(authUserDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder);
        return authenticationProvider;
    }
}
/*  ***AuthenticationProvider Needed***
 *  If no AuthenticationProvider is set then throws exception
 *      No AuthenticationProvider found for org.springframework.security.authentication.UsernamePasswordAuthenticationToken
 * */
```

#### Authentication provider [details here](https://www.baeldung.com/spring-security-authentication-provider)
In Spring Security, an authentication provider is responsible for authenticating users during the authentication process. It verifies the credentials provided by the user and determines whether the user should be granted access or not.

Spring Security provides several built-in implementations of the AuthenticationProvider interface:

`DaoAuthenticationProvider`: This provider is commonly used with a database-backed UserDetailsService. It retrieves user details from the data source and performs authentication by checking the provided credentials against the stored password.

`LdapAuthenticationProvider`: This provider is used for authentication against an LDAP (Lightweight Directory Access Protocol) server. It authenticates users by connecting to the LDAP server and verifying their credentials.

`JwtAuthenticationProvider`: This provider is used for authentication with JSON Web Tokens (JWTs). It validates and verifies the JWTs presented by the user.

`OpenIDAuthenticationProvider`: This provider is used for authentication with OpenID providers. It verifies the OpenID authentication response and validates the user's identity.

### authUserDetailsService

```java

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
                .orElseThrow(() -> new UsernameNotFoundException("user not found or email" + email));
    }
}

```

### authUserDetails

```java
package com.example.demo_security_v3.config;

import com.example.demo_security_v3.entity.AuthUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AuthUserDetails implements UserDetails {
    private final AuthUser authUser;
    public AuthUserDetails(AuthUser authUser){
        this.authUser = authUser;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> temp = new ArrayList<>();
        authUser.getRoles().forEach(e -> temp.add(new SimpleGrantedAuthority(e.getRole())));
        return temp;
    }

    @Override
    public String getPassword() {
        return authUser.getPassword();
    }

    @Override
    public String getUsername() {
        return authUser.getEmail();
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

```
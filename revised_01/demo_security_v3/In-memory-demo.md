```java
//  config file
package com.example.demo_security_v3.config;

import com.example.demo_security_v3.service.AuthUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder){
        UserDetails admin = User
                .withUsername("admin")
                .password(encoder.encode("admin"))
                .roles("ADMIN")
                .build();
        UserDetails user = User
                .withUsername("user")
                .password(encoder.encode("user"))
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(admin , user);
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> {
                    auth.anyRequest().authenticated();
                })
                .formLogin(Customizer.withDefaults())
                .build();
    }
}

//  .sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//  cannot add above line in SecurityFilterChain as it keeps redirecting to login page

//  for method level security
@PreAuthorize("hasAnyRole('USER')")
@PreAuthorize("hasAnyRole('ADMIN')")
```

## Roles vs Authorities

In Spring Security, `.roles()` and `.authorities()` are both methods used to define access control rules and permissions for authenticated users. However, there are some differences between the two.

1. `.roles()`: This method is used to define the roles that a user can have. Roles are typically high-level categories that group users based on their responsibilities or permissions. For example, you can have roles like "ADMIN", "USER", or "MANAGER". Roles are usually defined using the `ROLE_` prefix, such as `ROLE_ADMIN`, `ROLE_USER`, etc. The `.roles()` method accepts role names as its arguments and checks if the authenticated user possesses any of those roles.

Example:
```java
http
    .authorizeRequests()
        .antMatchers("/admin/**").hasRole("ADMIN")
        .antMatchers("/user/**").hasRole("USER")
        .anyRequest().authenticated()
        .and()
    .formLogin()
        .and()
    .logout();
```

2. `.authorities()`: This method is used to define fine-grained permissions for individual users. An authority represents a specific permission that a user can have. Authorities can be defined without any prefix and are typically more granular than roles. For example, you can have authorities like "CREATE_USER", "DELETE_USER", or "READ_DATA". The `.authorities()` method accepts authority names as its arguments and checks if the authenticated user possesses any of those authorities.

Example:
```java
http
    .authorizeRequests()
        .antMatchers("/createUser").hasAuthority("CREATE_USER")
        .antMatchers("/deleteUser").hasAuthority("DELETE_USER")
        .antMatchers("/readData").hasAuthority("READ_DATA")
        .anyRequest().authenticated()
        .and()
    .formLogin()
        .and()
    .logout();
```

In general, the choice between using `.roles()` or `.authorities()` depends on the level of granularity you require for your permissions. If you have broad categories or levels of access, roles might be more appropriate. If you need to define specific permissions for individual actions, authorities provide a finer-grained approach. Additionally, Spring Security allows you to combine both roles and authorities in your access control configuration to achieve more complex permission schemes.
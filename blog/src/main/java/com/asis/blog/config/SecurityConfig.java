package com.asis.blog.config;

import com.asis.blog.filter.JWTAuthFilter;
import com.asis.blog.service.serviceimpl.JpaUserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    private final JpaUserDetailService jpaUserDetailService;
    private final JWTAuthFilter jwtAuthFilter;

    public SecurityConfig(JpaUserDetailService jpaUserDetailService, JWTAuthFilter jwtAuthFilter) {
        this.jpaUserDetailService = jpaUserDetailService;
        this.jwtAuthFilter = jwtAuthFilter;
    }

//    @Bean
//    public UserDetailsService userDetailsService(){
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(User
//                .withUsername("asis")
//                .password(passwordEncoder().encode("password"))
////                .authorities("USER")
//                        .roles("USER")
//                .build()
//        );
//        manager.createUser(
//                User.withUsername("ram")
//                        .password(passwordEncoder().encode("password"))
////                        .authorities("ADMIN")
//                        .roles("ADMIN")
//                        .build()
//        );
//        return manager;
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeRequests(auth -> auth
                        .antMatchers("/token").permitAll()
                        .anyRequest().authenticated()
                )
                .userDetailsService(jpaUserDetailService)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
//                .httpBasic()
//                .and()
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
}

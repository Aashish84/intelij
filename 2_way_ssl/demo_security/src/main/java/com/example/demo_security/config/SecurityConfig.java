package com.example.demo_security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.authentication.AuthenticationProvider;

//@Configuration
//@EnableWebSecurity
public class SecurityConfig {
//    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
//    @Configuration
//    @EnableWebSecurity
//    @Order(1)
    public static class LoginOne {
//        @Bean
        public UserDetailsService userDetailsService(PasswordEncoder encoder) {
            UserDetails admin = User
                    .withUsername("admin")
                    .password(encoder.encode("admin"))
                    .roles("ADMIN")
                    .build();
            return new InMemoryUserDetailsManager(admin);
        }

//        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
            return httpSecurity
//                    .requiresChannel(r -> r.anyRequest().requiresSecure())
                    .csrf(AbstractHttpConfigurer::disable)
                    .authorizeHttpRequests(auth -> {
                        auth.anyRequest().authenticated();
                    })
                    .httpBasic(Customizer.withDefaults())
                    .build();
        }
    }
//    @Configuration
//    @EnableWebSecurity
//    @Order(2)
    public static class LoginTwo {
//        @Bean
        public UserDetailsService userDetailsServiceTwo(PasswordEncoder encoder) {
            UserDetails admin = User
                    .withUsername("jadmin")
                    .password(encoder.encode("jadmin"))
                    .roles("ADMIN")
                    .build();
            return new InMemoryUserDetailsManager(admin);
        }

//        @Bean
        public SecurityFilterChain securityFilterChainTwo(HttpSecurity httpSecurity) throws Exception {
            return httpSecurity
//                    .requiresChannel(r -> r.anyRequest().requiresSecure())
                    .csrf(AbstractHttpConfigurer::disable)
                    .authorizeHttpRequests(auth -> {
                        auth.anyRequest().authenticated();
                    })
                    .formLogin(Customizer.withDefaults())
                    .build();
        }
    }
}

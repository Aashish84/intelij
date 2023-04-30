package com.example.custom_threadsafe.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("spring.datasource")
@Getter
@Setter
public class MySqlProperties {
    private String url;
    private String username;
    private String password;
    private String driverClassName;
}

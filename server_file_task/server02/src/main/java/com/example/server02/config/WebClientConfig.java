package com.example.server02.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    @Bean
    public WebClient webClient(){
        final int size = 10*1024*1024;
        final ExchangeStrategies strategies = ExchangeStrategies.builder()
                .codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(size))
                .build();
        return WebClient
                .builder()
                .baseUrl("http://localhost:9090")
                .exchangeStrategies(strategies)
                .build();
    }
}

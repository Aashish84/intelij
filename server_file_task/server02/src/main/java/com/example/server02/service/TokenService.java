package com.example.server02.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Service
public class TokenService {
    private final WebClient webClient;

    public TokenService(WebClient webClient) {
        this.webClient = webClient;
    }

    public String getTokenServerOne(String userName , String password){
        Map<String , String> bodyValue = new HashMap<>();
        bodyValue.put("userName" , userName);
        bodyValue.put("password" , password);

        return webClient
                .post()
                .uri("/token")
                .bodyValue(bodyValue)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}

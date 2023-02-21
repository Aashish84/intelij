package com.example.server_caller.service.serviceimpl;

import com.example.server_caller.pojo.AuthUser;
import com.example.server_caller.service.TokenService;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class TokenServiceImpl implements TokenService {
    private final WebClient webClient;

    public TokenServiceImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public String getToken(AuthUser authUser) {
        return webClient
                .post()
                .uri("/token")
                .bodyValue(authUser)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}

package com.example.server_caller.service;

import com.example.server_caller.pojo.Address;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class ServerCallerTest {
    private final WebClient webClient;

    public ServerCallerTest(WebClient webClient) {
        this.webClient = webClient;
    }

    public List<Address> testGetAddress(String token){
        return webClient
                .get()
                .uri("/address")
                .header("Authorization" , token)
                .retrieve()
                .bodyToFlux(Address.class)
                .collectList()
                .block();
    }

    public ResponseEntity<byte[]> testGetFile(String fileName, String token) {
        return webClient
                .get()
                .uri("/getfile/" + fileName)
                .header("Authorization", token)
                .retrieve()
                .toEntity(byte[].class)
                .block();
    }
}

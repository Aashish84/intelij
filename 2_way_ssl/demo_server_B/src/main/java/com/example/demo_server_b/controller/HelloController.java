package com.example.demo_server_b.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
public class HelloController {
    private final WebClient webClient;

    public HelloController(WebClient webClient) {
        this.webClient = webClient;
    }

    @GetMapping("/server_b/hello")
    public ResponseEntity<String > testHello(){
        return ResponseEntity.ok("hello from server B");
    }
    @GetMapping("/access/server_a")
    public Mono<ResponseEntity<String>> testServerA(){
        return webClient.get()
                .uri("/private")
                .retrieve()
                .bodyToMono(String.class)
                .map(res -> ResponseEntity.ok("from server_a : "+ res))
                .onErrorReturn(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
    }
}

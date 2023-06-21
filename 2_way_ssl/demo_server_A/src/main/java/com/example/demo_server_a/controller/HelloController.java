package com.example.demo_server_a.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.cert.X509Certificate;

@RestController
public class HelloController {
    private final HttpServletRequest request;

    public HelloController(HttpServletRequest request) {
        this.request = request;
    }
    @GetMapping("/server_a/hello")
    public ResponseEntity<String> testHello(){
        X509Certificate[] cert = (X509Certificate[]) request.getAttribute("jakarta.servlet.request.X509Certificate");
        String tmp = cert[0].getSubjectX500Principal().getName();
        String cnString = tmp.substring(tmp.indexOf("CN=") + "CN=".length(), tmp.indexOf(",OU="));

        if(cnString.equals("server B"))
            return ResponseEntity.ok("hello from server A to server B");

        return ResponseEntity.ok("hello from server A");
    }
}

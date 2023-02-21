package com.example.server_caller.controller;

import com.example.server_caller.pojo.AuthUser;
import com.example.server_caller.service.ServerCallerTest;
import com.example.server_caller.service.TokenService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@AllArgsConstructor
@RestController
public class TestController {
    private final TokenService tokenService;
    private final ServerCallerTest serverCaller;
    @PostMapping("/token")
    public ResponseEntity<?> getToken(@RequestBody AuthUser authUser){
        return new ResponseEntity<>(tokenService.getToken(authUser) , HttpStatus.OK);
    }
    @GetMapping("/showAddress")
    public ResponseEntity<?> getAddress(@RequestHeader(HttpHeaders.AUTHORIZATION) String token){
        return new ResponseEntity<>(serverCaller.testGetAddress(token), HttpStatus.OK);
    }

    @GetMapping("/getfileFromBlog/{fileName}")
    public ResponseEntity<?> getFile(@PathVariable("fileName") String fileName , @RequestHeader(HttpHeaders.AUTHORIZATION) String token){

        ResponseEntity<byte[]> response = serverCaller.testGetFile(fileName, token);
        return ResponseEntity
                .status(HttpStatus.OK)
//                .contentType(MediaType.valueOf("image/png"))
//                .contentType(response.getHeaders().getContentType())
                .contentType(Objects.requireNonNull(response.getHeaders().getContentType()))
                .body(response.getBody());
    }

}

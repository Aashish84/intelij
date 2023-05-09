package com.asis.blog.controller;

import com.asis.blog.dto.AddressDto;
import com.asis.blog.entity.Address;
import com.asis.blog.service.AddressService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.crypto.SecretKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AddressControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Mock
    private AddressService addressService;
    @InjectMocks
    private AddressController addressController;
    @Test
    public void shouldNotAllowAccessToUnauthorized() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/address")).andExpect(status().isForbidden());
    }
    @Test
    public void forAuthorizedAccess() throws Exception {
        String SECRET = "4A614E645267556B58703273357638792F423F4528482B4D6250655368566D59";
        byte[] keyBytes = Decoders.BASE64.decode(SECRET);
        SecretKey secretKey = Keys.hmacShaKeyFor(keyBytes);
        String token = Jwts.builder()
                .setSubject("asis")
                .claim("roles", "USER")
                .setExpiration(new Date(System.currentTimeMillis() + 2000))
                .signWith(secretKey, SignatureAlgorithm.HS256).compact();

        mockMvc.perform(MockMvcRequestBuilders.get("/address").header("Authorization","Bearer "+token))
                .andExpect(status().isOk());
    }
    @Test
    public void getAddress(){
        AddressDto a1 = new AddressDto();
        a1.setAddressId(101L);
        AddressDto a2 = new AddressDto();
        a1.setAddressId(102L);
        List<AddressDto> dummyList = new ArrayList<>(Arrays.asList(a1,a2));
        when(addressService.getAllAddress()).thenReturn(dummyList);

        ResponseEntity<?> responseEntity = addressController.getAddresses();
        Assertions.assertEquals(HttpStatus.OK , responseEntity.getStatusCode());
//        Assertions.assertEquals(MediaType.APPLICATION_JSON, responseEntity.getHeaders().getContentType());
        Assertions.assertEquals(dummyList,responseEntity.getBody());
    }
    @Test
    public void addAddress(){
        Address address = new Address();
        address.setCountry("nepal");

        AddressDto a1 = new AddressDto();
        a1.setAddressId(1L);
        a1.setCountry(address.getCountry());
        when(addressService.addAddress(address)).thenReturn(a1);

        ResponseEntity<?> responseEntity = addressController.addAddress(address);
        Assertions.assertEquals(201 , responseEntity.getStatusCodeValue());
//        Assertions.assertEquals(MediaType.APPLICATION_JSON , responseEntity.getHeaders().getContentType());
        Assertions.assertEquals(a1 , responseEntity.getBody());
    }
}





/*
* @InjectMocks annotation on addressController injects the mocked addressService instance into the AddressController.
* This allows the test to use the mocked addressService instance when calling the methods of AddressController.
* */
package com.asis.blog.controller;

import com.asis.blog.dto.AddressDto;
import com.asis.blog.service.AddressService;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AddressControllerTest {
    @Autowired
    private MockMvc mockMvc;
//    @Mock
//    private AddressRepository addressRepository;
    @Mock
    private AddressService addressService;
    @InjectMocks
    private AddressController addressController;
    @Test
    public void shouldNotAllowAccessToUnauthorized() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/address")).andExpect(status().isForbidden());
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
        Assertions.assertEquals(dummyList,responseEntity.getBody());
    }
}





/*
* @InjectMocks annotation on addressController injects the mocked addressService instance into the AddressController.
* This allows the test to use the mocked addressService instance when calling the methods of AddressController.
* */
package com.asis.blog.controller;

import com.asis.blog.dto.AddressDto;
import com.asis.blog.entity.Address;
import com.asis.blog.service.AddressService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest
public class AddressControllerSecondTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private AddressService addressService;
    @Test
    public void shouldNotAllowAccessToUnauthorized() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/address")).andExpect(status().isForbidden());
    }
    @Test
    @WithMockUser
    public void shouldAllowAccessToAuthorized() throws Exception {
        AddressDto a1 = new AddressDto();
        a1.setAddressId(101L);
        a1.setCountry("canada");
        AddressDto a2 = new AddressDto();
        a2.setAddressId(105L);
        a2.setCountry("india");
        List<AddressDto> dummyList = new ArrayList<>();
        dummyList.add(a1);
        dummyList.add(a2);

        Mockito.when(addressService.getAllAddress()).thenReturn(dummyList);

        mockMvc.perform(MockMvcRequestBuilders.get("/address"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(new ObjectMapper().writeValueAsString(dummyList)));
    }
    @Test
    @WithMockUser
    public void addAddress() throws Exception {
        Address dummyAddress = new Address();
        dummyAddress.setCountry("nepal");
        AddressDto a1 = new AddressDto();
        a1.setAddressId(1L);
        a1.setCountry(dummyAddress.getCountry());

        Mockito.when(addressService.addAddress(Mockito.any(Address.class))).thenReturn(a1);

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/address")
                        .content(new ObjectMapper().writeValueAsString(dummyAddress))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(new ObjectMapper().writeValueAsString(a1)))
                .andExpect(jsonPath("$.country" ).value("nepal"));
    }
}

/*
* @MockBean is a Spring annotation that can be used to add a mock object to the Spring application context.
* @WithMockUser create mock user from package spring-security-test
* */
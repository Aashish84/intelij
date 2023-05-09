package com.asis.blog.service.serviceimpl;

import com.asis.blog.dto.AddressDto;
import com.asis.blog.entity.Address;
import com.asis.blog.repository.AddressRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class AddressServiceImplTest {
    @Autowired
    private AddressServiceImpl addressService;
    @MockBean
    private AddressRepository addressRepository;
    @Test
    public void getAllAddress(){
        Address one =  new Address();
        one.setCountry("nepal");
        List<Address> list = new ArrayList<>();
        list.add(one);
        Mockito.when(addressRepository.findAll()).thenReturn(list);

        List<AddressDto> resultList = addressService.getAllAddress();

        assertEquals("nepal" , resultList.get(0).getCountry());
        assertEquals(list.size() , resultList.size());
        assertTrue(resultList.get(0) instanceof AddressDto);
    }
}
package com.asis.blog.controller;

import com.asis.blog.dto.DummyDto;
import com.asis.blog.entity.Address;
import com.asis.blog.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class AddressController {
    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }
    @GetMapping("/address")
//    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN' , 'ROLE_USER')")
    public ResponseEntity<?> getAddresses(){
//        List<DummyDto> list = Arrays.asList(new DummyDto(1L),new DummyDto(2L));
//        return ResponseEntity.ok(list);
        return new ResponseEntity<>(addressService.getAllAddress() , HttpStatus.OK);
    }
    @PostMapping("/address")
    public ResponseEntity<?> addAddress(@RequestBody Address address){
        return new ResponseEntity<>(addressService.addAddress(address) , HttpStatus.CREATED);
    }

}

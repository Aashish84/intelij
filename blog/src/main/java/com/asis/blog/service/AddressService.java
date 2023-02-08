package com.asis.blog.service;

import com.asis.blog.dto.AddressDto;
import com.asis.blog.entity.Address;

import java.util.List;

public interface AddressService {
    List<AddressDto> getAllAddress();

    AddressDto addAddress(Address address);
}

package com.asis.blog.service.serviceimpl;

import com.asis.blog.dto.AddressDto;
import com.asis.blog.entity.Address;
import com.asis.blog.mapper.AddressMapper;
import com.asis.blog.repository.AddressRepository;
import com.asis.blog.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;

    private final AddressMapper addressMapper;

    public AddressServiceImpl(AddressRepository addressRepository, AddressMapper addressMapper) {
        this.addressRepository = addressRepository;
        this.addressMapper = addressMapper;
    }


    @Override
    public List<AddressDto> getAllAddress() {
        List<Address> allAddress = addressRepository.findAll();
        return addressMapper.entitiesToDtos(allAddress);
    }

    @Override
    public AddressDto addAddress(Address address) {
//        entity-to-dto conversion : repository response
        Address newAddress = addressRepository.save(address);
        return addressMapper.entityToDto(newAddress);
    }
}

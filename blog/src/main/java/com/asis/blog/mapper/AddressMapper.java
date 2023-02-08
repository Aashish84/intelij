package com.asis.blog.mapper;

import com.asis.blog.dto.AddressDto;
import com.asis.blog.entity.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AddressMapper {
    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);
    @Mapping(source = "id" , target = "addressId")
    AddressDto entityToDto (Address address);
    @Mapping(source = "addressId" ,target = "id")
    Address dtoToEntity (AddressDto addressDto);
    List<AddressDto> entitiesToDtos (List<Address> addresses);
}

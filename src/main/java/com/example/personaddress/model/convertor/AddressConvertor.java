package com.example.personaddress.model.convertor;

import com.example.personaddress.model.entity.AddressEntity;
import com.example.personaddress.model.requestDto.AddressRequest;
import com.example.personaddress.model.responseDto.AddressResponse;

import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")

public interface AddressConvertor extends AbstractConvertor<AddressEntity, AddressRequest, AddressResponse>{

}



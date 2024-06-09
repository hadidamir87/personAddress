package com.example.personaddress.model.convertor;

import com.example.personaddress.model.entity.PersonEntity;
import com.example.personaddress.model.requestDto.PersonRequest;
import com.example.personaddress.model.responseDto.PersonResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface PersonConvertor extends AbstractConvertor<PersonEntity, PersonRequest, PersonResponse>{

}





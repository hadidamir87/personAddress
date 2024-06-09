package com.example.personaddress.rest;

import com.example.personaddress.model.entity.AddressEntity;
import com.example.personaddress.model.requestDto.AddressRequest;
import com.example.personaddress.model.requestDto.PersonRequest;
import com.example.personaddress.model.responseDto.AddressResponse;
import com.example.personaddress.model.responseDto.PersonResponse;
import com.example.personaddress.service.AddressService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/address")
public class AddressController extends BaseController<AddressEntity
        , AddressRequest
        , AddressResponse
        , AddressService> {

    @PostMapping("/create")
    public AddressResponse create(@RequestBody AddressRequest addressRequest) throws Exception {

        Optional.ofNullable(convertor.convertToEntity(addressRequest))
                .filter(entity -> entity.getCity() != null && entity.getStreet() != null)
                .orElseThrow(() -> new Exception("Entering data is necessary."));
        return convertor.convertToResponse(service.create(convertor.convertToEntity(addressRequest)));
    }
}

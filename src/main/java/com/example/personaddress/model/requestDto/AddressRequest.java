package com.example.personaddress.model.requestDto;

import lombok.Data;

@Data
public class AddressRequest {
    private Integer zipcode;
    private String street;
    private String city;
}

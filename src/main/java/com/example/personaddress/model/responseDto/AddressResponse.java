package com.example.personaddress.model.responseDto;

import lombok.Data;

@Data
public class AddressResponse {
    private Long Id;
    private Integer zipcode;
    private String street;
    private String city;

}

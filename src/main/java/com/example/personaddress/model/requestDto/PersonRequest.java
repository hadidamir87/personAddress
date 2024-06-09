package com.example.personaddress.model.requestDto;

import com.example.personaddress.model.entity.AddressEntity;
import com.example.personaddress.model.entity.PersonEntity;
import lombok.Data;

import java.util.List;

@Data
public class PersonRequest {
    private String name;
    private PersonEntity parent;
    private List<AddressRequest> addresses;

}

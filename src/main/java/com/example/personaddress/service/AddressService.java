package com.example.personaddress.service;

import com.example.personaddress.model.entity.AddressEntity;
import com.example.personaddress.repository.AddressRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressService extends BaseService<AddressEntity
        , AddressRepository>{


    public AddressEntity updateAddress(Long id, AddressEntity c) throws Exception {

        AddressEntity currentAddress = repository.findById(id).get();

        if (c.getZipcode() != null) {
            currentAddress.setZipcode(c.getZipcode());
        }
        if (c.getStreet() != null) {
            currentAddress.setStreet(c.getStreet());
        }
        if (c.getCity() != null) {
            currentAddress.setCity(c.getCity());
        }
        return repository.save(currentAddress);

    }
    public void deleteById(Long id) {
        repository.delete(repository.findById(id).get());

    }
}

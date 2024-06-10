package com.example.personaddress.service;

import com.example.personaddress.model.entity.AddressEntity;
import com.example.personaddress.model.entity.PersonEntity;
import com.example.personaddress.repository.AddressRepository;
import com.example.personaddress.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService extends BaseService<AddressEntity
        , AddressRepository> {
    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private PersonRepository personRepository;

    public AddressEntity get(Long id) {
        return repository.findById(id).get();
    }
//    @Transactional(isolation = Isolation.DEFAULT)
//    @Transactional(timeout =30)
    @Transactional(readOnly = true )
    public List<AddressEntity> getAllAddress() {
        return repository.findAll();
    }

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
    @Transactional(rollbackFor = Exception.class)
    public void updatePersonId(Long addressId, Long personId) throws Exception {

        Optional<AddressEntity> addressOptional = addressRepository.findById(addressId);
        Optional<PersonEntity> personOptional = personRepository.findById(personId);

        if (addressOptional.isPresent() && personOptional.isPresent()) {
            AddressEntity addressEntity = addressOptional.get();
            PersonEntity personEntity = personOptional.get();

            addressEntity.setPerson(personEntity);
            addressRepository.save(addressEntity);

        }
    }

    public void deleteById(Long id) {
        repository.delete(repository.findById(id).get());

    }

    public List<AddressEntity> getAllAddressWithPagination(int pageIndex) {
        return repository.findAll(Pageable.ofSize(2).withPage(pageIndex)).getContent();
    }

    public String setAddressToPerson(Long addressId, Long personId) throws Exception {
        updatePersonId(addressId, personId);
        repository.findById(addressId);
        return "address has been set to :" + addressId;
    }
}

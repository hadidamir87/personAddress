package com.example.personaddress.service;

import com.example.personaddress.model.convertor.PersonConvertor;
import com.example.personaddress.model.entity.AddressEntity;
import com.example.personaddress.model.entity.PersonEntity;
import com.example.personaddress.model.responseDto.PersonResponse;
import com.example.personaddress.repository.PersonRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class PersonService extends BaseService<PersonEntity, PersonRepository> {
    @Autowired
    private PersonConvertor convertor;

    @Autowired
    private AddressService addressService;

    @Override
    public PersonEntity create(PersonEntity personEntity) {
        List<AddressEntity> addresses =  personEntity.getAddresses();

        for(AddressEntity addressEntity : addresses){
            addressEntity.setPerson(personEntity);

        }

        return repository.save(personEntity);
    }

    public List<PersonEntity> getAll() {
        return repository.findAll();
    }

    public List<PersonEntity> getAllWithPagination(int pageNum) {

        return repository.findAll(Pageable.ofSize(2).withPage(pageNum)).getContent();
    }

    public List<PersonResponse> getChildrenById(Long id) {

        List<PersonEntity> children = repository.findAll();
        List<PersonEntity> newChildren = children.stream().filter(p -> p.getParent().equals(id))
                .collect(Collectors.toList());
        return convertor.entityCollectionConvertor(newChildren);

    }
    public PersonEntity updatePerson(Long id, PersonEntity c) throws Exception {

        PersonEntity currentPerson = repository.findById(id).get();

        if (c.getName() != null) {
            currentPerson.setName(c.getName());
        }
        if (c.getParent() != null) {
            currentPerson.setParent(c.getParent());
        }
     /*   if (c.getAddresses() != null) {
            currentPerson.setAddresses(c.getAddresses());
        }*/
        return repository.save(currentPerson);

    }

}

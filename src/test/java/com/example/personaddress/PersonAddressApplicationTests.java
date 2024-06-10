package com.example.personaddress;

import com.example.personaddress.model.entity.AddressEntity;
import com.example.personaddress.model.entity.PersonEntity;
import com.example.personaddress.repository.PersonRepository;
import com.example.personaddress.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;



@SpringBootTest
class PersonAddressApplicationTests {
    @Autowired
    private PersonService personService;
    @Autowired
    private PersonRepository personRepository;

    @Test
    void contextLoads() {
    }

    @Test
    public void testGetAll() {
        PersonEntity person1 = new PersonEntity();
        PersonEntity person2 = new PersonEntity();
        person1.setName("reza");
        person2.setName("hadi");
        personRepository.save(person1);
        personRepository.save(person2);

        List<PersonEntity> allPersons = personService.getAll();

        assertEquals(2, allPersons.size());
        assertEquals("reza", allPersons.get(0).getName());
        assertEquals("hadi", allPersons.get(1).getName());
    }

    @Test
    void testCreateAddress() {

        AddressEntity address1 = new AddressEntity();
        address1.setStreet("123 Main St");
        address1.setCity("City");

        List<AddressEntity> addresses = new ArrayList<>();
        addresses.add(address1);

        assertEquals("123 Main St",addresses.get(0).getStreet());
        assertEquals("City",addresses.get(0).getCity());

    }


}





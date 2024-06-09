package com.example.personaddress.rest;

import com.example.personaddress.model.entity.PersonEntity;
import com.example.personaddress.model.requestDto.PersonRequest;
import com.example.personaddress.model.responseDto.PersonResponse;
import com.example.personaddress.service.PersonService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController extends BaseController<PersonEntity
        , PersonRequest
        , PersonResponse
        , PersonService> {
    @PostMapping("/create")
    public PersonResponse create(@RequestBody PersonRequest personRequest) throws Exception {

        Optional.ofNullable(convertor.convertToEntity(personRequest))
                .filter(entity -> entity.getName() != null )
                .orElseThrow(() -> new Exception("Entering data is necessary."));
        return convertor.convertToResponse(service.create(convertor.convertToEntity(personRequest)));
    }

    @PutMapping("updatePerson/{id}")
    public PersonResponse update(@PathVariable Long id
            , @RequestBody PersonRequest personRequest) throws Exception {

        if (this.getById(id) == null) {
            throw new Exception("person not found.");
        }
        return convertor.convertToResponse(service
                .updatePerson(id,convertor.convertToEntity(personRequest)));
    }

    @GetMapping("/{id}")
    public PersonResponse getById(@PathVariable Long id) {
        return convertor.convertToResponse(service.get(id));
    }

    @GetMapping("/persons")
    public List<PersonResponse> getAllPerson() {
        return convertor.entityCollectionConvertor(service.getAll());
    }



    @GetMapping("/getAllPersonWithPagination")
    public List<PersonResponse> getAllPersonWithPagination(@RequestParam("pageIndex") int pageIndex) {
        return convertor.entityCollectionConvertor(service.getAllWithPagination(pageIndex));
    }

    /*@GetMapping("getChildren/{id}")
    public List<PersonResponse> getChildrenById(@PathVariable Long id) {
        return service.getChildrenById(id);
    }*/

    @DeleteMapping("delete/{id}")
    public String deletePerson(@PathVariable Long id) {
        service.delete(id);
        return "deleted person with :" + id;
    }

}

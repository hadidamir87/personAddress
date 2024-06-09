package com.example.personaddress.rest;

import com.example.personaddress.model.entity.PersonEntity;
import com.example.personaddress.model.requestDto.PersonRequest;
import com.example.personaddress.model.responseDto.PersonResponse;
import com.example.personaddress.service.PersonService;
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

    @GetMapping("/{id}")
    public PersonResponse getById(@PathVariable Long id) {
        return convertor.convertToResponse(service.get(id));
    }

    @GetMapping
    public List<PersonResponse> getAllPerson() {
        return convertor.entityCollectionConvertor(service.getAll());
    }



    @GetMapping("/getAllPersonWithPagination")
    public List<PersonResponse> getAllPersonWithPagination(int pageNum) {
        return convertor.entityCollectionConvertor(service.getAllWithPagination(pageNum));
    }

    @GetMapping("getChildren/{id}")
    public List<PersonResponse> getChildrenById(@PathVariable Long id) {
        return service.getChildrenById(id);
    }


}

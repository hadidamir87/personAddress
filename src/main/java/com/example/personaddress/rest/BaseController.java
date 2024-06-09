package com.example.personaddress.rest;

import com.example.personaddress.model.convertor.AbstractConvertor;
import com.example.personaddress.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

public class BaseController<E, RQ, RP, S extends BaseService<E,? extends JpaRepository<E, Long>>> {
    @Autowired
    protected S service;
    @Autowired
    protected AbstractConvertor<E, RQ, RP> convertor;

}




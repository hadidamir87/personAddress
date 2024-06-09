package com.example.personaddress.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public class BaseService<E, R extends JpaRepository<E, Long>> {
    @Autowired
    protected R repository;


    public E create(E e) {
        return repository.save(e);
    }
    public String delete(E e) {
        repository.delete(e);
        return "operation has been complete";
    }
    public E update(E e) {
        return repository.save(e);
    }

    public E get(Long id) {
        return repository.findById(id).get();
    }

    public List<E> getAll() {
        return repository.findAll();
    }
}

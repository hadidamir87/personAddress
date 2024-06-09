package com.example.personaddress.repository;

import com.example.personaddress.model.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity,Long> {

    List<PersonEntity> findAllById(Long id);
}

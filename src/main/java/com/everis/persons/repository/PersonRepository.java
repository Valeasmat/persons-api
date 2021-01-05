package com.everis.persons.repository;

import com.everis.persons.entity.PersonEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<PersonEntity,Integer> {
    PersonEntity findByDocument(String documentNumber);
}

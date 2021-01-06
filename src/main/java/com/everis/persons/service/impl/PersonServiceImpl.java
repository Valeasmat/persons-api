package com.everis.persons.service.impl;

import com.everis.persons.entity.PersonEntity;
import com.everis.persons.repository.PersonRepository;
import com.everis.persons.service.PersonService;
import io.reactivex.Single;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Single<PersonEntity> getPerson(String documentNumber) throws Exception {
        PersonEntity byDocument = personRepository.findByDocument(documentNumber);
        if(byDocument.getBlacklist()) throw new IllegalArgumentException("Blacklist true");
        return Single.just(byDocument);
    }
}

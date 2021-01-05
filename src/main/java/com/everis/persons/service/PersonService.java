package com.everis.persons.service;

import com.everis.persons.entity.PersonEntity;
import io.reactivex.Single;

public interface PersonService {

    Single<PersonEntity> getPerson(String documentNumber) throws Exception;
}

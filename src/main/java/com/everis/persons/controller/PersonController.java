package com.everis.persons.controller;


import com.everis.persons.entity.PersonEntity;
import com.everis.persons.entity.PersonResponse;
import com.everis.persons.service.PersonService;
import io.reactivex.Single;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping(value = "/core/persons",produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public ResponseEntity<Single<PersonResponse>> getPerson(@RequestParam("documentNumber") String documentNumber){
        Single<PersonResponse> personResponse;
        try{
            Single<PersonEntity> personRequest= personService.getPerson(documentNumber);
            personResponse = personRequest
                    .map(person -> new PersonResponse(
                            person.getId(),
                            person.getDocument(),
                            person.getFingerprint(),
                            person.getBlacklist()));

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(personResponse, HttpStatus.OK);
    }
}

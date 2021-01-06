package com.everis.persons.controller;


import com.everis.persons.entity.PersonEntity;
import com.everis.persons.entity.PersonResponse;
import com.everis.persons.service.PersonService;
import io.reactivex.Single;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
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
    @ApiOperation(value = "Get request to retrieve client's info",
            response = PersonResponse.class,
            produces = "application/stream+json")
    @ApiResponse(code = 200,message = "Successful operation",response = PersonResponse.class)
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

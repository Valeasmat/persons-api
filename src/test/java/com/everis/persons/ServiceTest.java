package com.everis.persons;

import com.everis.persons.entity.PersonEntity;
import com.everis.persons.repository.PersonRepository;
import com.everis.persons.service.impl.PersonServiceImpl;
import io.reactivex.Single;
import io.reactivex.observers.TestObserver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {

    @InjectMocks
    private PersonServiceImpl service;
    @Mock
    private PersonRepository repository;

    @Test
    public void getPersonTest() throws Exception {
        PersonEntity personEntity=new PersonEntity(1,"10000000",true,false);

        Mockito.when(repository.findByDocument(Mockito.anyString())).thenReturn(personEntity);

        TestObserver<PersonEntity> response=service.getPerson("100000000").test();
        response.assertNoErrors()
                .assertValueCount(1);

    }

    @Test
    public void getPersonExceptionTest() throws Exception {
        PersonEntity personEntity=new PersonEntity(1,"10000000",true,true);

        Mockito.when(repository.findByDocument(Mockito.anyString())).thenReturn(personEntity);
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            service.getPerson("10000000");
        });


    }
}

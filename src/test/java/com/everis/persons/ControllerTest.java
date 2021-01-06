package com.everis.persons;

import com.everis.persons.controller.PersonController;
import com.everis.persons.entity.PersonEntity;
import com.everis.persons.entity.PersonResponse;
import com.everis.persons.service.impl.PersonServiceImpl;
import io.reactivex.Single;
import io.reactivex.observers.TestObserver;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ControllerTest {

    @InjectMocks
    private PersonController controller;

    @Mock
    private PersonServiceImpl personService;

    @Test
    public void getPersonTest() throws Exception {
        Single<PersonEntity> personEntity=Single.just(new PersonEntity(1,"10000000",true,false));

        Mockito.when(personService.getPerson(Mockito.anyString())).thenReturn(personEntity);

        TestObserver<PersonResponse> response=controller.getPerson("10000000").getBody().test();

        response.assertNever(p->!p.getFingerprint())
                .assertNever(p->p.getBlacklist())
                .assertValueCount(1)
                .assertNoErrors();
    }
}

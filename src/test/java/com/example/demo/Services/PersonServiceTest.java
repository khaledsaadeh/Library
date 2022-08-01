package com.example.demo.Services;

import com.example.demo.Models.Person;
import com.example.demo.Repositories.PersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.verify;

@SpringBootTest
public class PersonServiceTest {
    @Mock
    PersonRepository personRepository;
    @InjectMocks
    PersonService personService;

    @Test
    public void getAllPersons_methodCalled_personsRepoGetAllCalled() {
        personService.getPersons();
        verify(personRepository).findAll();
    }

    @Test
    public void getPersonById_methodCalled_personRepoGetByIdCalled() {
        Person person = new Person();

        personService.getPersonById(1L);
        verify(personRepository).findById(1L);
    }

    @Test
    public void deletePerson_methodCalled_personRepoDeletePersonCalled() {
        Person person = new Person();

        personService.deletePerson(1L);
        verify(personRepository).deleteById(1L);
    }

    @Test
    public void savePerson_methodCalled_personRepoSaveCalled(){
        Person person = new Person();

        personService.savePerson(person);
        verify(personRepository).save(person);
    }

    @Test
    public void updatePerson_methodCalled_personUpdated() {
        Person person = new Person();
        person.setName("Khaled");

        personService.updatePerson(1L, "Ahmad");
        Assertions.assertEquals("Ahmad", person.getName());
    }
}
package com.example.demo.Services;

import com.example.demo.Models.Person;
import com.example.demo.Repositories.PersonRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getPersons() {
        return personRepository.findAll();
    }

    public Person getPersonById(Long id) {
        return personRepository.findById(id).orElseThrow(() -> new IllegalStateException("Person not found"));
    }

    public void savePerson(Person person) {
        personRepository.save(person);
    }

    public void deletePerson(Long id) {
        boolean found = personRepository.existsById(id);
        if (!found) {
            throw new IllegalStateException("Person not found");
        }
        personRepository.deleteById(id);
    }

    public void updatePerson(Long id, String name) {
        Person person = personRepository.findById(id).orElseThrow(() -> new IllegalStateException("Person not found"));
        if (name != null && person.getName() != name) {
            person.setName(name);
        }
    }
}
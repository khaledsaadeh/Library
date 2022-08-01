package com.example.demo.Controllers;

import com.example.demo.Models.Person;
import com.example.demo.Services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/persons")
public class PersonController {

    @Autowired
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/all")
    public List<Person> getPersons() {
        return personService.getPersons();
    }

    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable("id") Long id) {
        return personService.getPersonById(id);
    }

    @PostMapping("/add")
    public void addPerson(@RequestBody Person person) {
        personService.savePerson(person);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePerson(@PathVariable("id") Long id) {
        personService.deletePerson(id);
    }

    @PutMapping("/update/{id}")
    public void updatePerson(@PathVariable("id") Long id, @RequestBody String name) {
        personService.updatePerson(id, name);
    }
}
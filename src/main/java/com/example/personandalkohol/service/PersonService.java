package com.example.personandalkohol.service;

import com.example.personandalkohol.model.Person;
import com.example.personandalkohol.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public void save(Person person) {
        personRepository.save(person);
    }

    public Person findPerson(String name) {
        return personRepository.findPerson(name);
    }

}

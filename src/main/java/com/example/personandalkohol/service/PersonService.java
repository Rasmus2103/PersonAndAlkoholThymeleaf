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

    public String canBuyAlkohol(Person person) {
        return personRepository.canBuyAlkohol(person);
    }

}

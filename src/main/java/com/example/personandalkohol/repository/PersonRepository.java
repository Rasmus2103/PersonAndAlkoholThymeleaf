package com.example.personandalkohol.repository;

import com.example.personandalkohol.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRepository {
    private List<Person> personList = new ArrayList<>();

    public PersonRepository() {
        personList.add(new Person("Fred", 25));
        personList.add(new Person("Lisa", 27));
        personList.add(new Person("Tom", 17));
    }

    public List<Person> findAll() {
        return personList;
    }

    public void save(Person person) {
        personList.add(person);
    }

    public Person findPerson(String name) {
        for (Person p: personList) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        return null;
    }

}

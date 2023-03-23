package com.example.personandalkohol.controller;

import com.example.personandalkohol.model.Person;
import com.example.personandalkohol.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class PersonController {
    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping ("findAll")
    public String findAll(Model model) {
        List<Person> personList = personService.findAll();
        model.addAttribute("personList", personList);
        return "person";
    }

    @GetMapping("person")
    public String getPerson(Model model) {
        Person p = new Person("Rasmus", 23);
        model.addAttribute("person", p);
        return "personList";
    }

    @GetMapping("person/create")
    public String showForm(Model model) {
        model.addAttribute("person", new Person());
        return "personForm";
    }

    @PostMapping("person/save")
    public String personSave(@ModelAttribute Person person, Model model) {
        personService.save(person);
        Person personNew = personService.findPerson(person.getName());
        model.addAttribute("person", personNew);
        return "createdResult";
    }
}

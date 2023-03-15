package com.example.personandalkohol.controller;

import com.example.personandalkohol.model.Person;
import com.example.personandalkohol.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class PersonController {
    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("findAll")
    public String findAll(Model model) {
        List<Person> personList = personService.findAll();
        Map<Person, String> personAlcoholStatus = new HashMap<>();
        for (Person person : personList) {
            String status = personService.canBuyAlkohol(person);
            personAlcoholStatus.put(person, status);
        }
        model.addAttribute("personAlcoholStatus", personAlcoholStatus);
        return "person";
    }
}

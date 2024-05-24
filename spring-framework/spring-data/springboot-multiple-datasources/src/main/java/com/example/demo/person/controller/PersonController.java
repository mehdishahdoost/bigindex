package com.example.demo.person.controller;

import com.example.demo.person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/person")
    public long count() {
        return personService.personCount();
    }

}

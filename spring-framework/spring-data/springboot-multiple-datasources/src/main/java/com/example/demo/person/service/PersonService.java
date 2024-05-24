package com.example.demo.person.service;

import com.example.demo.person.repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepo personRepo;

    public long personCount() {
        return this.personRepo.count();
    }

}

package com.example.nliot.controller;

import com.example.nliot.dao.TestRepository;
import com.example.nliot.entity.test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



import java.util.List;

@RestController
public class TestController {
    @Autowired
    TestRepository testRepository;
    @GetMapping(value = "/test")
    private List<test> testList() {
        return testRepository.findAll();
    }


    @PostMapping(value = "/addPerson/{name}")
    public test personAdd(@PathVariable("name") String name) {
        test person = new test();
        person.setName(name);

        return testRepository.save(person);
    }

    @PostMapping(value = "/addPerson")
    public test personAdd() {
        test person = new test();
        person.setId(100);
        person.setName("xxx");
        return testRepository.save(person);
    }


    @GetMapping(value = "/person/{id}")
    public test personFindOne(@PathVariable("id") Integer id) {
        return testRepository.findById(id).orElse(null);
    }



}

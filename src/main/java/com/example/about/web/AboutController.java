package com.example.about.web;

import java.util.Map;

import com.example.about.domain.Person;
import com.example.about.domain.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutController {

    private PersonRepository personRepository;

    @Autowired
    public void setPersonRepository(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/")
    public String about(Map<String, Object> model) {
        Person me = personRepository.findOne(1L);
        model.put("me", me);

        // Return the name of the HTML (file) view.
        return "index";
    }
}

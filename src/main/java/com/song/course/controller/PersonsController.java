package com.song.course.controller;

import com.song.course.model.Person;
import com.song.course.services.CoursesServices;
import com.song.course.services.PersonsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

@Controller
public class PersonsController {

    @Autowired
    private CoursesServices coursesServices;

    @Autowired
    private PersonsServices personsServices;

    @MutationMapping
    @Transactional
    public Person addPerson(
            @Argument Person person) {
        return personsServices.savePerson(person);
    }
}

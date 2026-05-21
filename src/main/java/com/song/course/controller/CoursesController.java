package com.song.course.controller;
import com.song.course.model.Person;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

@Controller
public class CoursesController {

    @MutationMapping
    @Transactional
    public void subscribePersonToCourse(
            @Argument Person person) {
        System.out.println("hello Suscribe course"+person.getEmail());
    }



}

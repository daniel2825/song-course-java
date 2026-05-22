package com.song.course.controller;
import com.song.course.model.Courses;
import com.song.course.model.Person;
import com.song.course.services.CoursesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

@Controller
public class CoursesController {

    @Autowired
    private CoursesServices coursesServices;

    @MutationMapping
    @Transactional
    public void subscribePersonToCourse(
            @Argument Person person,
            @Argument Courses course) {
        System.out.println("hello Suscribe course"+person.getEmail());
        System.out.println("title course: "+course.getTitle());
        System.out.println("ID course: " + course.getIdCourse() );

        coursesServices.subscribeCourse(person,course);

    }

}

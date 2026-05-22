package com.song.course.services;

import com.song.course.model.Courses;
import com.song.course.model.Person;
import com.song.course.repository.ICoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoursesServices {
    private final ICoursesRepository coursesRepository;

    @Autowired
    public CoursesServices(final ICoursesRepository coursesRepository){
        this.coursesRepository = coursesRepository;
    }

    public void subscribeCourse(final Person person, final Courses course) {
        coursesRepository.subscribeCourse(person.getEmail(), course.getIdCourse(), course.getTitle());
        coursesRepository.relationsPersonAndCourse(person.getEmail(), course.getIdCourse(), course.getTitle());
    }

}

package com.song.course.services;

import com.song.course.model.Courses;
import com.song.course.model.Person;
import com.song.course.repository.ICoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class CoursesServices {
    private final ICoursesRepository coursesRepository;

    @Autowired
    public CoursesServices(final ICoursesRepository coursesRepository){
        this.coursesRepository = coursesRepository;
    }

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void subscribeCourse(final Person person, final Courses course) {
        kafkaTemplate.send("subscribe-course", "key", "Send course topic kafka");
        coursesRepository.subscribeCourse(person.getEmail(), course.getIdCourse(), course.getTitle());
        coursesRepository.relationsPersonAndCourse(person.getEmail(), course.getIdCourse(), course.getTitle());
    }

}

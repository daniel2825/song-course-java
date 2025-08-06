package com.song.course.services;

import com.song.course.model.Person;
import com.song.course.repository.IPersonsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonsServices {

    private final IPersonsRepository personsRepository;

    @Autowired
    public PersonsServices(final IPersonsRepository personsRepository){
        this.personsRepository = personsRepository;
    }

    public Person savePerson(final Person person) {
        return personsRepository.save(person);
    }

}

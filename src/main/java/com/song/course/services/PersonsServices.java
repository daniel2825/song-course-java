package com.song.course.services;

import com.song.course.model.Person;
import com.song.course.repository.IPersonsRepository;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class PersonsServices {

    private final IPersonsRepository personsRepository;
    private Producer<String, String> producer;
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


    @Autowired
    public PersonsServices(final IPersonsRepository personsRepository){
        this.personsRepository = personsRepository;
    }

    public Person savePerson(final Person person) {


/*        ProducerRecord<String, String> record =
                new ProducerRecord<>(
                        "test-topic",
                        "Send person register to topic kafka"
                );
*/
        kafkaTemplate.send("test-topic", "key", "Send person register to topic kafka");
        /*producer.send(record, (metadata, exception) -> {

            if (exception == null) {
                System.out.println(
                        "Enviado a offset: "
                                + metadata.offset()
                );
            } else {
                exception.printStackTrace();
            }

        });
*/


        return personsRepository.savePerson(person.getName(),person.getEmail(), person.getLastName(),person.getBirthDay());
    }

    public Person getPerson(final String email) {
        return personsRepository.findAlreadyExistPerson(email);
    }

}

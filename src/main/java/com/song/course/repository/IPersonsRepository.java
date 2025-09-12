package com.song.course.repository;

import com.song.course.model.Person;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonsRepository extends Neo4jRepository<Person,Long> {
    @Query("MERGE (p:Person {name: $name, email: $email, lastName: $lastName, birthDay: $birthDay})")
    Person savePerson(@Param("name") String name,
                      @Param("email") String email,
                      @Param("lastName") String lastName,
                      @Param("birthDay") String birthDay);

    @Query("MATCH (p:Person) WHERE p.email=$email RETURN p LIMIT 1")
    Person findAlreadyExistPerson(
            @Param("email") String email);
}

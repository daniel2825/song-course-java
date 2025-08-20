package com.song.course.repository;

import com.song.course.model.Person;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonsRepository extends Neo4jRepository<Person,Long> {
    @Query("MERGE (p:Person {name: $nameCity, email: $email})")
    Person savePerson(@Param("name") String name,@Param("email") String email);
}

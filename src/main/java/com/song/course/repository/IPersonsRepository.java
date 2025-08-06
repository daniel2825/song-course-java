package com.song.course.repository;

import com.song.course.model.Person;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonsRepository extends Neo4jRepository<Person,Long> {
}

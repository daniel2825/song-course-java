package com.song.course.repository;

import com.song.course.model.Courses;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICoursesRepository extends Neo4jRepository<Courses,Long> {
    @Query("MERGE (c:Course {idCourse: $idCourse,title: $title})")
    void subscribeCourse(
                    @Param("email") String email,
                    @Param("idCourse") String idCourse,
                    @Param("title") String title);

    @Query("MATCH (c:Course),(p:Person) WHERE c.idCourse=$idCourse AND p.email=$email "
                    + "MERGE (p)-[r:IS_SUBSCRIBED_TO]->(c) RETURN c.title")
    void relationsPersonAndCourse( @Param("email") String email,
                                   @Param("idCourse") String idCourse,
                                   @Param("title") String title);

}

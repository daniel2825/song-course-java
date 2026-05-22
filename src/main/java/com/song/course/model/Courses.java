package com.song.course.model;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
public class Courses {
    @Id
    private Long id;
    private String idCourse;
    private String title;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }


    public String getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(String idCourse) {
        this.idCourse = idCourse;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

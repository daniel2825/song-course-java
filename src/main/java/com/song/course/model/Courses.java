package com.song.course.model;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
public class Courses {
    @Id
    private Long id;

}

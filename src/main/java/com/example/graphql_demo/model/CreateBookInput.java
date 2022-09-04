package com.example.graphql_demo.model;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class CreateBookInput {
    private String name;
    private String authorId;
    private Integer pageCount;
    private OffsetDateTime publicationDate;
    private String description;
}

package com.example.graphql_demo.model;

import lombok.Data;

@Data
public class CreateBookInput {
    private String name;
    private String authorId;
    private Integer pageCount;
    private String publicationDate;
    private String description;
}

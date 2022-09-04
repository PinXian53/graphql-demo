package com.example.graphql_demo.model;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class CreateAuthorInput {
    private String name;
    private OffsetDateTime birthDay;
}

package com.example.graphql_demo.controller;

import com.example.graphql_demo.dao.Author;
import com.example.graphql_demo.dao.Book;
import com.example.graphql_demo.model.CreateAuthorInput;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AuthorController {


    @MutationMapping
    public Author createAuthor(@Argument CreateAuthorInput input) {
        return Author.createAuthor(input);
    }

    @QueryMapping
    public List<Author> getAllAuthor() {
        return Author.getAll();
    }

    @QueryMapping
    public Author getAuthorById(@Argument String id) {
        return Author.getAuthorByBookId(id);
    }


    @SchemaMapping
    public Author author(Book book) {
        return Author.getById(book.getAuthorId());
    }
}

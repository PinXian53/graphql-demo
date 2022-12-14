package com.example.graphql_demo.controller;

import com.example.graphql_demo.dao.Author;
import com.example.graphql_demo.dao.Book;
import com.example.graphql_demo.model.CreateBookInput;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookController {

    @MutationMapping
    public Book createBook(@Argument CreateBookInput input) {
        return Book.createBook(input);
    }

    @QueryMapping
    public List<Book> getAllBook() {
        return Book.getAll();
    }

    @QueryMapping
    public Book getBookById(@Argument String id) {
        return Book.getById(id);
    }

    @SchemaMapping
    public List<Book> book(Author author) {
        return Book.findByAuthorId(author.getId());
    }
}
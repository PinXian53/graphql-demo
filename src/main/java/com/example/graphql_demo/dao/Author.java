package com.example.graphql_demo.dao;

import com.example.graphql_demo.model.CreateAuthorInput;
import com.example.graphql_demo.util.TimeUtils;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Data
public class Author {

    private String id;
    private String name;
    private OffsetDateTime birthDay;

    private static final List<Author> authors = new ArrayList<>();

    static {
        authors.add(
            new Author("96b5b8f1-9be5-4a50-a20f-5a2dd87f2062", "金庸", TimeUtils.generateByYYYYMMDD(1924, 3, 10)));
        authors.add(
            new Author("588ba158-afa9-4d9e-af61-944dc6532736", "張愛玲", TimeUtils.generateByYYYYMMDD(1920, 9, 30)));
        authors.add(
            new Author("d989a4d2-e6de-4626-9f6f-f43f9d8e4032", "朱自清", TimeUtils.generateByYYYYMMDD(1898, 11, 22)));
    }

    public static List<Author> getAll() {
        return authors;
    }

    public static Author getById(String id) {
        return authors.stream().filter(author -> author.getId().equals(id)).findFirst().orElse(null);
    }

    public static Author getAuthorByBookId(String bookId) {
        return Optional.ofNullable(Book.getById(bookId))
            .map(b -> Author.getById(b.getAuthorId()))
            .orElse(null);
    }

    public static Author createAuthor(CreateAuthorInput input) {
        final Author author = new Author(UUID.randomUUID().toString(), input.getName(), input.getBirthDay());
        authors.add(author);
        return author;
    }
}

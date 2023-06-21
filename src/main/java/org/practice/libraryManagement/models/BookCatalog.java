package org.practice.libraryManagement.models;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Getter
@Setter
public class BookCatalog {

    private final Map<String, List<BookCopy>> books;

    public BookCatalog() {
        this.books = new HashMap<>();
    }
}

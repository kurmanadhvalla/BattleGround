package org.practice.libraryManagement.services;

import org.practice.libraryManagement.models.Book;
import org.practice.libraryManagement.models.BookCopy;
import org.practice.libraryManagement.models.Library;

import java.util.List;

public interface LibraryManagementService {
    Library createLibrary(String libraryName);

    void addRack(int capacity, String libraryId);



    void addBook(String libraryId, String title, String author, String publisher);

    List<BookCopy> getAllBooks(String id);
}

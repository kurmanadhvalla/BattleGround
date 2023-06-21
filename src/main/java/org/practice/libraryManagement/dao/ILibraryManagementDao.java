package org.practice.libraryManagement.dao;

import org.practice.libraryManagement.models.BookCopy;
import org.practice.libraryManagement.models.Library;
import org.practice.libraryManagement.models.Rack;

import java.util.List;

public interface ILibraryManagementDao {
    Library createLibrary(String libraryName);
    void addRack(String libraryId, int capacity);
    Library getLibraryById(String libraryId);
    BookCopy addBook(Library library, Rack rack, String title, String author, String publisher);

    List<BookCopy> getBookCopiesByTitle(String libraryId, String title);

    List<BookCopy> getAllBooks(String libraryId);
}

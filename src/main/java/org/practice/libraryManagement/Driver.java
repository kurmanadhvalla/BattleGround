package org.practice.libraryManagement;

import org.practice.libraryManagement.dao.ILibraryManagementDao;
import org.practice.libraryManagement.dao.LibraryManagementDaoImpl;
import org.practice.libraryManagement.models.Book;
import org.practice.libraryManagement.models.BookCopy;
import org.practice.libraryManagement.models.Library;
import org.practice.libraryManagement.services.LibraryManagementService;
import org.practice.libraryManagement.services.LibraryManagementServiceImpl;

public class Driver {
    public static void main(String[] args) {
        ILibraryManagementDao libraryManagementDao = new LibraryManagementDaoImpl();
        LibraryManagementService libraryManagementService = new LibraryManagementServiceImpl(libraryManagementDao);
        Library library = libraryManagementService.createLibrary("library");
        libraryManagementService.addRack( 15, library.getId());
        libraryManagementService.addRack( 15, library.getId());
        libraryManagementService.addBook(library.getId(), "title1","author1","publisher1");
        libraryManagementService.addBook(library.getId(), "title1","author1","publisher1");
        libraryManagementService.addBook(library.getId(), "title2","author2","publisher2");
        for(BookCopy bookCopy :libraryManagementService.getAllBooks(library.getId())){
            System.out.println(bookCopy.getCopyId()+ " "+bookCopy.getBook().getTitle());
        }
    }
}

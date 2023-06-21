package org.practice.libraryManagement.services;

import org.practice.libraryManagement.dao.ILibraryManagementDao;
import org.practice.libraryManagement.models.Book;
import org.practice.libraryManagement.models.BookCopy;
import org.practice.libraryManagement.models.Library;
import org.practice.libraryManagement.models.Rack;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LibraryManagementServiceImpl implements LibraryManagementService {

    private  final ILibraryManagementDao libraryManagementDao;

    public LibraryManagementServiceImpl(ILibraryManagementDao libraryManagementDao){
        this.libraryManagementDao =libraryManagementDao;

    }

    @Override
    public Library createLibrary(String libraryName) {
        return libraryManagementDao.createLibrary(libraryName);
    }

    @Override
    public void addRack(int capacity, String libraryId) {
           libraryManagementDao.addRack(libraryId,capacity);
    }



    @Override
    public void addBook(String libraryId, String title, String author, String publisher) {
//        Library library = libraryManagementDao.getLibraryById(libraryId);
//        List<Book> bookCopies = getAvailableCopiesOfBook(libraryId,title);
//        Set<Integer> racks =  bookCopies.stream().map(Book::getRackId).collect(Collectors.toSet());
//        Rack rackToAdd=null;
//        for(Rack rack: library.getRacks()){
//           if(!racks.contains(rack.getRackId())  && rack.getBooks().size()<rack.getCapacity())
//               rackToAdd =rack;
//        }
//        libraryManagementDao.addBook(library,rackToAdd,  title,  author,  publisher);

    }

    @Override
    public List<BookCopy> getAllBooks(String libraryId) {
        return libraryManagementDao.getAllBooks(libraryId);
    }

//    private List<Book> getAvailableCopiesOfBook(String libraryId, String title) {
//        return libraryManagementDao.getBookCopiesByTitle(libraryId,title);
//    }
}

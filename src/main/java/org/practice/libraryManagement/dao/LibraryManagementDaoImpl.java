package org.practice.libraryManagement.dao;

import org.practice.libraryManagement.models.*;

import java.util.*;

public class LibraryManagementDaoImpl implements ILibraryManagementDao {

    private final Map<String,Library> libraries;
    private final Map<String, BookCatalog> libraryBookCatalogs;

    public LibraryManagementDaoImpl(){
        this.libraries = new HashMap<>();
        this.libraryBookCatalogs = new HashMap<>();
    }
    @Override
    public Library createLibrary(String libraryName) {
        Library library = new Library(UUID.randomUUID().toString(),libraryName);
        libraries.put(library.getId(),library);
        libraryBookCatalogs.put(library.getId(),new BookCatalog());
        return library;
    }

    @Override
    public void addRack(String libraryId, int capacity) {
        Library library = getLibraryById(libraryId);
        int size =  library.getRacks().size();
        library.getRacks().add(new Rack(size+1,capacity));
        libraries.put(libraryId,library);
    }

    public  Library getLibraryById(String libraryId) {
        // throw exception
        return libraries.get(libraryId);
    }

    @Override
    public BookCopy addBook(Library library, Rack rack, String title, String author, String publisher) {

        // add book to rack
        Book book = new Book(title,author,publisher);
        BookCopy bookCopy = new BookCopy(UUID.randomUUID().toString(),book,library.getId(), rack.getRackId());
        library.getRacks().get(rack.getRackId()-1).getBooks().put(bookCopy.getCopyId(),bookCopy);
        List<BookCopy> books = libraryBookCatalogs.get(library.getId()).getBooks().getOrDefault(title,new ArrayList<>());
        books.add(bookCopy);
        libraryBookCatalogs.get(library.getId()).getBooks().put(title,books);
        //add book to bookcatalog
        return bookCopy;
    }

    @Override
    public List<BookCopy> getBookCopiesByTitle(String libraryId, String title) {
        BookCatalog bookCatalog = libraryBookCatalogs.get(libraryId);
        if(bookCatalog!=null){
           return new ArrayList<>(bookCatalog.getBooks().getOrDefault(title, new ArrayList<>()));
        }
        return null;
    }

    @Override
    public List<BookCopy> getAllBooks(String libraryId) {
        Library library = getLibraryById(libraryId);
        List<BookCopy> books = new ArrayList<>();
        for(Rack rack : library.getRacks()){
            books.addAll(rack.getBooks().values());
        }
        return books;
    }
}

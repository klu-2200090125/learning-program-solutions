package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private String libraryName; // for constructor injection
    private BookRepository bookRepository; // for setter injection

    // Constructor for libraryName injection
    public BookService(String libraryName) {
        this.libraryName = libraryName;
    }

    // Setter for BookRepository injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void displayBook(int id) {
        String book = bookRepository.getBookById(id);
        System.out.println("Library: " + libraryName + " | " + book);
    }
}

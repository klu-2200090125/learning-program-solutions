package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        // Load Spring application context
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Retrieve the BookService bean with injected dependency
        BookService bookService = (BookService) context.getBean("bookService");

        // Test adding a book
        bookService.addBook("Spring in Action by Craig Walls");
    }
}

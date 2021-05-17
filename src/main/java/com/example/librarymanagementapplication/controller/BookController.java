/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 13-May-21
 *   Time: 10:09 PM
 *   File: BookController.java
 */

package com.example.librarymanagementapplication.controller;

import com.example.librarymanagementapplication.exception.BookNotFoundException;
import com.example.librarymanagementapplication.model.Book;
import com.example.librarymanagementapplication.repository.BookRepository;
import com.example.librarymanagementapplication.repository.UserRepository;
import com.example.librarymanagementapplication.util.BookValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    UserRepository userRepository;

    BookValidator bookValidator = new BookValidator();

    @GetMapping("/books")
    List<Book> findAll() {
        List<Book> list = new ArrayList<>();
        try {
            list = bookRepository.findAll();
            if (list.size() == 0) {
                throw new BookNotFoundException();
            }
        }
        catch(BookNotFoundException exc)
        {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "No Book Found", exc);
        }
        return list;
    }

    @PostMapping("/books")
    @ResponseStatus(HttpStatus.CREATED)
    Book newBook(@RequestBody Book newBook) {
        if (bookValidator.isValid(newBook))
            return bookRepository.save(newBook);
        else {
            return null;
        }
    }

    @GetMapping(value = "/searchBooksByAuthor")
    public List<Book> searchBooksByAuthor(@RequestParam(value = "q") String author){
        List<Book> books = bookRepository.findAll();
        ArrayList<Book> list = new ArrayList<Book>();
        for(Book book : books){
            if(book.getAuthor().equals(author)) list.add(book);
        }
        return list;
    }
}


/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 13-May-21
 *   Time: 10:10 PM
 *   File: IssuedBooksController.java
 */

package com.example.librarymanagementapplication.controller;

import com.example.librarymanagementapplication.model.IssuedBooks;
import com.example.librarymanagementapplication.repository.IssuedBooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IssuedBooksController {
    @Autowired
    IssuedBooksRepository issuedBooksRepository;

    @GetMapping("/issuedBooks")
    public List<IssuedBooks> findAllIssuedBooks(){
        return issuedBooksRepository.findAll();
    }

    @PostMapping(value = "/issueBook")
    @ResponseStatus(HttpStatus.CREATED)
    public IssuedBooks issueBook(@RequestBody IssuedBooks issuedBooks) throws Exception{
        try {
            return issuedBooksRepository.save(issuedBooks);
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception();
        }
    }
}


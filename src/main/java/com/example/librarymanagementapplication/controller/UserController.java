/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 13-May-21
 *   Time: 10:11 PM
 *   File: UserController.java
 */

package com.example.librarymanagementapplication.controller;

import com.example.librarymanagementapplication.exception.UserNotFoundException;
import com.example.librarymanagementapplication.model.User;
import com.example.librarymanagementapplication.repository.UserRepository;
import com.example.librarymanagementapplication.util.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> findAll(){
        return userRepository.findAll();
    }
    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    public User addUser(@RequestBody User newUser) throws Exception {
        if(UserValidator.isValidUser(newUser)){
            return userRepository.save(newUser);
        }
       else throw new Exception();
    }

    @GetMapping("/users/{id}")
    User findOne(@PathVariable int id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }
}


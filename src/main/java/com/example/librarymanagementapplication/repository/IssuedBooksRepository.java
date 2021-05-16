package com.example.librarymanagementapplication.repository;

import com.example.librarymanagementapplication.model.IssuedBooks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssuedBooksRepository extends JpaRepository<IssuedBooks,Integer> {
}

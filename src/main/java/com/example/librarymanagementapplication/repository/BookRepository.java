package com.example.librarymanagementapplication.repository;

import com.example.librarymanagementapplication.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
}

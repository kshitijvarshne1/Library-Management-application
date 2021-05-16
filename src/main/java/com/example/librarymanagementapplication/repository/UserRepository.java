package com.example.librarymanagementapplication.repository;

import com.example.librarymanagementapplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Integer> {
}

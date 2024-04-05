package com.example.apireactevaluation.repository;

import com.example.apireactevaluation.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}

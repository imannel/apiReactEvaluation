package com.example.apireactevaluation.service;

import com.example.apireactevaluation.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();

    Book addBook(Book book);

    Book getBookById(Long id);

    void deleteBookById(Long id);

    Book addBookToUserLibrary(Long userId, Long bookId);

    List<Book> searchBook(String keyword);
}

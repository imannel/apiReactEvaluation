package com.example.apireactevaluation.controller;

import com.example.apireactevaluation.entity.Book;
import com.example.apireactevaluation.entity.User;
import com.example.apireactevaluation.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin ("*")
@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    // Endpoint pour récupérer tous les livres
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    // Endpoint pour ajouter un nouveau livre
    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book newBook = bookService.addBook(book);
        return new ResponseEntity<>(newBook, HttpStatus.CREATED);
    }

    // Endpoint pour récupérer un livre par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") Long id) {
        Book book = bookService.getBookById(id);
        if (book != null) {
            return new ResponseEntity<>(book, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint pour supprimer un livre par son ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookById(@PathVariable("id") Long id) {
        bookService.deleteBookById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Endpoint pour ajouter un livre à la bibliothèque personnelle de l'utilisateur
    @PostMapping("/add-to-library/{userId}/{bookId}")
    public ResponseEntity<Book> addBookToUserLibrary(@PathVariable("userId") Long userId, @PathVariable("bookId") Long bookId) {
        Book book = bookService.addBookToUserLibrary(userId, bookId);
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }
    @GetMapping("/search")
    public List<Book> searchBooks(@RequestParam(name="keyword",defaultValue = "")String keyword){
        return bookService.searchBook("%"+keyword+"%");
    }
}

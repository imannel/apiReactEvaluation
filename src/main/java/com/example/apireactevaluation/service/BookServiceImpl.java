package com.example.apireactevaluation.service;

import com.example.apireactevaluation.entity.Book;
import com.example.apireactevaluation.entity.UserLibrary;
import com.example.apireactevaluation.repository.BookRepository;
import com.example.apireactevaluation.repository.UserLibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{
        @Autowired
        private BookRepository bookRepository;
        @Autowired
        private UserLibraryRepository userLibraryRepository;
        @Override
        public List<Book> getAllBooks() {
            return bookRepository.findAll();
        }
        @Override
        public Book addBook(Book book) {
            return bookRepository.save(book);
        }
        @Override
        public Book getBookById(Long id) {
            return bookRepository.findById(id).orElse(null);
        }
        @Override
        public void deleteBookById(Long id) {
            bookRepository.deleteById(id);
        }
        @Override
        public Book addBookToUserLibrary(Long userId, Long bookId) {
            // Vérifie si le livre existe dans la bibliothèque globale
            Book book = bookRepository.findById(bookId)
                    .orElseThrow(() -> new RuntimeException("Ce livre n'est pas disponible pour le moment."));

            // Récupère la bibliothèque personnelle de l'utilisateur
            UserLibrary userLibrary = (UserLibrary) userLibraryRepository.findByUserId(userId).orElseThrow(() -> new RuntimeException("La bibliothèque personnelle de l'utilisateur n'a pas été trouvée."));

            // Vérifie si le livre est déjà présent dans la bibliothèque personnelle de l'utilisateur
            if (userLibrary.getBooks().stream().anyMatch(b -> b.getId().equals(bookId))) {
                throw new RuntimeException("Ce livre est déjà dans votre bibliothèque.");
            }

            // Ajoute le livre à la bibliothèque personnelle de l'utilisateur
            userLibrary.getBooks().add(book);
            userLibraryRepository.save(userLibrary);

            return book;
        }
    @Override
    public List<Book> searchBook(String keyword) {
        return bookRepository.searchBook(keyword);
    }


}



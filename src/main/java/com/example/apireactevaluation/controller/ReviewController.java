package com.example.apireactevaluation.controller;

import com.example.apireactevaluation.entity.Review;
import com.example.apireactevaluation.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin ("*")
@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    // Endpoint pour récupérer toutes les critiques
    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews() {
        List<Review> reviews = reviewService.getAllReviews();
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    // Endpoint pour ajouter une nouvelle critique
    @PostMapping
    public ResponseEntity<Review> addReview(@RequestBody Review review) {
        Review newReview = reviewService.addReview(review);
        return new ResponseEntity<>(newReview, HttpStatus.CREATED);
    }

    // Endpoint pour récupérer les critiques d'un livre par son ID
    @GetMapping("/book/{bookId}")
    public ResponseEntity<List<Review>> getReviewsByBookId(@PathVariable("bookId") Long bookId) {
        List<Review> reviews = reviewService.getReviewsByBookId(bookId);
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    // Endpoint pour récupérer les critiques d'un utilisateur par son ID
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Review>> getReviewsByUserId(@PathVariable("userId") Long userId) {
        List<Review> reviews = reviewService.getReviewsByUserId(userId);
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    // Endpoint pour supprimer une critique par son ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReviewById(@PathVariable("id") Long id) {
        reviewService.deleteReviewById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Endpoint pour ajouter une critique à un livre
    @PostMapping("/add-review/{userId}/{bookId}")
    public ResponseEntity<Review> addReview(@PathVariable("userId") Long userId, @PathVariable("bookId") Long bookId, @RequestParam String comment, @RequestParam int rating) {
        Review review = reviewService.addReview(userId, bookId, comment, rating);
        return new ResponseEntity<>(review, HttpStatus.CREATED);
    }
}
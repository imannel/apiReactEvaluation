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

    @GetMapping("/book/{bookId}")
    public ResponseEntity<List<Review>> getReviewsByBookId(@PathVariable("bookId") Long bookId) {
        List<Review> reviews = reviewService.getReviewsByBookId(bookId);
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Review>> getReviewsByUserId(@PathVariable("userId") Long userId) {
        List<Review> reviews = reviewService.getReviewsByUserId(userId);
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReviewById(@PathVariable("id") Long id) {
        reviewService.deleteReviewById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/add-review/{userId}/{bookId}")
    public ResponseEntity<Review> addReview(@PathVariable("userId") Long userId, @PathVariable("bookId") Long bookId, @RequestParam String comment, @RequestParam int rating) {
        Review review = reviewService.addReview(userId, bookId, comment, rating);
        return new ResponseEntity<>(review, HttpStatus.CREATED);
    }
}
package com.example.apireactevaluation.service;

import com.example.apireactevaluation.entity.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews();

    Review addReview(Review review);

    List<Review> getReviewsByBookId(Long bookId);

    List<Review> getReviewsByUserId(Long userId);

    void deleteReviewById(Long id);

    Review addReview(Long userId, Long bookId, String comment, int rating);
}

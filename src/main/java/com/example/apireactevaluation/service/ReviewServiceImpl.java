package com.example.apireactevaluation.service;

import com.example.apireactevaluation.entity.Book;
import com.example.apireactevaluation.entity.Review;
import com.example.apireactevaluation.entity.User;
import com.example.apireactevaluation.repository.BookRepository;
import com.example.apireactevaluation.repository.ReviewRepository;
import com.example.apireactevaluation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookRepository bookRepository;
    @Override
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }
    @Override
    public Review addReview(Review review) {
        return reviewRepository.save(review);
    }
    @Override
    public List<Review> getReviewsByBookId(Long bookId) {
        return reviewRepository.findByBookId(bookId);
    }
    @Override
    public List<Review> getReviewsByUserId(Long userId) {
        return reviewRepository.findByUserId(userId);
    }
    @Override
    public void deleteReviewById(Long id) {
        reviewRepository.deleteById(id);
    }
    @Override
    public Review addReview(Long userId, Long bookId, String comment, int rating) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé."));
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Livre non trouvé."));

        Review review = new Review();
        review.setUser(user);
        review.setBook(book);
        review.setComment(comment);
        review.setRating(rating);

        return reviewRepository.save(review);
    }
}

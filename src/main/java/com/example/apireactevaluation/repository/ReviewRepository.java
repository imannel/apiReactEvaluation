package com.example.apireactevaluation.repository;

import com.example.apireactevaluation.entity.Book;
import com.example.apireactevaluation.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review,Long> {
    List<Review> findByBookId(Long bookId);

    List<Review> findByUserId(Long userId);
}

package com.example.apireactevaluation.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
    public class Review {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @ManyToOne
        private Book book;
        @ManyToOne
        private User user;
        private String comment;
        private int rating;
    }


package com.example.apireactevaluation.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class UserLibrary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "user_id", unique = true)
    private User user;

    @OneToMany
    @JoinColumn(name = "user_library_id") // Ajout d'une colonne pour représenter la clé étrangère vers UserLibrary
    private List<Book> books;
}

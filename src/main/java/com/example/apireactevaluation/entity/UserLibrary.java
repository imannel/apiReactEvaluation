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
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "user_id", unique = true)
    private User user;

    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "user_library_id") // Ajout d'une colonne pour représenter la clé étrangère vers UserLibrary
    private List<Book> books;
}

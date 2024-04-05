package com.example.apireactevaluation.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;


import java.util.List;
@Data
@Entity

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String email;
    private String cin;

    @Column
    private String password;


    @OneToMany
    @JsonIgnore
    private List<Book> books;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private UserLibrary userLibrary;

    public User() {
        this.userLibrary = new UserLibrary();
        this.userLibrary.setUser(this);
    }

}

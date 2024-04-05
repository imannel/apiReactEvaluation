package com.example.apireactevaluation.repository;

import com.example.apireactevaluation.entity.UserLibrary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserLibraryRepository extends JpaRepository<UserLibrary, Long> {
    Optional<Object> findByUserId(Long userId);
}

package com.example.apireactevaluation.repository;

import com.example.apireactevaluation.entity.Book;
import com.example.apireactevaluation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    @Query("select u from User u where u.name like :kw")
    List<User> searchUser(@Param("kw")String keyword);
}

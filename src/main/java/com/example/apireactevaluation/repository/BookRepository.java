package com.example.apireactevaluation.repository;

import com.example.apireactevaluation.entity.Book;
import com.example.apireactevaluation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {
    @Query("select b from Book b where b.title like :kw")
    List<Book> searchBook(@Param("kw")String keyword);
}

package com.javaexercise.challenge.repositories;

import com.javaexercise.challenge.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {

    @Query("Select b from Book b where b.title like %:title%")
    List<Book> findByPartialTitle(String title);
}

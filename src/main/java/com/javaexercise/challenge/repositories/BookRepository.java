package com.javaexercise.challenge.repositories;

import com.javaexercise.challenge.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {

}

package com.javaexercise.challenge.repositories;

import com.javaexercise.challenge.entities.BookAuthor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookAuthorRepository extends JpaRepository<BookAuthor,Long> {
}

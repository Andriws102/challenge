package com.javaexercise.challenge.repositories;

import com.javaexercise.challenge.entities.Author;
import com.javaexercise.challenge.entities.BookAuthor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookAuthorRepository extends JpaRepository<BookAuthor,Long> {

    List<BookAuthor> findByBookId(Long bookId);

    @Query(value = "Select ba from BookAuthor ba where author in :authors")
    List<BookAuthor> findByAuthor(List<Author> authors);
}

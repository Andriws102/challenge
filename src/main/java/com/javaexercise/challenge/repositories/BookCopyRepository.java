package com.javaexercise.challenge.repositories;

import com.javaexercise.challenge.entities.BookCopy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookCopyRepository extends JpaRepository<BookCopy,Long> {

    List<BookCopy> findByBookId(Long bookId);
}

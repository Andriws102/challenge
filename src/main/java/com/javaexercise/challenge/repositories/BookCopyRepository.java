package com.javaexercise.challenge.repositories;

import com.javaexercise.challenge.entities.BookCopy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookCopyRepository extends JpaRepository<BookCopy,Long> {
}

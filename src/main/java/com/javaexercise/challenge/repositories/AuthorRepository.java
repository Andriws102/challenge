package com.javaexercise.challenge.repositories;

import com.javaexercise.challenge.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Long> {
}

package com.javaexercise.challenge.repositories;

import com.javaexercise.challenge.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author,Long> {

    List<Author> findByName(String name);
}

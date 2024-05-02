package com.javaexercise.challenge.repositories;

import com.javaexercise.challenge.entities.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher,Long> {
}

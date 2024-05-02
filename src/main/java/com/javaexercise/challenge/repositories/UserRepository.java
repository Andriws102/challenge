package com.javaexercise.challenge.repositories;

import com.javaexercise.challenge.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}

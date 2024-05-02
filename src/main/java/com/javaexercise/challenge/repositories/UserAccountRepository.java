package com.javaexercise.challenge.repositories;

import com.javaexercise.challenge.entities.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
}

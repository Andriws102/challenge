package com.javaexercise.challenge.services.impl;

import com.javaexercise.challenge.entities.Book;
import com.javaexercise.challenge.repositories.BookRepository;
import com.javaexercise.challenge.services.GetBookById;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@RequiredArgsConstructor
@Slf4j
public class GetBookByIdImpl implements GetBookById {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Optional<Book> apply(Long id) {
        var result = bookRepository.findById(id);
        return result;
    }
}

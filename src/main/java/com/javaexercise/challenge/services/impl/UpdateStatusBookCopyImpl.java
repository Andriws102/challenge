package com.javaexercise.challenge.services.impl;

import com.javaexercise.challenge.dtos.UpdateBookStatusRequestDTO;
import com.javaexercise.challenge.entities.BookCopy;
import com.javaexercise.challenge.repositories.BookCopyRepository;
import com.javaexercise.challenge.services.UpdateStatusBookCopy;
import io.micrometer.observation.annotation.Observed;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class UpdateStatusBookCopyImpl implements UpdateStatusBookCopy {

    @Autowired
    private BookCopyRepository bookCopyRepository;

    @Override
    @Observed(name = "UpdateStatusBookCopyImpl")
    public BookCopy apply(UpdateBookStatusRequestDTO updateBookStatusRequestDTO) {

        var bookCopy = bookCopyRepository.findById(updateBookStatusRequestDTO.getBookCopyId());

        if(bookCopy.isPresent()) {
            bookCopy.get().setStatusId(updateBookStatusRequestDTO.getStatusId());

            return bookCopyRepository.save(bookCopy.get());
        }else{
            log.info("BookCopy with id:{updateBookStatusRequestDTO.getBookCopyId()} not found");
            return null;
        }
    }
}

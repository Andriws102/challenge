package com.javaexercise.challenge.controllers;

import com.javaexercise.challenge.dtos.GetBookByIdRequestDTO;
import com.javaexercise.challenge.dtos.GetBookByTitleRequestDTO;
import com.javaexercise.challenge.dtos.GetBookResponseDTO;
import com.javaexercise.challenge.dtos.GetBooksResponseDTO;
import com.javaexercise.challenge.services.GetBookById;
import com.javaexercise.challenge.services.GetBookByTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private GetBookById getBookById;

    @Autowired
    private GetBookByTitle getBookByTitle;

    @GetMapping("/{id}")
    public GetBookResponseDTO getBook(@PathVariable Long id, @RequestParam Optional<Boolean> alldata) {
        return getBookById.apply(GetBookByIdRequestDTO.builder().id(id).allData(alldata.orElse(false)).build());
    }

    @GetMapping("/getbytitle")
    public GetBooksResponseDTO getBook(@RequestParam String title, @RequestParam Optional<Boolean> alldata) {
        return getBookByTitle.apply(GetBookByTitleRequestDTO.builder().title(title).allData(alldata.orElse(false)).build());
    }
}

package com.javaexercise.challenge.controllers;

import com.javaexercise.challenge.dtos.*;
import com.javaexercise.challenge.services.GetBookByAuthor;
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

    @Autowired
    private GetBookByAuthor getBookByAuthor;

    @GetMapping("/{id}")
    public GetBookResponseDTO getBookById(@PathVariable Long id,
                                          @RequestParam Optional<Boolean> alldata,
                                          @RequestParam Optional<Boolean> onlyavailable) {
        return getBookById.apply(
                GetBookByIdRequestDTO.builder()
                        .id(id)
                        .allData(alldata.orElse(false))
                        .onlyAvailable(onlyavailable.orElse(false))
                        .build());
    }

    @GetMapping("/getbytitle")
    public GetBooksResponseDTO getBookByTitle(@RequestParam String title,
                                              @RequestParam Optional<Boolean> alldata,
                                              @RequestParam Optional<Boolean> onlyavailable) {
        return getBookByTitle.apply(
                GetBookByTitleRequestDTO.builder()
                        .title(title)
                        .allData(alldata.orElse(false))
                        .onlyAvailable(onlyavailable.orElse(false))
                        .build());
    }

        @GetMapping("/getbyauthor")
    public GetBooksResponseDTO getBookByAuthor(@RequestParam String authorname,
                                               @RequestParam Optional<Boolean> alldata,
                                               @RequestParam Optional<Boolean> onlyavailable) {
        return getBookByAuthor.apply(
                GetBookByAuthorRequestDTO.builder()
                        .authorName(authorname)
                        .allData(alldata.orElse(false))
                        .onlyAvailable(onlyavailable.orElse(false))
                        .build());
    }
}

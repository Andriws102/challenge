package com.javaexercise.challenge.entities;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "books_authors")
@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookAuthor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private Author author;
    private int orderPosition;
}

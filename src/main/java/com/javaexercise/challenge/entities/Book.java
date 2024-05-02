package com.javaexercise.challenge.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Table(name = "books")
@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    private String summary;
    private Date published_at;
    @Column(nullable = false)
    private Date created_at;
    @OneToMany(mappedBy = "book")
    private Set<BookCopy> publishers;
    @OneToMany(mappedBy = "book")
    private Set<BookAuthor> authors;
    @OneToMany(mappedBy = "book")
    private Set<Review> reviews;
}

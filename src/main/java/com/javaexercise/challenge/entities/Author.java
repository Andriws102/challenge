package com.javaexercise.challenge.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Table(name = "authors")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String lastname;
    private String country;
    @OneToMany(mappedBy = "book")
    private Set<BookAuthor> books;
}

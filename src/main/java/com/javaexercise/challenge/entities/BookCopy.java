package com.javaexercise.challenge.entities;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "books_copies")
@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookCopy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;
    @OneToOne
    @JoinColumn(name = "publisher_id", referencedColumnName = "id")
    private Publisher publisher;
    @Column(nullable = false)
    private int statusId;
}

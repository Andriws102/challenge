package com.javaexercise.challenge.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Table(name = "publishers")
@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    private String country;
    @OneToMany(mappedBy = "publisher")
    private Set<BookCopy> books;
}

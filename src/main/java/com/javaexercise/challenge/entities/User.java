package com.javaexercise.challenge.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Table(name = "users")
@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String lastname;
    private int age;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String contactNumber;
    @Column(nullable = false)
    private Date createdAt;
    @Column(nullable = false)
    private int statusId;
}

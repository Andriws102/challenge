package com.javaexercise.challenge.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Table(name = "user_accounts")
@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private Date createdAt;
    @Column(nullable = false)
    private int statusId;
}

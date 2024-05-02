package com.javaexercise.challenge.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Table(name = "booking")
@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_copy_id", referencedColumnName = "id")
    private BookCopy bookCopy;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    @Column(nullable = false)
    private Date bookingAt;
    @Column(nullable = false)
    private Date bookingSince;
    @Column(nullable = false)
    private Date bookingUntil;
    private Date returnedAt;
    @Column(nullable = false)
    private int status_id;
}

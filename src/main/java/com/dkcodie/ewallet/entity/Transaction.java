package com.dkcodie.ewallet.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Unique Transaction ID

    @ManyToOne
    @JoinColumn(name = "sender_id", nullable = false)
    private User sender; // Reference to the sender's User entity

    @ManyToOne
    @JoinColumn(name = "receiver_id", nullable = false)
    private User receiver; // Reference to the receiver's User entity

    @Column(nullable = false)
    private Double amount; // Transaction amount

    @Column(nullable = false)
    private LocalDateTime timestamp;
}

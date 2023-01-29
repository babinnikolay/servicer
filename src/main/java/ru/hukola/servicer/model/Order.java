package ru.hukola.servicer.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

/**
 * @author Babin Nikolay
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;
    private LocalDate date;
    @OneToOne
    private Client client;
    private double amount;
}

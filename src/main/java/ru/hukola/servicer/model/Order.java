package ru.hukola.servicer.model;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Babin Nikolay
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {
    private int id;
    private String description;
    private LocalDate date;
    private Client client;
    private double amount;
}

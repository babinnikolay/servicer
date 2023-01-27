package ru.hukola.servicer.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.hukola.servicer.model.Client;

import java.time.LocalDate;

/**
 * @author Babin Nikolay
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private int id;
    private String description;
    private LocalDate date;
    private int client;
    private double amount;
}

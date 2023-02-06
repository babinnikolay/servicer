package ru.hukola.servicer.model.dto;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import ru.hukola.servicer.model.Client;

import java.time.LocalDate;

/**
 * @author Babin Nikolay
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDTO {
    private int id;
    private String description;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private int clientId;
    private String clientName;
    private int creatorId;
    private String creatorName;
    private double amount;
    private boolean paid;
}

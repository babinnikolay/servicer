package ru.hukola.servicer.model.dto;

import lombok.*;

/**
 * @author Babin Nikolay
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientDto {
    private int id;
    private String name;
}

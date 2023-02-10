package ru.hukola.servicer.model.dto;

import lombok.Data;

/**
 * @author Babin Nikolay
 */
@Data
public class OrderFilter {
    private boolean onlyUnpaid = false;
}

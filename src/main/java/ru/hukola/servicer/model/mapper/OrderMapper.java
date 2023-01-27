package ru.hukola.servicer.model.mapper;

import ru.hukola.servicer.model.Order;
import ru.hukola.servicer.model.dto.OrderDTO;

/**
 * @author Babin Nikolay
 */

public class OrderMapper {
    public static Order toOrder(OrderDTO orderDTO) {
        return Order.builder()
                .amount(orderDTO.getAmount())
                .date(orderDTO.getDate())
                .description(orderDTO.getDescription())
                .build();
    }
}

package ru.hukola.servicer.model.mapper;

import ru.hukola.servicer.model.Order;
import ru.hukola.servicer.model.dto.OrderDTO;

import java.util.Optional;

/**
 * @author Babin Nikolay
 */

public class OrderMapper {
    public static Order toOrder(OrderDTO orderDTO) {
        return Order.builder()
                .amount(orderDTO.getAmount())
                .date(orderDTO.getDate())
                .description(orderDTO.getDescription())
                .paid(orderDTO.isPaid())
                .build();
    }

    public static OrderDTO toOrderDto(Order order) {
        return OrderDTO.builder()
                .amount(order.getAmount())
                .date(order.getDate())
                .description(order.getDescription())
                .paid(order.isPaid())
                .client(order.getClient().getId())
                .build();
    }
}

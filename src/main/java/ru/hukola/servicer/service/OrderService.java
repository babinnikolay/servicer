package ru.hukola.servicer.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.hukola.servicer.model.Order;
import ru.hukola.servicer.repository.OrderRepository;

import java.util.List;

/**
 * @author Babin Nikolay
 */
@Service
@AllArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    public List<Order> findAll() {
        return orderRepository.findAll();
    }
}

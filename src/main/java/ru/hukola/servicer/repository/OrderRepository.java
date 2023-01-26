package ru.hukola.servicer.repository;

import org.springframework.stereotype.Repository;
import ru.hukola.servicer.model.Order;

import java.util.Collections;
import java.util.List;

/**
 * @author Babin Nikolay
 */
@Repository
public class OrderRepository {
    private final List<Order> orders = List.of(new Order(1, "desc1"), new Order(2, "desc2"));
    public List<Order> findAll() {
        return orders;
    }
}

package ru.hukola.servicer.repository;

import ru.hukola.servicer.model.Order;

import java.util.List;

/**
 * @author Babin Nikolay
 */
public interface OrderRepository {
    List<Order> findAll();

    void save(Order order);
}

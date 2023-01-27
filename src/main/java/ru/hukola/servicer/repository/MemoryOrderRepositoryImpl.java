package ru.hukola.servicer.repository;

import org.springframework.stereotype.Repository;
import ru.hukola.servicer.model.Order;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Babin Nikolay
 */
@Repository
public class MemoryOrderRepositoryImpl implements OrderRepository{
    private final List<Order> orders = new ArrayList<>();
    {
        orders.add(new Order(1, "desc1", LocalDate.now(), null, 1.0));
    }
    @Override
    public List<Order> findAll() {
        return orders;
    }

    @Override
    public void save(Order order) {
        orders.add(order);
    }
}

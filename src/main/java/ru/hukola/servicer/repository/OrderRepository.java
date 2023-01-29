package ru.hukola.servicer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.hukola.servicer.model.Order;

/**
 * @author Babin Nikolay
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}

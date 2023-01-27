package ru.hukola.servicer.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.hukola.servicer.model.Order;
import ru.hukola.servicer.model.dto.OrderDTO;
import ru.hukola.servicer.model.mapper.OrderMapper;
import ru.hukola.servicer.repository.ClientRepository;
import ru.hukola.servicer.repository.MemoryOrderRepositoryImpl;
import ru.hukola.servicer.repository.OrderRepository;

import java.util.List;

/**
 * @author Babin Nikolay
 */
@Service
@AllArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final ClientRepository clientRepository;

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public void save(OrderDTO orderDTO) {
        Order order = OrderMapper.toOrder(orderDTO);
        order.setClient(clientRepository.findById(orderDTO.getClient()));
        orderRepository.save(order);
    }
}

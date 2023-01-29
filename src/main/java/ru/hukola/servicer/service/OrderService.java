package ru.hukola.servicer.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.hukola.servicer.exception.NotFoundException;
import ru.hukola.servicer.model.Client;
import ru.hukola.servicer.model.Order;
import ru.hukola.servicer.model.dto.OrderDTO;
import ru.hukola.servicer.model.mapper.OrderMapper;
import ru.hukola.servicer.repository.ClientRepository;
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

    public void save(OrderDTO orderDTO) throws NotFoundException {
        Order order = OrderMapper.toOrder(orderDTO);
        Client client = clientRepository.findById(orderDTO.getClient()).orElseThrow(
                () -> new NotFoundException(String.format("User with id=%n not found", orderDTO.getClient())));
        order.setClient(client);
        orderRepository.save(order);
    }
}

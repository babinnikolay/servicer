package ru.hukola.servicer.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.hukola.servicer.exception.NotFoundException;
import ru.hukola.servicer.model.Client;
import ru.hukola.servicer.model.Order;
import ru.hukola.servicer.model.SiteUser;
import ru.hukola.servicer.model.dto.OrderDTO;
import ru.hukola.servicer.model.mapper.OrderMapper;
import ru.hukola.servicer.repository.ClientRepository;
import ru.hukola.servicer.repository.OrderRepository;
import ru.hukola.servicer.repository.SiteUserRepository;

import java.util.List;

/**
 * @author Babin Nikolay
 */
@Service
@AllArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final ClientRepository clientRepository;
    private final SiteUserRepository siteUserRepository;

    public List<OrderDTO> findAll(boolean onlyUnpaid) {
        List<Order> list;
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        if (onlyUnpaid) {
            list = orderRepository.findAllByPaidNot(onlyUnpaid, sort);
        } else {
            list = orderRepository.findAll(sort);
        }
        return list.stream().map(OrderMapper::toOrderDto).toList();
    }

    public void save(OrderDTO orderDTO, int userId) throws NotFoundException {
        Order order = OrderMapper.toOrder(orderDTO);
        Client client = clientRepository.findById(orderDTO.getClientId()).orElseThrow(
                () -> new NotFoundException(String.format("Client with id=%n not found", orderDTO.getClientId())));
        SiteUser siteUser = siteUserRepository.findById(userId).orElseThrow(
                () -> new NotFoundException(String.format("User with id=%n not found", userId))
        );
        order.setClient(client);
        order.setCreator(siteUser);
        orderRepository.save(order);
    }

    public OrderDTO findById(int id) throws NotFoundException {
        Order order = orderRepository.findById(id).orElseThrow(
                () -> new NotFoundException(String.format("Order with id=%s not found", id)));
        return OrderMapper.toOrderDto(order);
    }

    public void update(int id, OrderDTO orderDTO) throws NotFoundException {
        Order order = orderRepository.findById(id).orElseThrow(
                () -> new NotFoundException(String.format("Order with id=%s not found", id))
        );
        Client client = clientRepository.findById(orderDTO.getClientId()).orElseThrow(
                () -> new NotFoundException(String.format("User with id=%n not found", orderDTO.getClientId())));
        order.setAmount(orderDTO.getAmount());
        order.setDescription(orderDTO.getDescription());
        order.setDate(orderDTO.getDate());
        order.setPaid(orderDTO.isPaid());
        order.setClient(client);

        orderRepository.save(order);
    }
}

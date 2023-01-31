package ru.hukola.servicer.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.hukola.servicer.exception.NotFoundException;
import ru.hukola.servicer.model.Order;
import ru.hukola.servicer.model.dto.OrderDTO;
import ru.hukola.servicer.service.ClientService;
import ru.hukola.servicer.service.OrderService;

/**
 * @author Babin Nikolay
 */
@Controller
@AllArgsConstructor
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private final ClientService clientService;

    @GetMapping
    public String showOrders(Model model) {
        model.addAttribute("orders", orderService.findAll());
        return "orders/orders";
    }

    @GetMapping("/new")
    public String showNewForm(Model model) {
        model.addAttribute("order", new OrderDTO());
        model.addAttribute("clients", clientService.findAll());
        return "orders/new";
    }

    @PostMapping
    public String newOrder(@ModelAttribute("order") OrderDTO order) throws NotFoundException {
        orderService.save(order);
        return "redirect:/orders";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable int id) throws NotFoundException {
        OrderDTO order = orderService.findById(id);
        model.addAttribute("order", order);
        model.addAttribute("clients", clientService.findAll());
        return "orders/edit";
    }

    @PostMapping("/{id}/edit")
    public String edit(@ModelAttribute("order") OrderDTO order, @PathVariable int id) throws NotFoundException {
        orderService.update(id, order);
        return "redirect:/orders";
    }
}

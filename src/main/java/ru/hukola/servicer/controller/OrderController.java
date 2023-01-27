package ru.hukola.servicer.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
        model.addAttribute("order", new Order());
        model.addAttribute("clients", clientService.findAll());
        return "orders/new";
    }

    @PostMapping
    public String newOrder(@ModelAttribute("order") OrderDTO order) {
        orderService.save(order);
        return "redirect:/orders";
    }


}

package ru.hukola.servicer.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.hukola.servicer.service.OrderService;

/**
 * @author Babin Nikolay
 */
@Controller
@AllArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/orders")
    public String showOrders(Model model) {
        model.addAttribute("orders", orderService.findAll());
        return "orders/orders";
    }


}

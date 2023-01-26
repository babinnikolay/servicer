package ru.hukola.servicer.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.hukola.servicer.model.Client;
import ru.hukola.servicer.service.ClientService;

/**
 * @author Babin Nikolay
 */
@Controller
@AllArgsConstructor
@RequestMapping("/clients")
public class ClientController {
    private final ClientService clientService;

    @GetMapping
    public String showClients(Model model) {
        model.addAttribute("clients", clientService.findAll());
        return "clients/clients";
    }

    @GetMapping("/new")
    public String showNewForm(Model model) {
        model.addAttribute("client", new Client());
        return "clients/new";
    }

    @PostMapping
    public String newClient(@ModelAttribute("client") Client client) {
        clientService.save(client);
        return "redirect:/clients";
    }
}

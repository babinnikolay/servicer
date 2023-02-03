package ru.hukola.servicer.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.hukola.servicer.exception.NotFoundException;
import ru.hukola.servicer.model.SiteRole;
import ru.hukola.servicer.model.SiteUser;
import ru.hukola.servicer.model.dto.OrderDTO;
import ru.hukola.servicer.model.dto.SiteUserDto;
import ru.hukola.servicer.service.SiteUserService;

/**
 * @author Babin Nikolay
 */
@Controller
@AllArgsConstructor
@RequestMapping("/users")
public class SiteUserController {
    private final SiteUserService siteUserService;

    @GetMapping
    public String showAll(Model model) {
        model.addAttribute("siteUsers", siteUserService.findAll());
        return "/users/users";
    }

    @GetMapping("/new")
    public String showNewForm(Model model) {
        model.addAttribute("user", new SiteUser());
        model.addAttribute("rolesList", SiteRole.values());

        return "/users/new";
    }

    @PostMapping
    public String newOrder(@ModelAttribute("user") SiteUserDto userDto) throws NotFoundException {
        siteUserService.save(userDto);
        return "redirect:/users";
    }


}

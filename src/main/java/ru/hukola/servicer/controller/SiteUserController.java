package ru.hukola.servicer.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.hukola.servicer.exception.NotFoundException;
import ru.hukola.servicer.model.SiteRole;
import ru.hukola.servicer.model.SiteUser;
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
    public String newOrder(@ModelAttribute("user") SiteUserDto userDto) {
        siteUserService.save(userDto);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable int id) throws NotFoundException {
        SiteUserDto user = siteUserService.findById(id);
        model.addAttribute("siteUser", user);
        model.addAttribute("rolesList", SiteRole.values());
        return "users/edit";
    }

    @PostMapping("/{id}/edit")
    public String edit(@ModelAttribute("siteUser") SiteUserDto siteUser, @PathVariable int id) throws NotFoundException {
        siteUserService.update(id, siteUser);
        return "redirect:/users";
    }


}

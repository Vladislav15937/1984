package ru.kata.spring.boot_security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.servise.UserServise;


@Controller
@RequestMapping("/admin")
public class AdminControllers {

    private UserServise userServise;

    public AdminControllers(UserServise userServise) {
        this.userServise = userServise;
    }




    @GetMapping("/")
    public String allPeople(Model model) {
        model.addAttribute("people", userServise.getAllPeople());
        return "/allPeople";
    }

    @GetMapping("/new")
    public String newPerson(Model model) {
        model.addAttribute("user", new User());
        return "/new";
    }

    @PostMapping
    public String create(@ModelAttribute("user") User user) {
        userServise.save(user);
        return "redirect:/admin/";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", userServise.personById(id));
        return "/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") Long id) {
        userServise.update(user);
        return "redirect:/admin/";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        userServise.delete(id);
        return "redirect:/admin/";
    }
}

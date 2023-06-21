package ru.kata.spring.boot_security.demo.controller;

import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.boot_security.demo.servise.UserServise;

import java.security.Principal;

@Controller
@RequestMapping("/")
public class PeopleControllers {

    private UserServise userServise;

    public PeopleControllers(UserServise userServise) {
        this.userServise = userServise;
    }

    @GetMapping("/user")
    public String personBy(Principal principal, Model model){
        model.addAttribute("name", userServise.getUserByLogin(principal.getName()));
        return "personBy";
    }


}

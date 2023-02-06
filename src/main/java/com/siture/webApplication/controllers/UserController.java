package com.siture.webApplication.controllers;

import com.siture.webApplication.models.Project;
import com.siture.webApplication.models.User;
import com.siture.webApplication.repositories.UserRepository;
import com.siture.webApplication.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserRepository userRepository;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String createUser(User user, Model model) {
        if (!userService.createUser(user)) {
            model.addAttribute("errorMessage", "Пользователь с email: " + user.getEmail() + " уже существует!");
            return "registration";
        }
        return "redirect:/registration";
    }

    @GetMapping("/my_account")
    public String projectsDetails(Principal principal, Model model) {
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        return "my-account";
    }
}

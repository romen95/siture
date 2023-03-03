package com.siture.webApplication.controllers;

import com.siture.webApplication.files.BitrixService;
import com.siture.webApplication.models.User;
import com.siture.webApplication.repositories.UserRepository;
import com.siture.webApplication.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserRepository userRepository;
    private final BitrixService bitrixService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/registration")
    public String registration(User user, Model model) {
        model.addAttribute("user", user);
        return "registration";
    }

    @PostMapping("/registration")
    public String createUser(User user, Model model) {
        if (!userService.createUser(user)) {
            model.addAttribute("errorMessage", "Пользователь с email: " + user.getPhoneNumber() + " уже существует!");
            return "registration";
        }
        return "redirect:/login";
    }

    @GetMapping("/my_account")
    public String projectsDetails(Principal principal, Model model) {
        User currentUser = userService.getUserByPrincipal(principal);
        model.addAttribute("user", currentUser);
        model.addAttribute("contact", bitrixService.getContactFromPhoneNumber(currentUser.getPhoneNumber()));
        return "my-account";
    }
}

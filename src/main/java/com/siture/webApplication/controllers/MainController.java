package com.siture.webApplication.controllers;

import com.siture.webApplication.files.BitrixService;
import com.siture.webApplication.repositories.ProjectRepository;
import com.siture.webApplication.services.ProjectService;
import com.siture.webApplication.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
@AllArgsConstructor
public class MainController {
    private ProjectRepository projectRepository;
    private final ProjectService projectService;
    private UserService userService;

    @GetMapping("/")
    public String index(Principal principal, Model model) {
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        return "index";
    }

    @GetMapping("/index_5")
    public String index5(Model model) {
        return "index-5";
    }

}

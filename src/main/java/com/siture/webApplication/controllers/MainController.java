package com.siture.webApplication.controllers;

import com.javastream.Client;
import com.siture.webApplication.files.GetInfo;
import com.siture.webApplication.models.User;
import com.siture.webApplication.repositories.ProjectRepository;
import com.siture.webApplication.services.ProjectService;
import com.siture.webApplication.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/about")
    public String about(Model model){
        model.addAttribute("title", GetInfo.getDealsList().get(0).getTitle());
        model.addAttribute("currency", GetInfo.getDealsList().get(0).getCurrencyId());
        model.addAttribute("stage", GetInfo.getDealStageByClientId(5));
        return "about";
    }

}

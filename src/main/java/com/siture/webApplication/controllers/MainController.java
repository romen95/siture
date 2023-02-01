package com.siture.webApplication.controllers;

import com.javastream.Client;
import com.siture.webApplication.files.GetInfo;
import com.siture.webApplication.repositories.ProjectRepository;
import com.siture.webApplication.services.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class MainController {
    private ProjectRepository projectRepository;
    private final ProjectService projectService;

    @GetMapping("/index")
    public String index(Model model) {
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

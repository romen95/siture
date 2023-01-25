package com.siture.webApplication.controllers;

import com.javastream.Client;
import com.siture.webApplication.files.GetInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Главная страница");
        return "home";
    }

    @GetMapping("/about")
    public String about(Model model){
        model.addAttribute("title", "О нас");
        model.addAttribute("stage", GetInfo.getDealStageById(3));
        return "about";
    }

}

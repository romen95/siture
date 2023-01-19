package com.siture.webApplication.controllers;

import com.siture.webApplication.models.Post;
import com.siture.webApplication.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProjectsController {

    @Autowired
    private PostRepository postRepository;
    @GetMapping("/projects")
    public String blogMain(Model model) {
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "projects";
    }
}

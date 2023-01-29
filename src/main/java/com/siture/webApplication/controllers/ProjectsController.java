package com.siture.webApplication.controllers;

import com.siture.webApplication.models.Post;
import com.siture.webApplication.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class ProjectsController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/projects")
    public String projectsMain(Model model) {
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "projects";
    }

    @GetMapping("/projects/add")
    public String projectsAdd(Model model) {
        return "projects-add";
    }

    @PostMapping("/projects/add")
    public String projectsFormAdd(@RequestParam String title, @RequestParam String anons, @RequestParam String full_text, Model model) {
        Post post = new Post(title, anons, full_text);
        postRepository.save(post);
        return "redirect:/projects";
    }

    @GetMapping("/projects/{id}")
    public String projectsDetails(@PathVariable(value = "id") long id, Model model) {
        if (!postRepository.existsById(id)) {
            return "redirect:/projects";
        }

        Optional<Post> post = postRepository.findById(id);
        ArrayList<Post> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        return "projects-details";
    }

    @GetMapping("/projects/{id}/edit")
    public String projectsEdit(@PathVariable(value = "id") long id, Model model) {
        if (!postRepository.existsById(id)) {
            return "redirect:/projects";
        }

        Optional<Post> post = postRepository.findById(id);
        ArrayList<Post> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        return "projects-edit";
    }

    @PostMapping("/projects/{id}/edit")
    public String projectsUpdate(@PathVariable(value = "id") long id, @RequestParam String title, @RequestParam String anons, @RequestParam String full_text, Model model) {
        Post post = postRepository.findById(id).orElseThrow();
        post.setTitle(title);
        post.setAnons(anons);
        post.setFull_text(full_text);
        postRepository.save(post);
        return "redirect:/projects";
    }

    @PostMapping("/projects/{id}/remove")
    public String projectsDelete(@PathVariable(value = "id") long id, Model model) {
        if (!postRepository.existsById(id)) {
            return "redirect:/projects";
        }

        Post post = postRepository.findById(id).orElseThrow();
        postRepository.delete(post);
        return "redirect:/projects";
    }

}

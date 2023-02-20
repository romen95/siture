package com.siture.webApplication.controllers;

import com.siture.webApplication.models.Project;
import com.siture.webApplication.repositories.ProjectRepository;
import com.siture.webApplication.services.ProjectService;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class ProjectsController {

    @Autowired
    private ProjectRepository projectRepository;
    private final ProjectService projectService;

    @GetMapping("/projects")
    public String projects(Model model) {
        return "projects";
    }

//    @GetMapping("/projects")
//    public String projectsMain(@RequestParam(name = "title", required = false) String title, Model model) {
//        model.addAttribute("projects", projectService.listProjects(title));
//        return "projects";
//    }
//
//    @GetMapping("/projects/add")
//    public String projectsAdd(Model model) {
//        return "projects-add";
//    }
//
//    @PostMapping("/projects/add")
//    public String projectsFormAdd(@RequestParam String title, @RequestParam String description, @RequestParam Integer price, Model model) {
//        Project project = new Project(title, description, price);
//        projectRepository.save(project);
//        return "redirect:/projects";
//    }
//
//    @GetMapping("/projects/{id}")
//    public String projectsDetails(@PathVariable(value = "id") long id, Model model) {
//        if (!projectRepository.existsById(id)) {
//            return "redirect:/projects";
//        }
//
//        Optional<Project> project = projectRepository.findById(id);
//        ArrayList<Project> res = new ArrayList<>();
//        project.ifPresent(res::add);
//        model.addAttribute("project", res);
//        return "projects-details";
//    }
//
//    @GetMapping("/projects/{id}/edit")
//    public String projectsEdit(@PathVariable(value = "id") long id, Model model) {
//        if (!projectRepository.existsById(id)) {
//            return "redirect:/projects";
//        }
//
//        Optional<Project> project = projectRepository.findById(id);
//        ArrayList<Project> res = new ArrayList<>();
//        project.ifPresent(res::add);
//        model.addAttribute("project", res);
//        return "projects-edit";
//    }
//
//    @PostMapping("/projects/{id}/edit")
//    public String projectsUpdate(@PathVariable(value = "id") long id, @RequestParam String title, @RequestParam Integer price, @RequestParam String description, Model model) {
//        Project project = projectRepository.findById(id).orElseThrow();
//        project.setTitle(title);
//        project.setDescription(description);
//        project.setPrice(price);
//        projectRepository.save(project);
//        return "redirect:/projects";
//    }
//
//    @PostMapping("/projects/{id}/remove")
//    public String projectsDelete(@PathVariable(value = "id") long id, Model model) {
//        if (!projectRepository.existsById(id)) {
//            return "redirect:/projects";
//        }
//
//        Project project = projectRepository.findById(id).orElseThrow();
//        projectRepository.delete(project);
//        return "redirect:/projects";
//    }

}

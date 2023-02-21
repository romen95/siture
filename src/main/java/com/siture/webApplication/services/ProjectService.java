package com.siture.webApplication.services;

import com.siture.webApplication.models.Project;
import com.siture.webApplication.repositories.ProjectRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;

    public List<Project> listProjects(String title) {
        if (title != null) return projectRepository.findByTitle(title);
        return projectRepository.findAll();
    }

    public void saveProject(Project project) {
        log.info("Saving new {}", project);
        projectRepository.save(project);
    }

    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }

    public Project getProjectsById(Long id) {
        return projectRepository.findById(id).orElse(null);
    }
}

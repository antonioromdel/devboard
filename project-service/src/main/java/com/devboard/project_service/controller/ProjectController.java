package com.devboard.project_service.controller;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.devboard.project_service.model.Project;
import com.devboard.project_service.model.ProjectStatus;
import com.devboard.project_service.service.ProjectService;

@RestController 
@RequestMapping ("/api/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    @PostMapping
    public Project createProject(@RequestBody Project project) {
        return projectService.createProject(project);
    }

    @GetMapping("/{id}")
    public Project getProjectById(@PathVariable Long id) {
        return projectService.getProjectById(id);
    }

    @PatchMapping("/{id}/status")
    public Project updateProjectStatus(@PathVariable Long id, @RequestParam ProjectStatus status) {
        return projectService.updateProjectStatus(id, status);
    }
    
    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable Long id) {
       projectService.deleteProject(id);
    }
}
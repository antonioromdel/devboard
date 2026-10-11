package com.devboard.project_service.service;

import com.devboard.project_service.model.Project;
import com.devboard.project_service.repository.ProjectRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.devboard.project_service.model.ProjectStatus;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    public Project getProjectById(Long id) {
        return projectRepository.findById(id).orElse(null);
    }

    public Project updateProjectStatus(Long id, ProjectStatus status) {
        Optional<Project> optionalProject = projectRepository.findById(id);

        if (optionalProject.isEmpty()) {
            throw new RuntimeException("Project not found with id: " + id);
        }

        Project project = optionalProject.get();
        project.setStatus(status);

        return projectRepository.save(project);
    }

    public void deleteProject(Long id) {
        if(!projectRepository.existsById(id)) {
            throw new RuntimeException("Project not found with id: " + id);
        }

        projectRepository.deleteById(id);
    }
}
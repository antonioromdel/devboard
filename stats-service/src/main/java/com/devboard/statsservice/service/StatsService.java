package com.devboard.statsservice.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.devboard.statsservice.client.ProjectClient;
import com.devboard.statsservice.model.ProjectStats;

@Service 
public class StatsService {
    private final ProjectClient projectClient;

    public StatsService(ProjectClient projectClient) {
        this.projectClient = projectClient;
    }

    public ProjectStats getStats() {
        List<Map<String, Object>> projects = projectClient.getAllProjects();

        long total = projects.size();
        long pending = projects.stream()
                .filter(project -> "PENDING".equals(project.get("status")))
                .count();
        long inProgress = projects.stream()
                .filter(project -> "IN_PROGRESS".equals(project.get("status")))
                .count();
        long completed = projects.stream()
                .filter(project -> "COMPLETED".equals(project.get("status")))
                .count();

        return new ProjectStats(total, pending, inProgress, completed); 
    }
}

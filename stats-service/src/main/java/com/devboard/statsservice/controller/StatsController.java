package com.devboard.statsservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devboard.statsservice.model.ProjectStats;
import com.devboard.statsservice.service.StatsService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/stats")
public class StatsController {
    
    private final StatsService statsService;

    public StatsController(StatsService statsService) {
        this.statsService = statsService;
    }

    @GetMapping
    public ProjectStats getStats() {
        return statsService.getStats();
    }
    
}

package com.devboard.statsservice.client;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component 
public class ProjectClient {
    private final RestClient restClient;

    public ProjectClient(RestClient.Builder builder, 
            @Value("$project.service.url") String projectServiceUrl) {
        this.restClient = builder.baseUrl(projectServiceUrl).build();
    }
    
    public List<Map<String, Object>> getAllProjects() {
        return restClient.get()
                .uri("/api/projects")
                .retrieve()
                .body(new ParameterizedTypeReference<>(){});
    }
    
}

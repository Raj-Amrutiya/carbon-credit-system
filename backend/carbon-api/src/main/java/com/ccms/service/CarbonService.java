package com.ccms.service;

import com.ccms.model.Project;
import com.ccms.repository.ProjectRepo;
import org.springframework.stereotype.Service;

import java.util.DoubleSummaryStatistics;

@Service
public class CarbonService {
    private final ProjectRepo projectRepo;

    public CarbonService(ProjectRepo projectRepo) {
        this.projectRepo = projectRepo;
    }

    public DoubleSummaryStatistics getStats() {
        return projectRepo.findAll()
                .stream()
                .mapToDouble(Project::getCo2)
                .summaryStatistics();
    }
}

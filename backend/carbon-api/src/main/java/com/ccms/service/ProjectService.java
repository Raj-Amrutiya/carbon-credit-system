package com.ccms.service;

import com.ccms.model.Project;
import com.ccms.repository.ProjectRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    private final ProjectRepo projectRepo;

    public ProjectService(ProjectRepo projectRepo) {
        this.projectRepo = projectRepo;
    }

    public List<Project> findAll() {
        return projectRepo.findAll();
    }

    public List<Project> findByUserId(Long userId) {
        return projectRepo.findByUserId(userId);
    }

    public Optional<Project> findById(Long id) {
        return projectRepo.findById(id);
    }

    public Project save(Project project) {
        return projectRepo.save(project);
    }

    public void delete(Long id) {
        projectRepo.deleteById(id);
    }
}

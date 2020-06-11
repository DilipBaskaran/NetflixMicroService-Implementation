package com.techmahindra.associatesprojectentry.service;

import java.util.List;

import com.techmahindra.associatesprojectentry.models.Project;

public interface ProjectService {

	public List<Project> findAll();
	public Project findById(Long id);
	public Project saveProject(Project project);
	public Project updateProject(Project project);
	public void deleteProject(Project project);
}

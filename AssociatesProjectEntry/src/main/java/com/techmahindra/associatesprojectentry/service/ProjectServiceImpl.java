package com.techmahindra.associatesprojectentry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techmahindra.associatesprojectentry.dao.ProjectRepository;
import com.techmahindra.associatesprojectentry.models.Project;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	ProjectRepository projectRepository;
	
	@Override
	public List<Project> findAll() {
		// TODO Auto-generated method stub
		return projectRepository.findAll();
	}

	@Override
	public Project findById(Long id) {
		// TODO Auto-generated method stub
		return projectRepository.getOne(id);
	}
	
	@Override
	public Project saveProject(Project project) {
		// TODO Auto-generated method stub
		return projectRepository.saveAndFlush(project);
	}

	@Override
	public Project updateProject(Project project) {
		// TODO Auto-generated method stub
		return projectRepository.saveAndFlush(project);
	}

	@Override
	public void deleteProject(Project project) {
		// TODO Auto-generated method stub
		projectRepository.delete(project);
	}

}

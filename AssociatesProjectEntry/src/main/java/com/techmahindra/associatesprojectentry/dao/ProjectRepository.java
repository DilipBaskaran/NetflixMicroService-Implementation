package com.techmahindra.associatesprojectentry.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techmahindra.associatesprojectentry.models.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

}

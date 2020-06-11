package com.techmahindra.associatesprojectentry.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techmahindra.associatesprojectentry.models.Associate;

@Repository
public interface AssociateRepository extends JpaRepository<Associate, Long> {

	Set<Associate> findByManager(Associate manager);
	
	Associate findBygID(String gID);
}

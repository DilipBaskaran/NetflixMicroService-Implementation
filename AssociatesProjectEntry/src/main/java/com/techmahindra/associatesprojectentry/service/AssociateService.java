package com.techmahindra.associatesprojectentry.service;

import java.util.List;

import com.techmahindra.associatesprojectentry.models.Associate;

public interface AssociateService {
	
	public List<Associate> findAll();
	public Associate findById(Long id);
	public Associate findByGID(String gID);
	public Associate saveAssociate(Associate associate);
	public Associate updateAssociate(Associate associate);
	public void deleteAssociate(Associate associate);

}

package com.techmahindra.associatesprojectentry.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techmahindra.associatesprojectentry.dao.AssociateRepository;
import com.techmahindra.associatesprojectentry.models.Associate;

@Service
@Transactional
public class AssociateServiceImpl implements AssociateService{

	@Autowired
	AssociateRepository associateRepository;
	
	@Override
	public List<Associate> findAll() {
		return associateRepository.findAll();
	}

	@Override
	public Associate findById(Long id) {
		Optional<Associate> associate = associateRepository.findById(id);
		if(associate.isPresent())
			return associate.get();
		return null;
	}
	
	@Override
	public Associate saveAssociate(Associate associate) {
		return associateRepository.save(associate);
	}

	@Override
	public Associate updateAssociate(Associate associate) {
		// TODO Auto-generated method stub
		return associateRepository.saveAndFlush(associate);
	}

	@Override
	public void deleteAssociate(Associate associate) {
		// TODO Auto-generated method stub
		associateRepository.delete(associate);;
	}

	@Override
	public Associate findByGID(String gID) {
		// TODO Auto-generated method stub
		return associateRepository.findBygID(gID);
	}

}

package com.techmahindra.associateservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techmahindra.associateservice.models.AssociateBean;

@Service
public class AssociateService {
	
	@Autowired
	AssociateServiceProxy proxy;
	
	public AssociateBean getAssociateDetails(String id ) {
		return proxy.retrieveAssociate(id);
		
	}
	
	public List<AssociateBean> getAssociates() {
		return proxy.getAssociateList();
	}
	
	public AssociateBean createAssociate(AssociateBean associate) {
		System.out.println("Associate::::::"+associate);
		return proxy.createAssociate(associate);
		
	}
	
	public AssociateBean updateAssociate(AssociateBean associate) {
		return proxy.updateAssociate(associate,associate.getId());
		
	}
	
	public AssociateBean deleteAssociate(long id ) {
		return proxy.deleteAssociate(id);
		
	}


}

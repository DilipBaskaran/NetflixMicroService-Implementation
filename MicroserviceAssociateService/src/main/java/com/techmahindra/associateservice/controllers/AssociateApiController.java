package com.techmahindra.associateservice.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.techmahindra.associateservice.models.AssociateBean;
import com.techmahindra.associateservice.service.AssociateServiceProxy;

@RestController
public class AssociateApiController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	AssociateServiceProxy proxy;

	@GetMapping("/associate/{id}")
	  public ResponseEntity<?> convertCurrencyFeign(@PathVariable Long id) {

	    AssociateBean response = proxy.retrieveAssociate(""+id);
	    
	    System.out.println(response);

	    logger.info("{}", response);

	    return ResponseEntity.ok(response);
	  }
	
	@GetMapping("/associate")
	  public ResponseEntity<?> getAllAssociates() {

	    List<AssociateBean> response = proxy.getAssociateList();
	    
	    System.out.println(response);

	    logger.info("{}", response);

	    return ResponseEntity.ok(response);
	  }

}

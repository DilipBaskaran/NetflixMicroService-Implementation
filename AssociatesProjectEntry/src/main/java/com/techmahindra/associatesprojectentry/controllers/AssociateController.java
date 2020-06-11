package com.techmahindra.associatesprojectentry.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.techmahindra.associatesprojectentry.models.Associate;
import com.techmahindra.associatesprojectentry.service.AssociateService;

//@Controller
@RequestMapping(value="/associates")
public class AssociateController {

	@Autowired
	AssociateService associateService;
	
	@GetMapping("/")
	public String getAssociates(Model model){
		List<Associate> associates = associateService.findAll();
		model.addAttribute("associates", associates);
		return "associates";
		
	}
	
	@PostMapping("/")
	public ResponseEntity<Associate> createAssociate(@RequestBody Associate associate){
		Associate associateCreated = associateService.saveAssociate(associate); 
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(associateCreated.getId())
                .toUri();

		return ResponseEntity.created(location).build();
		
	}
	@PatchMapping("/{id}")
	public ResponseEntity<Associate> createAssociate(@PathVariable Long id,@RequestBody Associate associate){
		associate.setId(id);
		Associate associateUpdated = associateService.updateAssociate(associate); 
		
		
		return ResponseEntity.ok(associateUpdated);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> createAssociate(@PathVariable Long id){
		Associate associate = associateService.findById(id);
		
		if(associate == null)
			throw new InvalidConfigurationPropertyValueException("id", "id", "Not found");
		
		return ResponseEntity.ok(associate);
	}
	
}

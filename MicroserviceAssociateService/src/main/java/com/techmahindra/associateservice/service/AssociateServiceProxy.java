package com.techmahindra.associateservice.service;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.techmahindra.associateservice.models.AssociateBean;

@FeignClient(name="associates-service")
@RibbonClient(name="associates-service")
public interface AssociateServiceProxy {
	@GetMapping("/api/associates/{id}")
	public AssociateBean retrieveAssociate(@PathVariable("id") String id);
	
	@GetMapping("/api/associates/")
	public List<AssociateBean> getAssociateList();
	
	@PostMapping("/api/associates/")
	public AssociateBean createAssociate(@RequestBody AssociateBean associate);
	
	@PutMapping("/api/associates/{id}")
	public AssociateBean updateAssociate(@RequestBody AssociateBean associate,@PathVariable("id") Long id);
	
	@DeleteMapping("/api/associates/{id}")
	public AssociateBean deleteAssociate(@PathVariable("id") Long id);
}
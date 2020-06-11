package com.techmahindra.associateservice.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.techmahindra.associateservice.models.AssociateBean;
import com.techmahindra.associateservice.service.AssociateService;


@Controller
@RequestMapping(value="/associates")
public class AssociateController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	AssociateService associateService;

	
	@GetMapping(value= {"/"})
	public String getAssociates(Model model){
		List<AssociateBean> associates = associateService.getAssociates();
		model.addAttribute("associates", associates);
		
		logger.info("{}", associates);
		return "Associates";

	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getAssociate(@PathVariable Long id){
		AssociateBean associate = associateService.getAssociateDetails(""+id);
		if(associate == null)
			throw new InvalidConfigurationPropertyValueException("id", "id", "Not found");

		logger.info("{}", associate);
		return ResponseEntity.ok(associate);
	}

	@GetMapping("/addAssociate")
	public String newAssociate(Model model){
		logger.info("{}", "adding associate");
		model.addAttribute("associate",new AssociateBean());
		return "AddAssociates";
	}

	@GetMapping("/update")
	public String updateAssociate(@RequestParam Long id, Model model){

		AssociateBean associate = associateService.getAssociateDetails(""+id);
		model.addAttribute("associate",associate);
		return "AddAssociates";
	}

	@PostMapping("/saveAssociate")
	public String createAssociate(@ModelAttribute("associate") AssociateBean associate, Model model){

		System.out.println(associate);


		if(associate.getId() == null) {
			AssociateBean associateAvailable = associateService.getAssociateDetails(associate.getgID());
			System.out.println("associateAvailable");
			System.out.println(associateAvailable!=null);
			if(associateAvailable==null)
				associateService.createAssociate(associate);
			else {
				associate.setgID("");
				model.addAttribute("associate",associate);
				return "AddAssociates";
			}

		}else
			associateService.updateAssociate(associate);


		List<AssociateBean> associates = associateService.getAssociates();
		model.addAttribute("associates", associates);
		return "redirect:/";

	}

	@GetMapping("/delete")
	public String deleteAssociate(@RequestParam Long id,Model model){

		associateService.deleteAssociate(id);


		List<AssociateBean> associates = associateService.getAssociates();
		model.addAttribute("associates", associates);
		return "redirect:/";

	}

}

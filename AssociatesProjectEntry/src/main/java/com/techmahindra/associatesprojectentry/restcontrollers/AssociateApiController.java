package com.techmahindra.associatesprojectentry.restcontrollers;

import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.techmahindra.associatesprojectentry.models.Associate;
import com.techmahindra.associatesprojectentry.service.AssociateService;

@RestController
@RequestMapping(value="/api/associates")
public class AssociateApiController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	AssociateService associateService;
	
	@GetMapping(value= {"","/"})
	public ResponseEntity<List<Associate>> getAssociates(){
		List<Associate> associates = associateService.findAll(); 
		logger.info("Associates list:"+associates);
		return ResponseEntity.ok(associates);
		
	}
	
	@PostMapping("/")
	public Associate createAssociate(@RequestBody Associate associate){
		
		Associate associateCreated = associateService.saveAssociate(associate); 
		/*URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(associateCreated.getId())
                .toUri();

		return ResponseEntity.created(location).build();*/
		
		logger.info("Associate:"+associateCreated);
		return associateCreated;
		
	}
	@PutMapping("/{id}")
	public ResponseEntity<Associate> createAssociate(@PathVariable Long id,@RequestBody Associate associate){
		System.out.println("UpdateCheck");
		//System.out.println("---"+associate);
		System.out.println(id);
		associate.setId(id);
		Associate associateUpdated = associateService.updateAssociate(associate); 
		
		
		return ResponseEntity.ok(associateUpdated);
		
	}
	
	@GetMapping("/{gID}")
	public ResponseEntity<?> getAssociate(@PathVariable String gID){
		
		System.out.println(gID);
		Associate associate = null;
		try {
			Long id = Long.parseLong(gID);
			associate = associateService.findById(id);
			System.out.println(id);
		}catch(NumberFormatException e) {
			System.out.println("testing-------------"+gID);
			associate = associateService.findByGID(gID);
		}
		System.out.println("GID---"+ (associate==null));
		//associate.setPort(environment.getProperty("local.server.port"));
		if(associate == null)
			ResponseEntity.ok(new Associate());
		
		logger.info("Associate:"+associate);
		return ResponseEntity.ok(associate);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteAssociate(@PathVariable Long id){
		
			Associate associate = associateService.findById(id);
			if(associate != null)
				associateService.deleteAssociate(associate);
			else
				associate = new Associate();
			
		return ResponseEntity.ok(associate);
	}
	
}

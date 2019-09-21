package ca.timisencotech.projectmanagementapis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ca.timisencotech.projectmanagementapis.Application;
import ca.timisencotech.projectmanagementapis.domain.SupervisorAppraisals;
import ca.timisencotech.projectmanagementapis.service.SupervisorAppraisalsService;
import ca.timisencotech.projectmanagementapis.validation.Container;



@RestController
@RequestMapping("/projectmanagement")
public class SupervisorAppraisalController 
{
	
	@Autowired
	SupervisorAppraisalsService supervisorAppraisalDetailsService;
	
	
	@PostMapping("/supervisorAppraisal")
	@ResponseBody
	public <T> Container<T> addNewSupervisorAppraisal(@Validated @RequestBody SupervisorAppraisals supervisorAppraisals,BindingResult result) { 
		Application.getLogger().info("User called supervisor appraisals details api. parameters passed is: "+supervisorAppraisals);
	    return  supervisorAppraisalDetailsService.addSupervisorAppraisals(supervisorAppraisals, result);
	    		
	
	}
}

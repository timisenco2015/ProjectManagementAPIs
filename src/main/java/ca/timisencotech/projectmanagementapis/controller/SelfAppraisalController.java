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
import ca.timisencotech.projectmanagementapis.domain.SelfAppraisals;
import ca.timisencotech.projectmanagementapis.service.SelfAppraisalsService;
import ca.timisencotech.projectmanagementapis.validation.Container;



@RestController
@RequestMapping("/projectmanagement")
public class SelfAppraisalController 
{
	
	@Autowired
	SelfAppraisalsService selfAppraisalsService;
	
	
	@PostMapping("/inidividualAppraisal")
	@ResponseBody
	public <T> Container<T> addNewSelfAppraisal(@Validated @RequestBody SelfAppraisals selfAppraisals,BindingResult result) { 
		Application.getLogger().info("User called self appraisals details api. parameters passed is: "+selfAppraisals);
	    return  selfAppraisalsService.addSelfAppraisals(selfAppraisals, result);
	    		
	
	}
}

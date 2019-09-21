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
import ca.timisencotech.projectmanagementapis.domain.ProjectStatus;
import ca.timisencotech.projectmanagementapis.service.ProjectStatusService;
import ca.timisencotech.projectmanagementapis.validation.Container;



@RestController
@RequestMapping("/projectmanagement")
public class ProjectStatusController 
{
	@Autowired
	ProjectStatusService projectStatusService;
	
	
	@PostMapping("/updateProjectStatus")
	@ResponseBody
	public <T> Container<T> addProjectStatusDetails(@Validated @RequestBody ProjectStatus projectStatus,BindingResult result) { 
		Application.getLogger().info("User called update project tatus details (/updateProjectStatus) api. parameters passed is: "+projectStatus);
	    return  projectStatusService.addProjectStatusDetails(projectStatus, result);
	    		
	    		
	}
	
	
	
	
	
	
	
	
	
}

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
import ca.timisencotech.projectmanagementapis.domain.ProjectSupervisors;
import ca.timisencotech.projectmanagementapis.service.ProjectSupervisorsService;
import ca.timisencotech.projectmanagementapis.validation.Container;



@RestController
@RequestMapping("/projectmanagement")
public class ProjectSupervisorsController 
{
	@Autowired
	ProjectSupervisorsService projectSupervisorsService;
	
	
	@PostMapping("/newProjectSupervisor")
	@ResponseBody
	public <T> Container<T> addNewProjectSupervisorDetails(@Validated @RequestBody ProjectSupervisors projectSupervisors,BindingResult result) { 
		Application.getLogger().info("User called add new project supervisor details (/newProjectSupervisor) api. parameters passed is: "+projectSupervisors);
	    return  projectSupervisorsService.addProjectSupervisorsDetails(projectSupervisors, result);
	    		
	}
	
	
	
	
	
	
	
	
	
}

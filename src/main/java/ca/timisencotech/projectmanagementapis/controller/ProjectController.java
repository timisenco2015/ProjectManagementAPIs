package ca.timisencotech.projectmanagementapis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ca.timisencotech.projectmanagementapis.Application;
import ca.timisencotech.projectmanagementapis.domain.Project;
import ca.timisencotech.projectmanagementapis.service.ProjectService;
import ca.timisencotech.projectmanagementapis.validation.Container;



@RestController
@RequestMapping("/projectmanagement")
public class ProjectController 
{
	@Autowired
	ProjectService projectService;
	
	
	@PostMapping("/addNewProject")
	@ResponseBody
	public <T> Container<T> addNewUserLoginDetails(@Validated @RequestBody Project project,BindingResult result) { 
		Application.getLogger().info("User called add project details (/addNewProjectDetails) api. parameters passed is: "+project);
	    return projectService.addProjectpDetails(project, result);
	    	
	    		
	}
	
	@PutMapping("/updateProject")
	@ResponseBody
	public <T> Container<T> updateProjectDetails(@Validated @RequestBody Project project,BindingResult result) { 
		Application.getLogger().info("User called add new project supervisor details (/newUserSignUpDetails) api. parameters passed is: "+project);
	    return  projectService.updateProjectDetails(project, result);
	    		
	}
			
	}
	


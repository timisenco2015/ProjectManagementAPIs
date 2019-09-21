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
import ca.timisencotech.projectmanagementapis.domain.ProjectGroup;
import ca.timisencotech.projectmanagementapis.service.ProjectGroupService;
import ca.timisencotech.projectmanagementapis.validation.Container;



@RestController
@RequestMapping("/projectmanagement")
public class ProjectGroupController 
{
	@Autowired
	ProjectGroupService projectGroupService;
	
	
	@PostMapping("/createProjectGroup")
	@ResponseBody
	public <T> Container<T> addProjectGroupDetails(@Validated @RequestBody ProjectGroup projectGroup,BindingResult result) { 
		Application.getLogger().info("User called add project group details (/createProjectGroup) api. parameters passed is: "+projectGroup);
	    return  projectGroupService.addProjectGroupDetails(projectGroup, result);
	    		
	    		
	}
	
	
	
	
	
	
	
	
	
}

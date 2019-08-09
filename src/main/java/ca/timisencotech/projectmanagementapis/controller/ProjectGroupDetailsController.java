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
import ca.timisencotech.projectmanagementapis.domain.ProjectGroupDetail;
import ca.timisencotech.projectmanagementapis.service.ProjectGroupDetailsService;
import ca.timisencotech.projectmanagementapis.validation.Container;



@RestController
@RequestMapping("/projectmanagement")
public class ProjectGroupDetailsController 
{
	@Autowired
	ProjectGroupDetailsService projectGroupDetailsService;
	
	
	@PostMapping("/createProjectGroup")
	@ResponseBody
	public <T> Container<T> addProjectGroupDetails(@Validated @RequestBody ProjectGroupDetail projectGroupDetail,BindingResult result) { 
		Application.getLogger().info("User called add project group details (/createProjectGroup) api. parameters passed is: "+projectGroupDetail);
	    return  projectGroupDetailsService.addProjectGroupDetails(projectGroupDetail, result);
	    		
	    		
	}
	
	
	
	
	
	
	
	
	
}

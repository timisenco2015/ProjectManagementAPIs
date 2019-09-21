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
import ca.timisencotech.projectmanagementapis.domain.ProjectGroupMembers;
import ca.timisencotech.projectmanagementapis.service.ProjectGroupMemberService;
import ca.timisencotech.projectmanagementapis.validation.Container;



@RestController
@RequestMapping("/projectmanagement")
public class ProjectGroupMemberController 
{
	@Autowired
	ProjectGroupMemberService projectGroupMemberService;
	
	
	@PostMapping("/addUserToProjectGroup")
	@ResponseBody
	public <T> Container<T> addMemberToProjectGroup(@Validated @RequestBody ProjectGroupMembers projectGroupMembers,BindingResult result) { 
		Application.getLogger().info("User called add member to project group (/addUserToProjectGroup) api. parameters passed is: "+projectGroupMembers);
	    return  projectGroupMemberService.addMemberToProjectGroup(projectGroupMembers, result);
	    		
	    		
	}
	
	
	@PostMapping("/switchmemberprojectgroup")
	@ResponseBody
	public <T> Container<T> changeProjectMemberGroup(@Validated @RequestBody ProjectGroupMembers projectGroupMembers,BindingResult result) { 
		Application.getLogger().info("User called change member  project group (/switchmemberprojectgroup) api. parameters passed is: "+projectGroupMembers);
	    return  projectGroupMemberService.changeProjectMemberGroup(projectGroupMembers, result);
	    		
	    		
	}
	
	
	
	@PostMapping("/deletememberfromgroup")
	@ResponseBody
	public <T> Container<T> removeMemberFromProjectGroup(@Validated @RequestBody ProjectGroupMembers projectGroupMembers,BindingResult result) { 
		Application.getLogger().info("User called remove member from project group (/deletememberfromgroup) api. parameters passed is: "+projectGroupMembers);
	    return  projectGroupMemberService.removeMemberFromProjectGroup(projectGroupMembers, result);
	    		
	    		
	}
	
	
	
	
	
	
	
}

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
import ca.timisencotech.projectmanagementapis.domain.Task;
import ca.timisencotech.projectmanagementapis.domain.TaskAssignedMembers;
import ca.timisencotech.projectmanagementapis.service.TaskAssignedMembersService;
import ca.timisencotech.projectmanagementapis.service.TaskService;
import ca.timisencotech.projectmanagementapis.validation.Container;



@RestController
@RequestMapping("/projectmanagement")
public class TaskAssignedMemberController 
{
	@Autowired
	TaskAssignedMembersService taskAssignedMembersService;
	
	
	@PostMapping("/assignTaskToMember")
	@ResponseBody
	public <T> Container<T> assignMemberTask(@Validated @RequestBody TaskAssignedMembers taskAssignedMembers ,BindingResult result) { 
		Application.getLogger().info("User called assign task to members (//assignTaskToMember) api. parameters passed is: "+taskAssignedMembers);
	    return taskAssignedMembersService.assignedTaskToMembers(taskAssignedMembers, result);
	    	
	    	
	    		
	}
	

			
	}
	


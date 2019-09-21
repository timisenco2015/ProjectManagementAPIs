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
import ca.timisencotech.projectmanagementapis.domain.TaskStatus;
import ca.timisencotech.projectmanagementapis.service.TaskStatusService;
import ca.timisencotech.projectmanagementapis.validation.Container;



@RestController
@RequestMapping("/projectmanagement")
public class TaskStatusController 
{
	@Autowired
	TaskStatusService taskStatusService;
	
	
	@PostMapping("/updateTaskStatus")
	@ResponseBody
	public <T> Container<T> addTaskStatus(@Validated @RequestBody TaskStatus taskStatus,BindingResult result) { 
		Application.getLogger().info("User called update task status details (/updateTaskStatus) api. parameters passed is: "+taskStatus);
	    return taskStatusService.addTaskStatusDetails(taskStatus, result);
	    		
	    		
	}
	
	
	
	
	
	
	
	
	
}

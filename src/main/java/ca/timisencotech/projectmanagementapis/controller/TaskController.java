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
import ca.timisencotech.projectmanagementapis.service.TaskService;
import ca.timisencotech.projectmanagementapis.validation.Container;



@RestController
@RequestMapping("/task")
public class TaskController 
{
	@Autowired
	TaskService taskService;
	
	
	@PostMapping("/createnewtask")
	@ResponseBody
	public <T> Container<T> addNewTask(@Validated @RequestBody Task task ,BindingResult result) { 
		Application.getLogger().info("User called add task details (/createnewtask) api. parameters passed is: "+task);
	    return taskService.addTask(task, result);
	    	
	    	
	    		
	}
	
	@PutMapping("/updatetaskdetails")
	@ResponseBody
	public <T> Container<T> updateProjectDetails(@Validated @RequestBody Task task ,BindingResult result) { 
		Application.getLogger().info("User called update task (/updatetaskdetails) api. parameters passed is: "+task);
	    return  taskService.updateTask(task, result);
	    		
	    		
	}
			
	}
	


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
import ca.timisencotech.projectmanagementapis.domain.SupervisorTasks;
import ca.timisencotech.projectmanagementapis.service.SupervisorsTasksService;
import ca.timisencotech.projectmanagementapis.validation.Container;



@RestController
@RequestMapping("/supervisortasks")
public class SupervisorTasksController 
{
	
	@Autowired
	SupervisorsTasksService supervisorsTasksService;
	
	
	@PostMapping("/addtasktosupervisottasklist")
	@ResponseBody
	public <T> Container<T> addNewSupervisorTask(@Validated @RequestBody SupervisorTasks supervisorTasks,BindingResult result) { 
		Application.getLogger().info("User called supervisor tasks details (/addtasktosupervisottasklist) api. parameters passed is: "+supervisorTasks);
	    return  supervisorsTasksService.addSupervisorTasks(supervisorTasks, result);
	    		
	    		
	
	}
}

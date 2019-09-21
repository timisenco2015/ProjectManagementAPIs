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
import ca.timisencotech.projectmanagementapis.domain.SupervisorsMembers;
import ca.timisencotech.projectmanagementapis.service.SupervisorsMembersService;
import ca.timisencotech.projectmanagementapis.validation.Container;



@RestController
@RequestMapping("/projectmanagement")
public class SupervisorsMembersController 
{
	
	@Autowired
	SupervisorsMembersService supervisorsMembersService;
	
	
	@PostMapping("/assignMemberToSupervisor")
	@ResponseBody
	public <T> Container<T> addMemberToSupervisor(@Validated @RequestBody SupervisorsMembers supervisorsMembers,BindingResult result) { 
		Application.getLogger().info("User called supervisor members details api (/assignMemberToSupervisor). parameters passed is: "+supervisorsMembers);
	    return  supervisorsMembersService.addSupervisorMember(supervisorsMembers, result);
	    		
	
	}
}

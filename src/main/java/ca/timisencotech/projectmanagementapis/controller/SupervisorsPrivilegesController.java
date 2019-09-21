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
import ca.timisencotech.projectmanagementapis.domain.SupervisorsPrivileges;
import ca.timisencotech.projectmanagementapis.service.SupervisorsPrivilegesService;
import ca.timisencotech.projectmanagementapis.validation.Container;



@RestController
@RequestMapping("/projectmanagement")
public class SupervisorsPrivilegesController 
{
	
	@Autowired
	SupervisorsPrivilegesService SupervisorsPrivilegesService;
	
	
	@PostMapping("/assignPrivilegesToSupervisor")
	@ResponseBody
	public <T> Container<T> addPrivilegesToSupervisor(@Validated @RequestBody SupervisorsPrivileges supervisorsPrivileges,BindingResult result) { 
		Application.getLogger().info("User called supervisor privileges details api (/assignPrivilegesToSupervisor). parameters passed is: "+supervisorsPrivileges);
	    return  SupervisorsPrivilegesService.addSupervisorPrivileges(supervisorsPrivileges, result);
	    		
	
	}
}

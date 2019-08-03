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
import ca.timisencotech.projectmanagementapis.domain.UserDetail;
import ca.timisencotech.projectmanagementapis.service.UserDetailsService;
import ca.timisencotech.projectmanagementapis.validation.Container;



@RestController
@RequestMapping("/projectmanagement")
public class UserDetailsController 
{
	
	@Autowired
	UserDetailsService userDetailsService;
	
	
	@PostMapping("/addNewUser")
	@ResponseBody
	public <T> Container<T> addNewUser(@Validated @RequestBody UserDetail userDetail,BindingResult result) { 
		Application.getLogger().info("User called add user details api. parameters passed is: "+userDetail);
	    return  userDetailsService.addNewUser(userDetail, result);
	    		
	
	}
}

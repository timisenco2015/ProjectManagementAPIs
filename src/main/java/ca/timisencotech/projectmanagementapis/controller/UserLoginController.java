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
import ca.timisencotech.projectmanagementapis.domain.UserLogin;
import ca.timisencotech.projectmanagementapis.service.UserLoginDetailsService;
import ca.timisencotech.projectmanagementapis.validation.Container;



@RestController
@RequestMapping("/projectmanagement")
public class UserLoginController 
{
	@Autowired
	UserLoginDetailsService userLoginDetailsService;
	

	
	
	@PostMapping("/confirmLoginDetails")
	@ResponseBody
	public <T> Container<T> confirmdUserLoginDetail(@Validated @RequestBody UserLogin userLogin,BindingResult result) { 
		Application.getLogger().info("User called confirmed user details (/confirmLoginDetails) api. parameters passed is: "+userLogin);
	    return  userLoginDetailsService.confirmedUserLoginDetails(userLogin, result);
	    			
	}
}

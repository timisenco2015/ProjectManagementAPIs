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
import ca.timisencotech.projectmanagementapis.domain.UserLoginDetail;
import ca.timisencotech.projectmanagementapis.service.UserLoginDetailsService;
import ca.timisencotech.projectmanagementapis.validation.Container;



@RestController
@RequestMapping("/projectmanagement")
public class UserLoginDetailsController 
{
	@Autowired
	UserLoginDetailsService userLoginDetailsService;
	
	
	@PostMapping("/addUserLoginDetails")
	@ResponseBody
	public <T> Container<T> addNewUserLoginDetails(@Validated @RequestBody UserLoginDetail userLoginDetail,BindingResult result) { 
		Application.getLogger().info("User called add user details api. parameters passed is: "+userLoginDetail);
	    return  userLoginDetailsService.addUserLoginDetails(userLoginDetail, result);
	    		
	}
	
}

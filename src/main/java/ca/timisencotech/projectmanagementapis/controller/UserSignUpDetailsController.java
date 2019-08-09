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
import ca.timisencotech.projectmanagementapis.domain.UserSignUpDetail;
import ca.timisencotech.projectmanagementapis.service.UserSignUpDetailsService;
import ca.timisencotech.projectmanagementapis.validation.Container;



@RestController
@RequestMapping("/projectmanagement")
public class UserSignUpDetailsController 
{
	@Autowired
	UserSignUpDetailsService userSignUpDetailsService;
	
	
	@PostMapping("/newUserSignUp")
	@ResponseBody
	public <T> Container<T> addNewUserLoginDetails(@Validated @RequestBody UserSignUpDetail userSignUpDetail,BindingResult result) { 
		Application.getLogger().info("User called add user sign up details (/newUserSignUpDetails) api. parameters passed is: "+userSignUpDetail);
	    return  userSignUpDetailsService.addUserSignUpDetails(userSignUpDetail, result);
	    		
	}
	
	
	
	
	
	@PostMapping("/changePassword")
	@ResponseBody
	public <T> Container<T> updateUserPassword(@Validated @RequestBody UserSignUpDetail userSignUpDetail,BindingResult result) { 
		Application.getLogger().info("User called update user password (/changePassword) api. parameters passed is: "+userSignUpDetail);
	    return  userSignUpDetailsService.updateUserPassword(userSignUpDetail, result);
	    			
	}
	
}

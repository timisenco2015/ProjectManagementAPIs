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
import ca.timisencotech.projectmanagementapis.domain.UserSignUp;
import ca.timisencotech.projectmanagementapis.service.UserSignUpService;
import ca.timisencotech.projectmanagementapis.validation.Container;



@RestController
@RequestMapping("/usersignup")
public class UserSignUpController 
{
	@Autowired
	UserSignUpService userSignUpService;
	
	
	@PostMapping("/newusersignup")
	@ResponseBody
	public <T> Container<T> addNewUserLogin(@Validated @RequestBody UserSignUp userSignUp,BindingResult result) { 
		Application.getLogger().info("User called add user sign up details (/newusersignup) api. parameters passed is: "+userSignUp);
	    return  userSignUpService.addUserSignUpDetails(userSignUp, result);
	    		
	}
	
	
	
	
	
	@PostMapping("/changePassword")
	@ResponseBody
	public <T> Container<T> updateUserPassword(@Validated @RequestBody UserSignUp userSignUp,BindingResult result) { 
		Application.getLogger().info("User called update user password (/changePassword) api. parameters passed is: "+userSignUp);
	    return  userSignUpService.updateUserPassword(userSignUp, result);
	    			
	}
	
}

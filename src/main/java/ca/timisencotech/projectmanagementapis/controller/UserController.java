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
import ca.timisencotech.projectmanagementapis.domain.User;
import ca.timisencotech.projectmanagementapis.service.UserService;
import ca.timisencotech.projectmanagementapis.validation.Container;



@RestController
@RequestMapping("/users")
public class UserController 
{
	
	@Autowired
	UserService userService;
	
	
	@PostMapping("/addnewuser")
	@ResponseBody
	public <T> Container<T> addNewUser(@Validated @RequestBody User user,BindingResult result) { 
		Application.getLogger().info("User called add user details (/addnewuser) api. parameters passed is: "+user);
	    return  userService.addNewUser(user, result);
	    		
	
	}
}

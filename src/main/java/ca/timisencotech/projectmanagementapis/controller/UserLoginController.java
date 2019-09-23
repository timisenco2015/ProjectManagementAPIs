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
import ca.timisencotech.projectmanagementapis.service.UserLoginService;
import ca.timisencotech.projectmanagementapis.validation.Container;



@RestController
@RequestMapping("/userlogin")
public class UserLoginController 
{
	@Autowired
	UserLoginService userLoginService;
	

	
	
	@PostMapping("/confirmlogindetails")
	@ResponseBody
	public <T> Container<T> confirmdUserLogin(@Validated @RequestBody UserLogin userLogin,BindingResult result) { 
		Application.getLogger().info("User called confirmed user details (/confirmLoginDetails) api. parameters passed is: "+userLogin);
	    return  userLoginService.confirmedUserLogin(userLogin, result);
	    			
	}
}

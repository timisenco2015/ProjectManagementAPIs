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
import ca.timisencotech.projectmanagementapis.domain.City;
import ca.timisencotech.projectmanagementapis.service.CitiesService;
import ca.timisencotech.projectmanagementapis.validation.Container;



@RestController
@RequestMapping("/city")
public class CityController 
{
	@Autowired
	CitiesService citiesService;
	
	
	@PostMapping("/addcity")
	@ResponseBody
	public <T> Container<T> addNewCity(@Validated @RequestBody City city,BindingResult result) { 
		
		 Application.getLogger().info("User called add city (/addcity) details api. parameters passed is: "+city);
 return  citiesService.addCity(city,result);
	    		
	
	}
}

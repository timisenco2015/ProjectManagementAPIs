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
import ca.timisencotech.projectmanagementapis.domain.StateProvince;
import ca.timisencotech.projectmanagementapis.service.StatesProvincesService;
import ca.timisencotech.projectmanagementapis.validation.Container;


@RestController
@RequestMapping("/projectmanagement")
public class StateProvinceController {
	
	@Autowired
	StatesProvincesService statesProvincesService;
	
	
	@PostMapping("/addStateProvince")
	@ResponseBody
	public <T> Container<T> addNewStateProvince(@Validated @RequestBody StateProvince stateProvince,BindingResult result) { 
		 
		 Application.getLogger().info("User called add state or province details api. parameters passed is: "+stateProvince);

		return  statesProvincesService.addStateProvince(stateProvince,result);
	    		
	
	}

}

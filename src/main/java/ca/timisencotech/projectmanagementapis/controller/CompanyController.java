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
import ca.timisencotech.projectmanagementapis.domain.Companies;
import ca.timisencotech.projectmanagementapis.service.CompaniesService;
import ca.timisencotech.projectmanagementapis.validation.Container;



@RestController
@RequestMapping("/projectmanagement")
public class CompanyController 
{
	@Autowired
	CompaniesService companiesService;
	
	
	@PostMapping("/registerCompany")
	@ResponseBody
	public <T> Container<T> addCompanies(@Validated @RequestBody Companies companies,BindingResult result) { 
		
		 Application.getLogger().info("User called add company details api. parameters passed is: "+companies);
		 return  companiesService.addCompanies(companies,result);
	    		
	
	}
}

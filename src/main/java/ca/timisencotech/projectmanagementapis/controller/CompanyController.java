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
import ca.timisencotech.projectmanagementapis.domain.Company;
import ca.timisencotech.projectmanagementapis.service.CompanyService;
import ca.timisencotech.projectmanagementapis.validation.Container;



@RestController
@RequestMapping("/company")
public class CompanyController 
{
	@Autowired
	CompanyService companyService;
	
	
	@PostMapping("/registercompany")
	@ResponseBody
	public <T> Container<T> registerNewCompany(@Validated @RequestBody Company company,BindingResult result) { 
		
		 Application.getLogger().info("User called add company details (/registercompany) api. parameters passed is: "+company);
		 return  companyService.addCompany(company,result);
	    		
	
	}
}

package ca.timisencotech.projectmanagementapis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ca.timisencotech.projectmanagementapis.Application;
import ca.timisencotech.projectmanagementapis.domain.Country;
import ca.timisencotech.projectmanagementapis.service.CountryService;
import ca.timisencotech.projectmanagementapis.validation.Container;



@RestController
@RequestMapping("/country")
public class CountryController
{
	
	@Autowired
	CountryService countryService;
	
	
	@PostMapping(path="/addcountry",consumes="application/json", produces="application/json")
	public @ResponseBody <T> Container<T> addNewCountry(@Validated @RequestBody Country country,BindingResult result) { 
		 Application.getLogger().info("User called add country details (/addcountry) api. parameters passed is: "+country);

		return  countryService.addCountry(country,result);
	    		
	
	}
	
	@GetMapping (path="/getCountry",consumes="text/plain", produces="application/json")
	public <T> Container<T> getCountryById(@Validated @RequestBody int countryId,BindingResult result)
	{
		 Application.getLogger().info("User called get country details api. parameters passed is: "+countryId);

		return  countryService.getCountryWithId(countryId);
	}
}

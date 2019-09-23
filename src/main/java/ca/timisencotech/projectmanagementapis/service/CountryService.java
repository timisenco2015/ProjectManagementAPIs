package ca.timisencotech.projectmanagementapis.service;


import org.springframework.validation.BindingResult;

import ca.timisencotech.projectmanagementapis.domain.Country;
import ca.timisencotech.projectmanagementapis.validation.Container;



public interface CountryService {
	
	public <T> Container<T> addCountry(Country country,BindingResult result);
	public <T> Container<T> getCountryWithId(int countryId);
}

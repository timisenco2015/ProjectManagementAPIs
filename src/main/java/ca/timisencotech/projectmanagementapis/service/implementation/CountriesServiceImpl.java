package ca.timisencotech.projectmanagementapis.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import ca.timisencotech.projectmanagementapis.Application;
import ca.timisencotech.projectmanagementapis.dao.implementation.CountriesDAOImp;
import ca.timisencotech.projectmanagementapis.domain.Country;
import ca.timisencotech.projectmanagementapis.service.CountriesService;
import ca.timisencotech.projectmanagementapis.validation.Container;


@Service("CountriesService")
@Transactional(propagation=Propagation.SUPPORTS, rollbackFor = Exception.class)
public class CountriesServiceImpl implements CountriesService {

	@Autowired
	private CountriesDAOImp countriesDAOImp;

	
	@Override
	public <T> Container<T> addCountry(Country country,BindingResult result) {
		Application.getLogger().info("addCountry method in Countries Service Implementation.");
	    
		return countriesDAOImp.addCountries(country);
	}
	
	@Override
	public <T> Container<T> getCountryWithId(int countryId)
	{
		Application.getLogger().info("getCountryWithId method in Countries Service Implementation.");
	    
		return countriesDAOImp.getCountryWithId(countryId);
	}

}

package ca.timisencotech.projectmanagementapis.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import ca.timisencotech.projectmanagementapis.Application;
import ca.timisencotech.projectmanagementapis.dao.implementation.CountryDAOImp;
import ca.timisencotech.projectmanagementapis.domain.Country;
import ca.timisencotech.projectmanagementapis.service.CountryService;
import ca.timisencotech.projectmanagementapis.validation.Container;


@Service("CountryService")
@Transactional(propagation=Propagation.SUPPORTS, rollbackFor = Exception.class)
public class CountryServiceImpl implements CountryService {

	@Autowired
	private CountryDAOImp countryDAOImp;

	
	@Override
	public <T> Container<T> addCountry(Country country,BindingResult result) {
		Application.getLogger().info("addCountry method in Country Service Implementation.");
	    
		return countryDAOImp.addCountry(country);
	}
	
	@Override
	public <T> Container<T> getCountryWithId(int countryId)
	{
		Application.getLogger().info("getCountryWithId method in Country Service Implementation.");
	    
		return countryDAOImp.getCountryWithId(countryId);
	}

}

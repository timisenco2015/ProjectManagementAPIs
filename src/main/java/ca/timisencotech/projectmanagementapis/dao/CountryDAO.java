package ca.timisencotech.projectmanagementapis.dao;

import ca.timisencotech.projectmanagementapis.domain.Country;
import ca.timisencotech.projectmanagementapis.validation.Container;

public interface CountryDAO {
	
	public <T> Container<T> addCountry(Country country);
	public <T> Container<T> getCountryWithId(int countryId);
}

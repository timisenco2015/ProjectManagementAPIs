package ca.timisencotech.projectmanagementapis.dao;

import ca.timisencotech.projectmanagementapis.domain.Country;
import ca.timisencotech.projectmanagementapis.validation.Container;

public interface CountriesDAO {
	
	public <T> Container<T> addCountries(Country country);
	public <T> Container<T> getCountryWithId(int countryId);
}

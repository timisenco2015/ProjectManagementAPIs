package ca.timisencotech.projectmanagementapis.dao;

import ca.timisencotech.projectmanagementapis.domain.City;
import ca.timisencotech.projectmanagementapis.validation.Container;

public interface CitiesDAO {
	public <T> Container<T> addCities(City city);
}

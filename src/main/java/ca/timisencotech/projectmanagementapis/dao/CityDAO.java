package ca.timisencotech.projectmanagementapis.dao;

import ca.timisencotech.projectmanagementapis.domain.City;
import ca.timisencotech.projectmanagementapis.validation.Container;

public interface CityDAO {
	public <T> Container<T> addCity(City city);
}

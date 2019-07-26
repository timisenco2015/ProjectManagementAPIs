package ca.timisencotech.projectmanagementapis.repository;

import org.springframework.data.repository.CrudRepository;

import ca.timisencotech.projectmanagementapis.dto.Countries;


public interface CountriesRepository extends CrudRepository<Countries, Integer> {
	public Countries findByCountryId(int countryId);
}

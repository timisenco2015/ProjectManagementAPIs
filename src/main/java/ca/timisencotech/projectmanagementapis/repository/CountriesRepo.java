package ca.timisencotech.projectmanagementapis.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import ca.timisencotech.projectmanagementapis.dto.Countries;


public interface CountriesRepo extends JpaRepository<Countries, Integer> {
	public Countries findByCountryId(int countryId);
}

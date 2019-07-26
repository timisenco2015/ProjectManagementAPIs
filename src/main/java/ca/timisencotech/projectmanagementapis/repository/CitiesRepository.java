package ca.timisencotech.projectmanagementapis.repository;

import org.springframework.data.repository.CrudRepository;

import ca.timisencotech.projectmanagementapis.dto.Cities;

public interface CitiesRepository extends CrudRepository<Cities, Long> {
	
	public Cities findByCityId(int cityId);

}

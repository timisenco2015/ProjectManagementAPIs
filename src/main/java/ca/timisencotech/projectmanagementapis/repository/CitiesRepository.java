package ca.timisencotech.projectmanagementapis.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import ca.timisencotech.projectmanagementapis.dto.Cities;

public interface CitiesRepository extends JpaRepository<Cities, Long> {
	
	public Cities findByCityId(int cityId);

}

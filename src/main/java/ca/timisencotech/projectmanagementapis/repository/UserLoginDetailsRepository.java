package ca.timisencotech.projectmanagementapis.repository;

import org.springframework.data.repository.CrudRepository;

import ca.timisencotech.projectmanagementapis.dto.UserLoginDetails;

public interface UserLoginDetailsRepository extends CrudRepository<UserLoginDetails, Long> {
	
	public UserLoginDetails findByEmail(String email);

}

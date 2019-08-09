package ca.timisencotech.projectmanagementapis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ca.timisencotech.projectmanagementapis.dto.UserDetails;
import ca.timisencotech.projectmanagementapis.dto.UserLoginDetails;


public interface UserLoginDetailsRepository extends JpaRepository<UserLoginDetails, Long> {
	

	@Query(value ="select u.logintime,u.password,u.email, from userloginstable u where u.email=?1", nativeQuery = true)
	UserDetails findUserLoginDetailsByEmail(String email);
	

	

}

package ca.timisencotech.projectmanagementapis.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ca.timisencotech.projectmanagementapis.dto.UserDetails;


public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {


	
	@Query(value ="select firstname,middlename,lastname,countryphonecode,phoneno,address,gender,email from userinformationtable where email=?1", nativeQuery = true)
	UserDetails findUserDetailsByEmail(String email);
	
	
}

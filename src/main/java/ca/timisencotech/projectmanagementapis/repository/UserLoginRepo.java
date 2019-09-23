package ca.timisencotech.projectmanagementapis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ca.timisencotech.projectmanagementapis.dto.UserLoginDetails;


public interface UserLoginRepo extends JpaRepository<UserLoginDetails, Long> {
	

	@Query(value ="select ult.logintime,ult.password,u.email,ult.usersignupid from userloginstable ult inner join usersignuptable u on ult.usersignupid=u.id where u.email=?1 order by ult.logintime DESC LIMIT 1", nativeQuery = true)
	UserLoginDetails findUserLoginDetailsByEmail(String email);
	

	

}

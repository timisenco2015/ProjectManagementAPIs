package ca.timisencotech.projectmanagementapis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ca.timisencotech.projectmanagementapis.dto.UserSignUpDetails;


public interface UserSignUpRepo extends JpaRepository<UserSignUpDetails, Long> {
	

	@Query(value ="select id, email, replace(password,password,'****') as password from usersignuptable where email=?1", nativeQuery = true)
	public UserSignUpDetails findUserSignUpDetailsByEmail(String email);

	
	@Modifying(clearAutomatically = true,flushAutomatically = true)
	@Query(value ="update usersignuptable  u set u.password=?1 where u.email=?2", nativeQuery = true)
	int updatePassword(String password,String email);
	
	public UserSignUpDetails findByEmail(String email);
	
	
	public UserSignUpDetails findByEmailAndPassword(String email,String password);
}

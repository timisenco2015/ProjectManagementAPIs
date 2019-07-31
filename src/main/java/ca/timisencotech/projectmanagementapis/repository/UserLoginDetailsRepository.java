package ca.timisencotech.projectmanagementapis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


import ca.timisencotech.projectmanagementapis.dto.UserLoginDetails;


public interface UserLoginDetailsRepository extends JpaRepository<UserLoginDetails, Long> {
	
/*	//public UserLoginDetails findByEmail(String email);
	@Transactional
	@Query(value ="select email,password,logintime from userlogindetailstable where email=?1", nativeQuery = true)
	UserLoginDetails findUserLoginDetailsByEmail(String email);
	
*/	
	
	@Modifying(clearAutomatically = true,flushAutomatically = true)
	@Query(value ="update userlogindetailstable u set u.password=?1 where u.email=?2", nativeQuery = true)
	int updatePassword(String password,String email);
	
	public UserLoginDetails findByEmail(String email);
	
	public UserLoginDetails findByEmailAndPassword(String email,String password);
	

}

package ca.timisencotech.projectmanagementapis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ca.timisencotech.projectmanagementapis.domain.UserLoginDetail;
import ca.timisencotech.projectmanagementapis.dto.UserLoginDetails;

public interface UserLoginDetailsRepository extends JpaRepository<UserLoginDetails, Long> {
	
/*	//public UserLoginDetails findByEmail(String email);
	@Transactional
	@Query(value ="select email,password,logintime from userlogindetailstable where email=?1", nativeQuery = true)
	UserLoginDetails findUserLoginDetailsByEmail(String email);
	
*/	
	@Query(value ="select email,password,logintime from userlogindetailstable where email=?1", nativeQuery = true)
	UserLoginDetail updatePassword(String password);
	
	public UserLoginDetails findByEmail(String email);
	
	public UserLoginDetails findByEmailAndPassword(String email,String password);
	

}

package ca.timisencotech.projectmanagementapis.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ca.timisencotech.projectmanagementapis.dto.UserDetails;


public interface UserRepo extends JpaRepository<UserDetails, Long> {


	
	@Query(value ="select ui.firstname, ui.middlename, ui.lastname, ui.phoneno, ui.address, ui.gender,u.email,ui.usersignupid,ui.id from userinformationtable ui inner join usersignuptable u on ui.usersignupid = u.id where u.email=?1", nativeQuery = true)
	UserDetails findUserDetailsByEmail(String email);
	
	
}
         
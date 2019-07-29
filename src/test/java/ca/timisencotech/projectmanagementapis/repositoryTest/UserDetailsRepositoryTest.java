package ca.timisencotech.projectmanagementapis.repositoryTest;

import static org.junit.Assert.assertNotNull;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.timisencotech.projectmanagementapis.dto.UserDetails;
import ca.timisencotech.projectmanagementapis.dto.UserLoginDetails;
import ca.timisencotech.projectmanagementapis.repository.UserDetailsRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDetailsRepositoryTest {
		 
		@Autowired
		  private UserDetailsRepository userDetailsRepository;

		  @Test
		  public void saveTest() {
			  
				Date date= new Date();
				Timestamp timeStamp = new Timestamp(date.getTime());
				
				UserLoginDetails newUserLoginDetails = new UserLoginDetails();
				newUserLoginDetails.setPassword("Test@2018");
				newUserLoginDetails.setLoginTime(timeStamp);
				newUserLoginDetails.setUserEmail("userEmail@gmail.com");
			  
			  UserDetails userDetails = new UserDetails();
			 // userDetails.setCountryPhoneCode("+1");
			  userDetails.setFirstName("Ayobami");
			  userDetails.setLastName("Idowu");
			  userDetails.setMiddleName("O");
			  userDetails.setPhoneNo("2049623755");
			  userDetails.setUserAddress("616 Armitage");
			  userDetails.setUserLoginDetails(newUserLoginDetails);
			  userDetails.setUserGender("Male");
			  
			  userDetailsRepository.save(userDetails);
			 assertNotNull(userDetailsRepository.findUserDetailsByEmail("userEmail@gmail.com"));
		  }
	
	}




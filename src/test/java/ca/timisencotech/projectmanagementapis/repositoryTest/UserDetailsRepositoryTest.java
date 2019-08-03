package ca.timisencotech.projectmanagementapis.repositoryTest;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.timisencotech.projectmanagementapis.dto.UserDetails;
import ca.timisencotech.projectmanagementapis.dto.UserSignUpDetails;
import ca.timisencotech.projectmanagementapis.repository.UserDetailsRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDetailsRepositoryTest {
		 
		@Autowired
		  private UserDetailsRepository userDetailsRepository;

		  @Test
		  public void saveTest() {
			  
			
				UserSignUpDetails userSignUpDetails = new UserSignUpDetails();
				userSignUpDetails.setPassword("Test@2018");
				userSignUpDetails.setUserEmail("userEmail@gmail.com");
				
			  UserDetails userDetails = new UserDetails();
			  userDetails.setFirstName("Ayobami");
			  userDetails.setLastName("Idowu");
			  userDetails.setMiddleName("O");
			  userDetails.setPhoneNo("2049623755");
			  userDetails.setAddress("616 Armitage");
			  userDetails.setUserSignUpDetails(userSignUpDetails);
			  userDetails.setUserSignUpDetails(userSignUpDetails);;
			  userDetails.setGender("Male");
			  
			  userDetailsRepository.save(userDetails);
			 assertNotNull(userDetailsRepository.findUserDetailsByEmail("userEmail@gmail.com"));
		  }
		  
		  
		  @Test
		  public void findUserDetailsByEmailTest() {
			  
			
			 assertNotNull(userDetailsRepository.findUserDetailsByEmail("userEmail@gmail.com"));
		  }
	
	}




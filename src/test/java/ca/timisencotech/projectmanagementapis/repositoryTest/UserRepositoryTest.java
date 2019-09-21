package ca.timisencotech.projectmanagementapis.repositoryTest;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.timisencotech.projectmanagementapis.dto.UserDetails;
import ca.timisencotech.projectmanagementapis.dto.UserSignUpDetails;
import ca.timisencotech.projectmanagementapis.repository.UserRepository;
import ca.timisencotech.projectmanagementapis.repository.UserSignUpRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {
		 
		@Autowired
		private UserRepository userRepository;
		
		@Autowired
		UserSignUpRepository userSignUpRepository;

		  @Test
		  public void saveTest() {
			  
			
				UserSignUpDetails findUserSignUpDetails = userSignUpRepository.findUserSignUpDetailsByEmail("userAEmail@gmail.com");
				
			  UserDetails userDetails = new UserDetails();
			  userDetails.setFirstName("Gorge");
			  userDetails.setLastName("John");
			  userDetails.setMiddleName("O");
			  userDetails.setPhoneNo("2049623755");
			  userDetails.setAddress("616 Armitage");
			  userDetails.setUserSignUpDetails(findUserSignUpDetails);
			  userDetails.setGender("Male");
			  
			//  userDetailsRepository.save(userDetails);
			 assertNotNull(userRepository.findUserDetailsByEmail("userAEmail@gmail.com"));
		  }
		  
		  
		  @Test
		  public void findUserDetailsByEmailTest() {
			  
			
			 assertNotNull(userRepository.findUserDetailsByEmail("userAEmail@gmail.com"));
		  }
	
	}




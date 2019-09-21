package ca.timisencotech.projectmanagementapis.repositoryTest;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.timisencotech.projectmanagementapis.dto.UserSignUpDetails;
import ca.timisencotech.projectmanagementapis.repository.UserSignUpRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserSignUpRepositoryTest {
		 
		@Autowired
		  private UserSignUpRepository userSignUpRepository;

		  @Test
		  public void saveTest() {
			  
			
				UserSignUpDetails userSignUpDetails = new UserSignUpDetails();
				userSignUpDetails.setPassword("Test@2018");
				userSignUpDetails.setUserEmail("userBEmail@gmail.com");
			userSignUpRepository.save(userSignUpDetails);
			 assertNotNull(userSignUpRepository.findByEmail("userEmail@gmail.com"));
		  }
		  
		  
		  @Test
		  public void findByEmailTest() {
			  
			
			 assertNotNull(userSignUpRepository.findByEmail("userEmail@gmail.com"));
		  }
		  
		  
		  @Test
		  public void findByEmailAndPassword() {
			  
			
			 assertNotNull(userSignUpRepository.findByEmailAndPassword("userAEmail@gmail.com", "Test@2018"));
		  }
	
	}




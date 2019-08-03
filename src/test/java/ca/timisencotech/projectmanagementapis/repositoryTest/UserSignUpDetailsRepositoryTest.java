package ca.timisencotech.projectmanagementapis.repositoryTest;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.timisencotech.projectmanagementapis.dto.UserSignUpDetails;
import ca.timisencotech.projectmanagementapis.repository.UserSignUpDetailsRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserSignUpDetailsRepositoryTest {
		 
		@Autowired
		  private UserSignUpDetailsRepository userSignUpDetailsRepository;

		  @Test
		  public void saveTest() {
			  
			
				UserSignUpDetails userSignUpDetails = new UserSignUpDetails();
				userSignUpDetails.setPassword("Test@2018");
				userSignUpDetails.setUserEmail("userEmail@gmail.com");
			userSignUpDetailsRepository.save(userSignUpDetails);
			 assertNotNull(userSignUpDetailsRepository.findByEmail("userEmail@gmail.com"));
		  }
		  
		  
		  @Test
		  public void findByEmailTest() {
			  
			
			 assertNotNull(userSignUpDetailsRepository.findByEmail("userEmail@gmail.com"));
		  }
		  
		  
		  @Test
		  public void findByEmailAndPassword() {
			  
			
			 assertNotNull(userSignUpDetailsRepository.findByEmailAndPassword("userEmail@gmail.com", "Test@2018"));
		  }
	
	}




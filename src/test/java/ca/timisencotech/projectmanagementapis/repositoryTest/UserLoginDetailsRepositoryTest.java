package ca.timisencotech.projectmanagementapis.repositoryTest;

import static org.junit.Assert.assertNotNull;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.timisencotech.projectmanagementapis.dto.UserLoginDetails;
import ca.timisencotech.projectmanagementapis.dto.UserSignUpDetails;
import ca.timisencotech.projectmanagementapis.repository.UserLoginRepository;
import ca.timisencotech.projectmanagementapis.repository.UserSignUpRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserLoginDetailsRepositoryTest {
		 
		@Autowired
		  private UserLoginRepository userLoginRepository;
		
		@Autowired
		UserSignUpRepository userSignUpRepository;

		  @Test
		  public void saveTest() {
			  
				Date date= new Date();
				Timestamp timeStamp = new Timestamp(date.getTime());
				
				UserSignUpDetails userSignUpDetails = new UserSignUpDetails();
				userSignUpDetails.setPassword("Test@2018");
				userSignUpDetails.setUserEmail("userAEmail@gmail.com");
				
				UserSignUpDetails responseUserSignUpDetails =	userSignUpRepository.findByEmailAndPassword("userAEmail@gmail.com", "Test@2018");
				
				UserLoginDetails userLoginDetails = new UserLoginDetails();
				userLoginDetails.setPassword("Test@2018");
				userLoginDetails.setLoginTime(timeStamp);
				userLoginDetails.setUserSignUpDetails(responseUserSignUpDetails);
			  
			 
				userLoginRepository.save(userLoginDetails);
			 assertNotNull(userLoginRepository.findUserLoginDetailsByEmail("userAEmail@gmail.com"));
		  }
		  
		  @Test
		  public void findUserLoginDetailsByEmailTest() {
			
			 assertNotNull(userLoginRepository.findUserLoginDetailsByEmail("userAEmail@gmail.com"));
		  }
		  
	
	
	}




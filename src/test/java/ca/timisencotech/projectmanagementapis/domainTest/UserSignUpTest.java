package ca.timisencotech.projectmanagementapis.domainTest;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.timisencotech.projectmanagementapis.domain.UserSignUp;





@RunWith(SpringRunner.class)
@SpringBootTest
public class UserSignUpTest 
{
	@Test
	public void testSettersGetters() 
	{

	
		
		UserSignUp userSignUp = new UserSignUp();
		
		
		
		//check setter and getter for email
		userSignUp.setEmail("testEmail@gmail.com");
		String testResult1 = "testEmail@gmail.com";
		assertEquals(testResult1, userSignUp.getEmail());
		
		//check setter and getter for password
		userSignUp.setPassword("Test@2019");
		 testResult1 = "Test@2019";
		assertEquals(testResult1,userSignUp.getPassword());
		
	
		
		 
	

		 assertEquals("testEmail@gmail.com",  userSignUp.getEmail());
		 assertEquals("Test@2019", userSignUp.getPassword());
		
		
	}

}

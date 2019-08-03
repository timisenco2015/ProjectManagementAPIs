package ca.timisencotech.projectmanagementapis.domainTest;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.timisencotech.projectmanagementapis.domain.UserSignUpDetail;





@RunWith(SpringRunner.class)
@SpringBootTest
public class UserSignUpDetailTest 
{
	@Test
	public void testSettersGetters() 
	{

	
		
		UserSignUpDetail userSignUpDetail = new UserSignUpDetail();
		
		
		
		//check setter and getter for email
		userSignUpDetail.setUserEmail("testEmail@gmail.com");
		String testResult1 = "testEmail@gmail.com";
		assertEquals(testResult1, userSignUpDetail.getUserEmail());
		
		//check setter and getter for password
		userSignUpDetail.setPassword("Test@2019");
		 testResult1 = "Test@2019";
		assertEquals(testResult1,userSignUpDetail.getPassword());
		
	
		
		 
	

		 assertEquals("testEmail@gmail.com",  userSignUpDetail.getUserEmail());
		 assertEquals("Test@2019", userSignUpDetail.getPassword());
		
		
	}

}

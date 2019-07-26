package ca.timisencotech.projectmanagementapis.dtoTest;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.timisencotech.projectmanagementapis.dto.UserLoginDetails;




@RunWith(SpringRunner.class)
@SpringBootTest
public class UserLoginDetailsTest 
{
	@Test
	public void testSettersGetters() 
	{
		UserLoginDetails userLoginDetails = new UserLoginDetails();
		userLoginDetails.setUserEmail("userEmail@gmail.com");
		userLoginDetails.setPassword("Test@2018");
		Date date= new Date();
		Timestamp timeStamp = new Timestamp(date.getTime());
		userLoginDetails.setLoginTime(timeStamp);
		
	
		
		
		//check setter and getter for user email
		userLoginDetails.setUserEmail("userEmail@gmail.com");
		String testResult1 = "userEmail@gmail.com";
		assertEquals(testResult1, userLoginDetails.getUserEmail());
		
		//check setter and getter for password
		userLoginDetails.setPassword("Test@2018");
		 testResult1 = "Test@2018";
		assertEquals(testResult1,userLoginDetails.getPassword());
		
		//check setter and getter for login time
		userLoginDetails.setLoginTime(timeStamp);
		Timestamp testResult2 = timeStamp;
		assertEquals(testResult2, userLoginDetails.getLoginTime());
		
		
		

		assertEquals("userEmail@gmail.com", userLoginDetails.getUserEmail());
		assertEquals("Test@2018",userLoginDetails.getPassword());
		assertEquals(timeStamp, userLoginDetails.getLoginTime());
		
	}

}

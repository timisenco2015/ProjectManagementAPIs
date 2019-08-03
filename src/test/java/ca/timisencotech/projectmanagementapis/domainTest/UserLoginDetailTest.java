package ca.timisencotech.projectmanagementapis.domainTest;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.timisencotech.projectmanagementapis.domain.UserLoginDetail;





@RunWith(SpringRunner.class)
@SpringBootTest
public class UserLoginDetailTest 
{
	@Test
	public void testSettersGetters() 
	{
		UserLoginDetail userLoginDetail = new UserLoginDetail();
		userLoginDetail.setUserEmail("userEmail@gmail.com");
		userLoginDetail.setPassword("Test@2018");
		Date date= new Date();
		Timestamp loginTime = new Timestamp(date.getTime());
		
		
	
		
		//check setter and getter for user email
		userLoginDetail.setUserEmail("userEmail@gmail.com");
		String testResult1 = "userEmail@gmail.com";
		assertEquals(testResult1, userLoginDetail.getUserEmail());
				
		//check setter and getter for password
		userLoginDetail.setPassword("Test@2018");
		testResult1 = "Test@2018";
		assertEquals(testResult1,userLoginDetail.getPassword());
				
		//check setter and getter for login time
		userLoginDetail.setLoginTime(loginTime);
		assertEquals(loginTime, userLoginDetail.getLoginTime());
		
		
		assertEquals("userEmail@gmail.com", userLoginDetail.getUserEmail());
		assertEquals("Test@2018",userLoginDetail.getPassword());
		assertEquals(loginTime, userLoginDetail.getLoginTime());
		
	}

}

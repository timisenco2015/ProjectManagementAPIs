package ca.timisencotech.projectmanagementapis.domainTest;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.timisencotech.projectmanagementapis.domain.UserLogin;





@RunWith(SpringRunner.class)
@SpringBootTest
public class UserLoginTest 
{
	@Test
	public void testSettersGetters() 
	{
		UserLogin userLogin = new UserLogin();
		userLogin.setUserEmail("userEmail@gmail.com");
		userLogin.setPassword("Test@2018");
		Date date= new Date();
		Timestamp loginTime = new Timestamp(date.getTime());
		
		
	
		
		//check setter and getter for user email
		userLogin.setUserEmail("userEmail@gmail.com");
		String testResult1 = "userEmail@gmail.com";
		assertEquals(testResult1, userLogin.getUserEmail());
				
		//check setter and getter for password
		userLogin.setPassword("Test@2018");
		testResult1 = "Test@2018";
		assertEquals(testResult1,userLogin.getPassword());
				
		//check setter and getter for login time
		userLogin.setLoginTime(loginTime);
		assertEquals(loginTime, userLogin.getLoginTime());
		
		
		assertEquals("userEmail@gmail.com", userLogin.getUserEmail());
		assertEquals("Test@2018",userLogin.getPassword());
		assertEquals(loginTime, userLogin.getLoginTime());
		
	}

}

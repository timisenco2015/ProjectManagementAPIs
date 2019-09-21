package ca.timisencotech.projectmanagementapis.domainTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.timisencotech.projectmanagementapis.domain.User;




@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest 
{
	@Test
	public void testSettersGetters() 
	{
		User user = new User();
		
		
	
		//check setter and getter for first name
		user.setFirstName("Ayobami");
		String testResult1 = "Ayobami";
		assertEquals(testResult1,user.getFirstName());
		
		//check setter and getter for last name
		user.setLastName("Idowu");
		 testResult1 = "Idowu";
		assertEquals(testResult1, user.getLastName());
		
		//check setter and getter for middle name
		user.setMiddleName("O");
		testResult1 = "O";
		assertEquals(testResult1, user.getMiddleName());
		
		//check setter and getter for phone number
		user.setPhoneNo("2049623755");
		 testResult1 = "2049623755";
		assertEquals(testResult1, user.getPhoneNo());
		
		//check setter and getter for address
		user.setUserAddress("616 Armitage");
		 testResult1 = "616 Armitage";
		assertEquals(testResult1, user.getUserAddress());
		
		//check setter and getter for email
		user.setUserEmail("userEmail@gmail.com");
		testResult1 = "userEmail@gmail.com";
		assertEquals(testResult1, user.getUserEmail());
		
		//check setter and getter for gender
		user.setUserGender("Male");
		testResult1 = "Male";
		assertEquals(testResult1, user.getUserGender());
		
	


		assertEquals("Ayobami",user.getFirstName());
		assertEquals("Idowu", user.getLastName());
		assertEquals("O", user.getMiddleName());
		assertEquals("2049623755", user.getPhoneNo());
		assertEquals("616 Armitage", user.getUserAddress());
		assertEquals("userEmail@gmail.com", user.getUserEmail());
		assertEquals("Male", user.getUserGender());
		
	}

}

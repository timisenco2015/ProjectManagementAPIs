package ca.timisencotech.projectmanagementapis.domainTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.timisencotech.projectmanagementapis.domain.UserDetail;




@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDetailTest 
{
	@Test
	public void testSettersGetters() 
	{
		UserDetail userDetail = new UserDetail();
		
		
		//check setter and getter for phone code
		//userDetail.setCountryPhoneCode("+1");
		String testResult1 = "+1";
		//assertEquals(testResult1, userDetail.getCountryPhoneCode());
		
		//check setter and getter for first name
		userDetail.setFirstName("Ayobami");
		 testResult1 = "Ayobami";
		assertEquals(testResult1,userDetail.getFirstName());
		
		//check setter and getter for last name
		userDetail.setLastName("Idowu");
		 testResult1 = "Idowu";
		assertEquals(testResult1, userDetail.getLastName());
		
		//check setter and getter for middle name
		userDetail.setMiddleName("O");
		testResult1 = "O";
		assertEquals(testResult1, userDetail.getMiddleName());
		
		//check setter and getter for phone number
		userDetail.setPhoneNo("2049623755");
		 testResult1 = "2049623755";
		assertEquals(testResult1, userDetail.getPhoneNo());
		
		//check setter and getter for address
		userDetail.setUserAddress("616 Armitage");
		 testResult1 = "616 Armitage";
		assertEquals(testResult1, userDetail.getUserAddress());
		
		//check setter and getter for email
		userDetail.setUserEmail("userEmail@gmail.com");
		testResult1 = "userEmail@gmail.com";
		assertEquals(testResult1, userDetail.getUserEmail());
		
		//check setter and getter for gender
		userDetail.setUserGender("Male");
		testResult1 = "Male";
		assertEquals(testResult1, userDetail.getUserGender());
		
	

		//assertEquals("+1", userDetail.getCountryPhoneCode());
		assertEquals("Ayobami",userDetail.getFirstName());
		assertEquals("Idowu", userDetail.getLastName());
		assertEquals("O", userDetail.getMiddleName());
		assertEquals("2049623755", userDetail.getPhoneNo());
		assertEquals("616 Armitage", userDetail.getUserAddress());
		assertEquals("userEmail@gmail.com", userDetail.getUserEmail());
		assertEquals("Male", userDetail.getUserGender());
		
	}

}

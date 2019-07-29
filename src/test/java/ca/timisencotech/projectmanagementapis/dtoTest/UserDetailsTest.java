package ca.timisencotech.projectmanagementapis.dtoTest;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.timisencotech.projectmanagementapis.dto.UserDetails;
import ca.timisencotech.projectmanagementapis.dto.UserLoginDetails;




@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDetailsTest 
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
		
		UserDetails userDetails = new UserDetails();
		
		
		//check setter and getter for phone code
		//userDetails.setCountryPhoneCode("+1");
		String testResult1 = "+1";
	//	assertEquals(testResult1, userDetails.getCountryPhoneCode());
		
		//check setter and getter for first name
		userDetails.setFirstName("Ayobami");
		 testResult1 = "Ayobami";
		assertEquals(testResult1,userDetails.getFirstName());
		
		//check setter and getter for last name
		userDetails.setLastName("Idowu");
		 testResult1 = "Idowu";
		assertEquals(testResult1, userDetails.getLastName());
		
		//check setter and getter for middle name
		userDetails.setMiddleName("O");
		testResult1 = "O";
		assertEquals(testResult1, userDetails.getMiddleName());
		
		//check setter and getter for phone number
		userDetails.setPhoneNo("2049623755");
		 testResult1 = "2049623755";
		assertEquals(testResult1, userDetails.getPhoneNo());
		
		//check setter and getter for address
		userDetails.setUserAddress("616 Armitage");
		 testResult1 = "616 Armitage";
		assertEquals(testResult1, userDetails.getUserAddress());
		
		//check setter and getter for email
		userDetails.setUserLoginDetails(userLoginDetails);;
		testResult1 = "userEmail@gmail.com";
		assertEquals(testResult1, userDetails.getUserLoginDetails().getUserEmail());
		
		//check setter and getter for gender
		userDetails.setUserGender("Male");
		testResult1 = "Male";
		assertEquals(testResult1, userDetails.getUserGender());
		
	

		//assertEquals("+1", userDetails.getCountryPhoneCode());
		assertEquals("Ayobami",userDetails.getFirstName());
		assertEquals("Idowu", userDetails.getLastName());
		assertEquals("O", userDetails.getMiddleName());
		assertEquals("2049623755", userDetails.getPhoneNo());
		assertEquals("616 Armitage", userDetails.getUserAddress());
		assertEquals("userEmail@gmail.com", userDetails.getUserLoginDetails().getUserEmail());
		assertEquals("Male", userDetails.getUserGender());
		
	}

}

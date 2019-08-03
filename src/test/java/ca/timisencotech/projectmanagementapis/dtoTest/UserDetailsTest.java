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
import ca.timisencotech.projectmanagementapis.dto.UserSignUpDetails;




@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDetailsTest 
{
	@Test
	public void testSettersGetters() 
	{
		
		UserSignUpDetails userSignUpDetails = new UserSignUpDetails();
		userSignUpDetails.setPassword("Test@2018");
		userSignUpDetails.setUserEmail("userEmail@gmail.com");
		
		UserLoginDetails userLoginDetails = new UserLoginDetails();
		userLoginDetails.setUserSignUpDetails(userSignUpDetails);
		userLoginDetails.setPassword("Test@2018");
		Date date= new Date();
		Timestamp timeStamp = new Timestamp(date.getTime());
		userLoginDetails.setLoginTime(timeStamp);
		
		UserDetails userDetails = new UserDetails();
		
	
		//check setter and getter for first name
		userDetails.setFirstName("Ayobami");
	String	 testResult1 = "Ayobami";
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
		userDetails.setAddress("616 Armitage");
		 testResult1 = "616 Armitage";
		assertEquals(testResult1, userDetails.getAddress());
		
		//check setter and getter for email
		userDetails.setUserSignUpDetails(userSignUpDetails);
		testResult1 = "userEmail@gmail.com";
		assertEquals(userSignUpDetails, userDetails.getUserSignUpDetails());
		
		//check setter and getter for gender
		userDetails.setGender("Male");
		testResult1 = "Male";
		assertEquals(testResult1, userDetails.getGender());
		
	

		//assertEquals("+1", userDetails.getCountryPhoneCode());
		assertEquals("Ayobami",userDetails.getFirstName());
		assertEquals("Idowu", userDetails.getLastName());
		assertEquals("O", userDetails.getMiddleName());
		assertEquals("2049623755", userDetails.getPhoneNo());
		assertEquals("616 Armitage", userDetails.getAddress());
		assertEquals(userSignUpDetails, userDetails.getUserSignUpDetails());
		assertEquals("Male", userDetails.getGender());
		
	}

}

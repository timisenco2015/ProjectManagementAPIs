package ca.timisencotech.projectmanagementapis.dtoTest;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.timisencotech.projectmanagementapis.dto.ProjectDetails;
import ca.timisencotech.projectmanagementapis.dto.UserDetails;
import ca.timisencotech.projectmanagementapis.dto.UserSignUpDetails;




@RunWith(SpringRunner.class)
@SpringBootTest
public class UserSignUpDetailsTest 
{
	@Test
	public void testSettersGetters() 
	{

	
		
		UserSignUpDetails userSignUpDetails = new UserSignUpDetails();
		
		
		//check setter and getter for email
		userSignUpDetails.setUserEmail("testEmail@gmail.com");
		String testResult1 = "testEmail@gmail.com";
		assertEquals(testResult1, userSignUpDetails.getUserEmail());
		
		//check setter and getter for password
		userSignUpDetails.setPassword("Test@2019");
		 testResult1 = "Test@2019";
		assertEquals(testResult1,userSignUpDetails.getPassword());
		
		//check setter and getter for Userdetails
		
		UserDetails newUserDetails = new UserDetails();
		newUserDetails.setFirstName("Ayobami");
		newUserDetails.setLastName("Idowu");
		newUserDetails.setGender("Male");
		newUserDetails.setMiddleName("O");
		newUserDetails.setPhoneNo("2049623755");
		newUserDetails.setAddress("616 Armitage");
		
		userSignUpDetails.setUserDetails(newUserDetails);
		
		assertEquals(newUserDetails, userSignUpDetails.getUserDetails());
		
		//check setter and getter for middle name
		ProjectDetails  projectDetails = new ProjectDetails();
		projectDetails.setProjectName("Sherwood Project");
		 
		Date date= new Date();
		Timestamp createdDate = new Timestamp(date.getTime());	
		projectDetails.setCreatedDate(createdDate);
		 
		 Timestamp startDate = new Timestamp(date.getTime());	
		 projectDetails.setStartDate(startDate);
		 
		
		 
		 Timestamp endDate = new Timestamp(date.getTime());	
		 projectDetails.setEndDate(endDate);
		 
		 projectDetails.setDescription("Description coming soon");
		
		 List<ProjectDetails>projectDetailsList = new ArrayList<ProjectDetails>();
		 projectDetailsList.add(projectDetails);
		 userSignUpDetails.setProjectDetails(projectDetailsList);
		 
		 assertEquals(projectDetails, userSignUpDetails.getProjectDetails().get(0));
		
		

		 assertEquals("testEmail@gmail.com", userSignUpDetails.getUserEmail());
		 assertEquals("Test@2019",userSignUpDetails.getPassword());
		 assertEquals(newUserDetails, userSignUpDetails.getUserDetails());
		 assertEquals(projectDetails, userSignUpDetails.getProjectDetails().get(0));
		
	}

}

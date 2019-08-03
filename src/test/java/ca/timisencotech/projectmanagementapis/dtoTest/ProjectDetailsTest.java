package ca.timisencotech.projectmanagementapis.dtoTest;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.timisencotech.projectmanagementapis.dto.ProjectDetails;
import ca.timisencotech.projectmanagementapis.dto.UserSignUpDetails;





@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectDetailsTest 
{
	@Test
	public void testSettersGetters() 
	{
		
		UserSignUpDetails userSignUpDetails = new UserSignUpDetails();
		userSignUpDetails.setPassword("Test@2018");
		userSignUpDetails.setUserEmail("timiUser@gmail");
		
		
		Date date= new Date();
		Timestamp loginTime = new Timestamp(date.getTime());
		
		
		ProjectDetails projectDetails = new ProjectDetails();
		
		
	
		//check setter and getter for UserSignUpDetail
		projectDetails.setUserSignUpDetails(userSignUpDetails);
		assertEquals(userSignUpDetails, projectDetails.getUserSignUpDetails());

		//check setter and getter for created date
		projectDetails.setCreatedDate(loginTime);
		assertEquals(loginTime,projectDetails.getCreatedDate());
		
		//check setter and getter for start date
	
		projectDetails.setStartDate(loginTime);
		assertEquals(loginTime, projectDetails.getStartDate());
		
		
		//check setter and getter for end date
		projectDetails.setEndDate(loginTime);
		assertEquals(loginTime, projectDetails.getEndDate());
		
		//check setter and getter for project name
		projectDetails.setProjectName("Edmonton Project");
		String  testResult1 = "Edmonton Project";
		assertEquals(testResult1, projectDetails.getProjectName());
		
		
		//check setter and getter for project description
		projectDetails.setDescription("dfdsdsgdsgds");
		testResult1 = "dfdsdsgdsgds";
		assertEquals(testResult1, projectDetails.getDescription());
		
		
		
	


		assertEquals("Edmonton Project",projectDetails.getProjectName());
		assertEquals(loginTime, projectDetails.getCreatedDate());
		assertEquals(loginTime, projectDetails.getStartDate());
		assertEquals(loginTime, projectDetails.getEndDate());
		assertEquals(userSignUpDetails, projectDetails.getUserSignUpDetails());
		assertEquals("dfdsdsgdsgds",  projectDetails.getDescription());
		
		
	}

}

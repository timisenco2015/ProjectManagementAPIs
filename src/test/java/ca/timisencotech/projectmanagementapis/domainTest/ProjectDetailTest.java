package ca.timisencotech.projectmanagementapis.domainTest;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.timisencotech.projectmanagementapis.domain.ProjectInformation;





@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectDetailTest 
{
	@Test
	public void testSettersGetters() 
	{
		ProjectInformation projectInformation = new ProjectInformation();
		
		
	
		//check setter and getter for first name
		projectInformation.setProjectName("Edmonton Project");
		String testResult1 = "Edmonton Project";
		assertEquals(testResult1,projectInformation.getProjectName());
		
		//check setter and getter for created date
		Date date= new Date();
		Timestamp loginTime = new Timestamp(date.getTime());
		projectInformation.setCreatedDate(loginTime);
		assertEquals(loginTime, projectInformation.getCreatedDate());
		
		//check setter and getter for start date
	
		 loginTime = new Timestamp(date.getTime());
		 projectInformation.setStartDate(loginTime);
		assertEquals(loginTime, projectInformation.getStartDate());
		
		//check setter and getter for end date
		 loginTime = new Timestamp(date.getTime());
		 projectInformation.setEndDate(loginTime);
		assertEquals(loginTime, projectInformation.getEndDate());
		
		//check setter and getter for created by
		testResult1 = "userEmail@gmail.com";
		projectInformation.setCreatedBy("userEmail@gmail.com");
		assertEquals(testResult1, projectInformation.getCreatedBy());
		
		//check setter and getter for email
		projectInformation.setDescription("dfdsdsgdsgds");
		testResult1 = "dfdsdsgdsgds";
		assertEquals(testResult1, projectInformation.getDescription());
		
		
		
	


		assertEquals("Edmonton Project",projectInformation.getProjectName());
		assertEquals(loginTime, projectInformation.getCreatedDate());
		assertEquals(loginTime, projectInformation.getStartDate());
		assertEquals(loginTime, projectInformation.getEndDate());
		assertEquals("userEmail@gmail.com", projectInformation.getCreatedBy());
		assertEquals("dfdsdsgdsgds",  projectInformation.getDescription());
		
		
	}

}

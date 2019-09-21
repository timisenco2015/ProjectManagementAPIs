package ca.timisencotech.projectmanagementapis.domainTest;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.timisencotech.projectmanagementapis.domain.Project;





@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectInformationTest 
{
	@Test
	public void testSettersGetters() 
	{
		Project project = new Project();
		
		
	
		//check setter and getter for first name
		project.setProjectName("Edmonton Project");
		String testResult1 = "Edmonton Project";
		assertEquals(testResult1,project.getProjectName());
		
		//check setter and getter for created date
		Date date= new Date();
		Timestamp loginTime = new Timestamp(date.getTime());
		project.setCreatedDate(loginTime);
		assertEquals(loginTime, project.getCreatedDate());
		
		//check setter and getter for start date
	
		 loginTime = new Timestamp(date.getTime());
		 project.setStartDate(loginTime);
		assertEquals(loginTime, project.getStartDate());
		
		//check setter and getter for end date
		 loginTime = new Timestamp(date.getTime());
		 project.setEndDate(loginTime);
		assertEquals(loginTime, project.getEndDate());
		
		//check setter and getter for created by
		testResult1 = "userEmail@gmail.com";
		project.setCreatedBy("userEmail@gmail.com");
		assertEquals(testResult1, project.getCreatedBy());
		
		//check setter and getter for email
		project.setDescription("dfdsdsgdsgds");
		testResult1 = "dfdsdsgdsgds";
		assertEquals(testResult1, project.getDescription());
		
		
		
	


		assertEquals("Edmonton Project",project.getProjectName());
		assertEquals(loginTime, project.getCreatedDate());
		assertEquals(loginTime, project.getStartDate());
		assertEquals(loginTime, project.getEndDate());
		assertEquals("userEmail@gmail.com", project.getCreatedBy());
		assertEquals("dfdsdsgdsgds",  project.getDescription());
		
		
	}

}

package ca.timisencotech.projectmanagementapis.domainTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.sql.Timestamp;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.timisencotech.projectmanagementapis.domain.ProjectGroup;




@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectGroupTest 
{
	@Test
	public void testSettersGetters() 
	{
		ProjectGroup projectGroup = new ProjectGroup();
		
		
	
		//check setter and getter for created by
		projectGroup.setCreatedBy("userEmail@gmail.com");
		String testResult1 = "userEmail@gmail.com";
		assertEquals(testResult1,projectGroup.getCreatedBy());
		
		//check setter and getter for created date
		Date date= new Date();
		Timestamp createdDate = new Timestamp(date.getTime());
		
		projectGroup.setCreatedDate(createdDate);
		assertEquals(createdDate,projectGroup.getCreatedDate());
				
		//check setter and getter for description
		projectGroup.setDescription("dfghjk");
		 testResult1 = "dfghjk";
		assertEquals(testResult1,projectGroup.getDescription());
		
		//check setter and getter for group name
		projectGroup.setGroupName("group1");
		 testResult1 = "group1";
		assertEquals(testResult1,projectGroup.getGroupName());
		
		//check setter and getter for is active
		projectGroup.setIsActive(true);
		assertTrue(projectGroup.getIsActive());
		
		//check setter and getter for project name
		projectGroup.setProjectName("Sherwood Project");
		 testResult1 = "Sherwood Project";
		 assertEquals(testResult1,projectGroup.getProjectName());
			
		


		 assertEquals("userEmail@gmail.com",projectGroup.getCreatedBy());
		 assertEquals(createdDate,projectGroup.getCreatedDate());
		 assertEquals("dfghjk",projectGroup.getDescription());
		 assertEquals("group1",projectGroup.getGroupName());
		 assertTrue(projectGroup.getIsActive());
			 assertEquals("Sherwood Project",projectGroup.getProjectName());
			
		
	}

}

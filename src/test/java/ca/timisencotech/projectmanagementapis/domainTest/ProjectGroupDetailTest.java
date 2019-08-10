package ca.timisencotech.projectmanagementapis.domainTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.sql.Timestamp;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.timisencotech.projectmanagementapis.domain.ProjectGroupDetail;




@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectGroupDetailTest 
{
	@Test
	public void testSettersGetters() 
	{
		ProjectGroupDetail projectGroupDetail = new ProjectGroupDetail();
		
		
	
		//check setter and getter for created by
		projectGroupDetail.setCreatedBy("userEmail@gmail.com");
		String testResult1 = "userEmail@gmail.com";
		assertEquals(testResult1,projectGroupDetail.getCreatedBy());
		
		//check setter and getter for created date
		Date date= new Date();
		Timestamp createdDate = new Timestamp(date.getTime());
		
		projectGroupDetail.setCreatedDate(createdDate);
		assertEquals(createdDate,projectGroupDetail.getCreatedDate());
				
		//check setter and getter for description
		projectGroupDetail.setDescription("dfghjk");
		 testResult1 = "dfghjk";
		assertEquals(testResult1,projectGroupDetail.getDescription());
		
		//check setter and getter for group name
		projectGroupDetail.setGroupName("group1");
		 testResult1 = "group1";
		assertEquals(testResult1,projectGroupDetail.getGroupName());
		
		//check setter and getter for is active
		projectGroupDetail.setIsActive(true);
		assertTrue(projectGroupDetail.getIsActive());
		
		//check setter and getter for project name
		projectGroupDetail.setProjectName("Sherwood Project");
		 testResult1 = "Sherwood Project";
		 assertEquals(testResult1,projectGroupDetail.getProjectName());
			
		


		 assertEquals("userEmail@gmail.com",projectGroupDetail.getCreatedBy());
		 assertEquals(createdDate,projectGroupDetail.getCreatedDate());
		 assertEquals("dfghjk",projectGroupDetail.getDescription());
		 assertEquals("group1",projectGroupDetail.getGroupName());
		 assertTrue(projectGroupDetail.getIsActive());
			 assertEquals("Sherwood Project",projectGroupDetail.getProjectName());
			
		
	}

}

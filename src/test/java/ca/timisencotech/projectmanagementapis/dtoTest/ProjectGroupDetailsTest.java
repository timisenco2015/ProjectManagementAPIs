package ca.timisencotech.projectmanagementapis.dtoTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Timestamp;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.timisencotech.projectmanagementapis.dto.ProjectDetails;
import ca.timisencotech.projectmanagementapis.dto.ProjectGroupDetails;
import ca.timisencotech.projectmanagementapis.dto.UserSignUpDetails;





@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectGroupDetailsTest 
{
	@Test
	public void testSettersGetters() 
	{
		Date date= new Date();
		
		
		ProjectDetails projectDetails = new ProjectDetails();
		
		Timestamp createdDate = new Timestamp(date.getTime());
		projectDetails.setCreatedDate(createdDate);
		projectDetails.setDescription("dfddvdv");
		Timestamp endDate = new Timestamp(date.getTime());
		projectDetails.setEndDate(endDate);
		projectDetails.setProjectName("Sherwood Project");
		Timestamp startDate = new Timestamp(date.getTime());
		projectDetails.setStartDate(startDate);
		
		
		UserSignUpDetails userSignUpDetails = new UserSignUpDetails();
		userSignUpDetails.setPassword("Test@2018");
		userSignUpDetails.setUserEmail("userEmail@gmail.com");
		
		
		
		ProjectGroupDetails projectGroupDetails = new ProjectGroupDetails();
		
		projectGroupDetails.setDescription("dfdsfddv");
		assertEquals("dfdsfddv", projectGroupDetails.getDescription());
 
		
		createdDate = new Timestamp(date.getTime());
		projectGroupDetails.setGroupCreatedDate(createdDate);
		assertEquals(createdDate, projectGroupDetails.getGroupCreatedDate());

		projectGroupDetails.setGroupName("Group 2");
		assertEquals("Group 2", projectGroupDetails.getGroupName());
		 
		projectGroupDetails.setIsActive(true);
		assertTrue(projectGroupDetails.getIsActive());
		
		projectGroupDetails.setProjectDetails(projectDetails);
		assertEquals(projectDetails,projectGroupDetails.getProjectDetails());
		
		projectGroupDetails.setUserSignUpDetails(userSignUpDetails);
		assertEquals(userSignUpDetails,projectGroupDetails.getUserSignUpDetails());
		
		
		assertEquals("dfdsfddv", projectGroupDetails.getDescription());
		assertEquals(createdDate, projectGroupDetails.getGroupCreatedDate());
		assertEquals("Group 2", projectGroupDetails.getGroupName());
		assertTrue(projectGroupDetails.getIsActive());
		assertEquals(projectDetails,projectGroupDetails.getProjectDetails());
		assertEquals(userSignUpDetails,projectGroupDetails.getUserSignUpDetails());
		
		
	}

}

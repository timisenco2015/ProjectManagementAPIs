package ca.timisencotech.projectmanagementapis.dtoTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Timestamp;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.timisencotech.projectmanagementapis.dto.ProjectGroupDetails;
import ca.timisencotech.projectmanagementapis.dto.ProjectSupervisorsDetails;
import ca.timisencotech.projectmanagementapis.repository.ProjectSupervisorsRepo;




@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectGroupDetailsTest 
{
	@Autowired
	ProjectSupervisorsRepo projectSupervisorsRepo;
	
	
	@Test
	public void testSettersGetters() 
	{
		Date date= new Date();
		Timestamp createdDate = new Timestamp(date.getTime());
	
	
		
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
		
		ProjectSupervisorsDetails findProjectSupervisorsDetails= projectSupervisorsRepo.findProjectSupervisorByProjectAndSupervisorName("Sherwood Project","userEmail@gmail.com");
		projectGroupDetails.setProjectSupervisorsDetails(findProjectSupervisorsDetails);
		assertEquals(findProjectSupervisorsDetails,projectGroupDetails.getProjectSupervisorsDetails());
		
	
		assertEquals("dfdsfddv", projectGroupDetails.getDescription());
		assertEquals(createdDate, projectGroupDetails.getGroupCreatedDate());
		assertEquals("Group 2", projectGroupDetails.getGroupName());
		assertTrue(projectGroupDetails.getIsActive());
		assertEquals(findProjectSupervisorsDetails,projectGroupDetails.getProjectSupervisorsDetails());
		
		
	}

}

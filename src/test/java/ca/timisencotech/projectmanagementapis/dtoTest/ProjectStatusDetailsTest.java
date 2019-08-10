package ca.timisencotech.projectmanagementapis.dtoTest;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.timisencotech.projectmanagementapis.dto.ProjectDetails;
import ca.timisencotech.projectmanagementapis.dto.ProjectStatusDetails;





@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectStatusDetailsTest 
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
		
	
		ProjectStatusDetails projectStatusDetails = new ProjectStatusDetails();
		
		Timestamp completedDate = new Timestamp(date.getTime());
		projectStatusDetails.setCompletedDate(completedDate);
		assertEquals(completedDate, projectStatusDetails.getCompletedDate());
		
		projectStatusDetails.setDescription("dfdssvsdv");
		assertEquals("dfdssvsdv", projectStatusDetails.getDescription());
		
		projectStatusDetails.setDonePercentage(45.45);
		assertEquals(45.45, projectStatusDetails.getDonePercentage(),0.00);
		
		projectStatusDetails.setProjectDetails(projectDetails);
		assertEquals(projectDetails, projectStatusDetails.getProjectDetails());
		
		Timestamp updatedDate = new Timestamp(date.getTime());
		projectStatusDetails.setUpdatedDate(updatedDate);
		assertEquals(updatedDate, projectStatusDetails.getUpdatedDate());
		
		
		assertEquals(completedDate, projectStatusDetails.getCompletedDate());
		assertEquals("dfdssvsdv", projectStatusDetails.getDescription());
		assertEquals(45.45, projectStatusDetails.getDonePercentage(),0.00);
		assertEquals(projectDetails, projectStatusDetails.getProjectDetails());
		assertEquals(updatedDate, projectStatusDetails.getUpdatedDate());
		
		
	}

}

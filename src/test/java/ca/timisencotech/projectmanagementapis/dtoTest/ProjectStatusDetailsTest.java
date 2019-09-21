package ca.timisencotech.projectmanagementapis.dtoTest;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.timisencotech.projectmanagementapis.dto.ProjectStatusDetails;
import ca.timisencotech.projectmanagementapis.dto.ProjectSupervisorsDetails;
import ca.timisencotech.projectmanagementapis.repository.ProjectSupervisorsRepository;





@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectStatusDetailsTest 
{
	@Autowired
	ProjectSupervisorsRepository projectSupervisorsRepository;
	
	@Test
	public void testSettersGetters() 
	{
		ProjectSupervisorsDetails findProjectSupervisorsDetails =projectSupervisorsRepository.findProjectSupervisorByProjectAndSupervisorName("Sherwood Project","userAEmail@gmail.com");
		
		
		Date date= new Date();
		
	
	
		ProjectStatusDetails projectStatusDetails = new ProjectStatusDetails();
		
		Timestamp completedDate = new Timestamp(date.getTime());
		projectStatusDetails.setCompletedDate(completedDate);
		assertEquals(completedDate, projectStatusDetails.getCompletedDate());
		
		projectStatusDetails.setDescription("dfdssvsdv");
		assertEquals("dfdssvsdv", projectStatusDetails.getDescription());
		
		projectStatusDetails.setDonePercentage(45.45);
		assertEquals(45.45, projectStatusDetails.getDonePercentage(),0.00);
		
		
		Timestamp updatedDate = new Timestamp(date.getTime());
		projectStatusDetails.setUpdatedDate(updatedDate);
		assertEquals(updatedDate, projectStatusDetails.getUpdatedDate());
		
		projectStatusDetails.setProjectSupervisorsDetails(findProjectSupervisorsDetails);
		assertEquals(findProjectSupervisorsDetails, projectStatusDetails.getProjectSupervisorsDetails());
		
		
		
		assertEquals(completedDate, projectStatusDetails.getCompletedDate());
		assertEquals("dfdssvsdv", projectStatusDetails.getDescription());
		assertEquals(45.45, projectStatusDetails.getDonePercentage(),0.00);
		assertEquals(updatedDate, projectStatusDetails.getUpdatedDate());
		assertEquals(findProjectSupervisorsDetails, projectStatusDetails.getProjectSupervisorsDetails());
		
		
	}

}

package ca.timisencotech.projectmanagementapis.dtoTest;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.timisencotech.projectmanagementapis.dto.ProjectDetails;
import ca.timisencotech.projectmanagementapis.dto.ProjectSupervisorsDetails;
import ca.timisencotech.projectmanagementapis.dto.UserSignUpDetails;





@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectSupervisorsDetailsTest 
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
		
		
		ProjectSupervisorsDetails projectSupervisorsDetails = new ProjectSupervisorsDetails();
		
		projectSupervisorsDetails.setIsActive(true);;
		assertEquals(true, projectSupervisorsDetails.getIsActive());

		
		projectSupervisorsDetails.setProjectDetails(projectDetails);
		assertEquals(projectDetails, projectSupervisorsDetails.getProjectDetails());

		
		projectSupervisorsDetails.setUserSignUpDetails(userSignUpDetails);
		assertEquals(userSignUpDetails, projectSupervisorsDetails.getUserSignUpDetails());

		
		
		assertEquals(true, projectSupervisorsDetails.getIsActive());
		assertEquals(projectDetails, projectSupervisorsDetails.getProjectDetails());
		assertEquals(userSignUpDetails, projectSupervisorsDetails.getUserSignUpDetails());

		
	}

}

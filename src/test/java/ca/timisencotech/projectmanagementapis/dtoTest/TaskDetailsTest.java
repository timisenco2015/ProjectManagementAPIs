package ca.timisencotech.projectmanagementapis.dtoTest;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ca.timisencotech.projectmanagementapis.dto.ProjectDetails;
import ca.timisencotech.projectmanagementapis.dto.TaskDetails;
import ca.timisencotech.projectmanagementapis.dto.UserSignUpDetails;
import ca.timisencotech.projectmanagementapis.repository.ProjectRepo;
import ca.timisencotech.projectmanagementapis.repository.UserSignUpRepo;





@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskDetailsTest 
{
	@Autowired
	ProjectRepo projectRepo;
	
	@Autowired
	UserSignUpRepo userSignUpRepo;
	
	@Test
	public void testSettersGetters() 
	{
		
		ProjectDetails findProjectDetails = projectRepo.findProjectDetailsByProjectName("Edmonton Project");
		UserSignUpDetails findUserSignUpDetails =userSignUpRepo.findUserSignUpDetailsByEmail("userAAEmail@gmail.com");

		
		
		Date date= new Date();
		Timestamp loginTime = new Timestamp(date.getTime());
		
		
		TaskDetails taskDetails = new TaskDetails();
		
		
	
		//check setter and getter for UserSignUpDetail
		taskDetails.setUserSignUpDetails(findUserSignUpDetails);
		assertEquals(findUserSignUpDetails, taskDetails.getUserSignUpDetails());

		//check setter and getter for created date
		taskDetails.setCreatedDate(loginTime);
		assertEquals(loginTime,taskDetails.getCreatedDate());
		
		//check setter and getter for start date
	
		taskDetails.setStartDate(loginTime);
		assertEquals(loginTime, taskDetails.getStartDate());
		
		
		//check setter and getter for end date
		taskDetails.setEndDate(loginTime);
		assertEquals(loginTime, taskDetails.getEndDate());
		
		//check setter and getter for project name
		taskDetails.setProjectDetails(findProjectDetails);
		assertEquals(findProjectDetails, taskDetails.getProjectDetails());
		
		
		//check setter and getter for project description
		taskDetails.setDescription("dfdsdsgdsgds");
		String testResult1 = "dfdsdsgdsgds";
		assertEquals(testResult1, taskDetails.getDescription());
		
		//check setter and getter for task name
				taskDetails.setTaskName("Sub Task2");
				testResult1 = "Sub Task2";
				assertEquals(testResult1, taskDetails.getDescription());
				
		
	


		assertEquals(findProjectDetails,taskDetails.getProjectDetails());
		assertEquals(loginTime, taskDetails.getCreatedDate());
		assertEquals(loginTime, taskDetails.getStartDate());
		assertEquals(loginTime, taskDetails.getEndDate());
		assertEquals(findUserSignUpDetails, taskDetails.getUserSignUpDetails());
		assertEquals("dfdsdsgdsgds",  taskDetails.getDescription());
		assertEquals("Sub Task2",  taskDetails.getTaskName());
		
		
	}

}

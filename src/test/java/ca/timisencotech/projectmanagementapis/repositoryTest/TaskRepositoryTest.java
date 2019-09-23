package ca.timisencotech.projectmanagementapis.repositoryTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
import ca.timisencotech.projectmanagementapis.repository.TaskRepo;
import ca.timisencotech.projectmanagementapis.repository.UserSignUpRepo;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskRepositoryTest {
		 
		@Autowired
		private ProjectRepo projectRepo;
		
		@Autowired
		UserSignUpRepo userSignUpRepo;
		
		@Autowired
		TaskRepo taskRepo;

		  @Test
		  public void saveTest() {
			  Date date= new Date();
				Timestamp loginTime = new Timestamp(date.getTime());
				
				UserSignUpDetails findUserSignUpDetails =	userSignUpRepo.findUserSignUpDetailsByEmail("userEmail@gmail.com");
				ProjectDetails findProjectDetails =  projectRepo.findProjectDetailsByProjectName("Sherwood Project");
				
				
				
			  TaskDetails taskDetails = new TaskDetails();
			  taskDetails.setProjectDetails(findProjectDetails);
			 
				loginTime = new Timestamp(date.getTime());
				taskDetails.setCreatedDate(loginTime);
				
				loginTime = new Timestamp(date.getTime());
				taskDetails.setStartDate(loginTime);
				
				loginTime = new Timestamp(date.getTime());
				taskDetails.setEndDate(loginTime);
				
				
				taskDetails.setDescription("dfdfdffdf");
				taskDetails.setTaskName("Sub Task4");
				
				taskDetails.setUserSignUpDetails(findUserSignUpDetails);
				
				
				
				taskRepo.save(taskDetails);
			 assertNotNull(projectRepo.findProjectDetailsByProjectName("Calgary Project"));
		  }
		  
		  
		  @Test
		  public void findProjectDetailsByProjectNameTest() {
			  
			
			 assertNotNull(projectRepo.findProjectDetailsByProjectName("Calgary Project"));
		  }
		  
		
		  
		  @Test
		  public void updateProjectDetailsTest()
		  {
			  
			  Date date= new Date();
				
				Timestamp createdDate = new Timestamp(date.getTime());
				
				Timestamp startDate = new Timestamp(date.getTime());
				
				Timestamp endDate = new Timestamp(date.getTime());
				
				String description = "dfdfdffdfghjhggggg";
				
				String projectName = "Sherwood Project";
				String taskName = "Sub Task4";
				int updateValue = taskRepo.updateTaskDetails(createdDate, startDate, endDate, description,  projectName,taskName);
				assertEquals(1,updateValue);
		  }
		  
		  
		
	
	}




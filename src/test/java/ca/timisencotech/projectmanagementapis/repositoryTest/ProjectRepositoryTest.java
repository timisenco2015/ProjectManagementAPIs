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
import ca.timisencotech.projectmanagementapis.dto.UserSignUpDetails;
import ca.timisencotech.projectmanagementapis.repository.ProjectRepo;
import ca.timisencotech.projectmanagementapis.repository.UserSignUpRepo;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectRepositoryTest {
		 
		@Autowired
		private ProjectRepo projectRepo;
		
		@Autowired
		UserSignUpRepo userSignUpRepo;

		  @Test
		  public void saveTest() {
			  Date date= new Date();
				Timestamp loginTime = new Timestamp(date.getTime());
				
				UserSignUpDetails findUserSignUpDetails =	userSignUpRepo.findUserSignUpDetailsByEmail("userEmail@gmail.com");
				
				
				
			  ProjectDetails projectDetails = new ProjectDetails();
				projectDetails.setProjectName("Winnipeg Project");
				loginTime = new Timestamp(date.getTime());
				projectDetails.setCreatedDate(loginTime);
				
				loginTime = new Timestamp(date.getTime());
				projectDetails.setStartDate(loginTime);
				
				loginTime = new Timestamp(date.getTime());
				projectDetails.setEndDate(loginTime);
				
				
				projectDetails.setDescription("dfdfdffdf");
				
				
				projectDetails.setUserSignUpDetails(findUserSignUpDetails);
				
				
				
				projectRepo.save(projectDetails);
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
				
				String projectName = "Winnipeg Project";
				
				int updateValue = projectRepo.updateProjectDetails(createdDate,startDate,endDate, description, projectName);
				assertEquals(1,updateValue);
		  }
		  
		  
		
	
	}




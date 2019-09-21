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
import ca.timisencotech.projectmanagementapis.repository.ProjectRepository;
import ca.timisencotech.projectmanagementapis.repository.UserSignUpRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectRepositoryTest {
		 
		@Autowired
		private ProjectRepository projectRepository;
		
		@Autowired
		UserSignUpRepository userSignUpRepository;

		  @Test
		  public void saveTest() {
			  Date date= new Date();
				Timestamp loginTime = new Timestamp(date.getTime());
				
				UserSignUpDetails findUserSignUpDetails =	userSignUpRepository.findUserSignUpDetailsByEmail("userEmail@gmail.com");
				
				
				
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
				
				
				
				projectRepository.save(projectDetails);
			 assertNotNull(projectRepository.findProjectDetailsByProjectName("Calgary Project"));
		  }
		  
		  
		  @Test
		  public void findProjectDetailsByProjectNameTest() {
			  
			
			 assertNotNull(projectRepository.findProjectDetailsByProjectName("Calgary Project"));
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
				
				int updateValue = projectRepository.updateProjectDetails(createdDate,startDate,endDate, description, projectName);
				assertEquals(1,updateValue);
		  }
		  
		  
		
	
	}




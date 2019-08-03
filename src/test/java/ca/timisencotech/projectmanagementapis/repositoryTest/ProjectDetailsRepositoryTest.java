package ca.timisencotech.projectmanagementapis.repositoryTest;

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
import ca.timisencotech.projectmanagementapis.repository.ProjectDetailsRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectDetailsRepositoryTest {
		 
		@Autowired
		  private ProjectDetailsRepository projectDetailsRepository;

		  @Test
		  public void saveTest() {
			  Date date= new Date();
				Timestamp loginTime = new Timestamp(date.getTime());
				
			
			  ProjectDetails projectDetails = new ProjectDetails();
				projectDetails.setProjectName("Calgary Project");
				loginTime = new Timestamp(date.getTime());
				projectDetails.setCreatedDate(loginTime);
				
				loginTime = new Timestamp(date.getTime());
				projectDetails.setStartDate(loginTime);
				
				loginTime = new Timestamp(date.getTime());
				projectDetails.setEndDate(loginTime);
				
				
				projectDetails.setDescription("dfdfdffdf");
				
				
				UserSignUpDetails userSignUpDetails = new UserSignUpDetails();
				userSignUpDetails.setPassword("Test@2018");
				userSignUpDetails.setUserEmail("userEmail@gmail.com");
				projectDetails.setUserSignUpDetails(userSignUpDetails);
				
				projectDetailsRepository.save(projectDetails);
			 assertNotNull(projectDetailsRepository.findProjectDetailsByProjectName("Calgary Project"));
		  }
		  
		  
		  @Test
		  public void findProjectDetailsByProjectNameTest() {
			  
			
			 assertNotNull(projectDetailsRepository.findProjectDetailsByProjectName("Calgary Project"));
		  }
		  
		  
		
	
	}




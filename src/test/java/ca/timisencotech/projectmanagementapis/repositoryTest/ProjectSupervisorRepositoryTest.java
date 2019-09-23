package ca.timisencotech.projectmanagementapis.repositoryTest;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ca.timisencotech.projectmanagementapis.dto.ProjectDetails;
import ca.timisencotech.projectmanagementapis.dto.ProjectSupervisorsDetails;
import ca.timisencotech.projectmanagementapis.dto.UserSignUpDetails;
import ca.timisencotech.projectmanagementapis.repository.ProjectRepo;
import ca.timisencotech.projectmanagementapis.repository.ProjectSupervisorsRepo;
import ca.timisencotech.projectmanagementapis.repository.UserSignUpRepo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectSupervisorRepositoryTest {
		 
		@Autowired
		ProjectRepo projectRepo;
		
		@Autowired
		UserSignUpRepo userSignUpRepo;
		
		@Autowired
		ProjectSupervisorsRepo projectSupervisorsRepo;

		  @Test
		  public void saveTest() {
			  
			
				UserSignUpDetails findUserSignUpDetails = userSignUpRepo.findUserSignUpDetailsByEmail("userAEmail@gmail.com");
				ProjectDetails findProjectDetails = projectRepo.findProjectDetailsByProjectName("Sherwood Project");
				
					
				
			ProjectSupervisorsDetails projectSupervisorsDetails = new ProjectSupervisorsDetails();
			projectSupervisorsDetails.setUserSignUpDetails(findUserSignUpDetails);
			projectSupervisorsDetails.setProjectDetails(findProjectDetails);
			
	
			  
	projectSupervisorsRepo.save(projectSupervisorsDetails);
			 assertNotNull(projectSupervisorsRepo.findProjectSupervisorByProjectAndSupervisorName("Sherwood Project","userAEmail@gmail.com"));
		  }
		  
		  
		  @Test
		  public void findProjectSupervisorByProjectAndSupervisorNameTest() {
			  
			
				 assertNotNull(projectSupervisorsRepo.findProjectSupervisorByProjectAndSupervisorName("Sherwood Project","userAEmail@gmail.com"));
	}
	
	}




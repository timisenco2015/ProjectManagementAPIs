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
import ca.timisencotech.projectmanagementapis.repository.ProjectRepository;
import ca.timisencotech.projectmanagementapis.repository.ProjectSupervisorsRepository;
import ca.timisencotech.projectmanagementapis.repository.UserSignUpRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectSupervisorRepositoryTest {
		 
		@Autowired
		ProjectRepository projectRepository;
		
		@Autowired
		UserSignUpRepository userSignUpRepository;
		
		@Autowired
		ProjectSupervisorsRepository projectSupervisorsRepository;

		  @Test
		  public void saveTest() {
			  
			
				UserSignUpDetails findUserSignUpDetails = userSignUpRepository.findUserSignUpDetailsByEmail("userAEmail@gmail.com");
				ProjectDetails findProjectDetails = projectRepository.findProjectDetailsByProjectName("Sherwood Project");
				
					
				
			ProjectSupervisorsDetails projectSupervisorsDetails = new ProjectSupervisorsDetails();
			projectSupervisorsDetails.setUserSignUpDetails(findUserSignUpDetails);
			projectSupervisorsDetails.setProjectDetails(findProjectDetails);
			
	
			  
	projectSupervisorsRepository.save(projectSupervisorsDetails);
			 assertNotNull(projectSupervisorsRepository.findProjectSupervisorByProjectAndSupervisorName("Sherwood Project","userAEmail@gmail.com"));
		  }
		  
		  
		  @Test
		  public void findProjectSupervisorByProjectAndSupervisorNameTest() {
			  
			
				 assertNotNull(projectSupervisorsRepository.findProjectSupervisorByProjectAndSupervisorName("Sherwood Project","userAEmail@gmail.com"));
	}
	
	}




package ca.timisencotech.projectmanagementapis.repositoryTest;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.timisencotech.projectmanagementapis.dto.ProjectGroupDetails;
import ca.timisencotech.projectmanagementapis.dto.ProjectGroupMemberDetails;
import ca.timisencotech.projectmanagementapis.dto.UserSignUpDetails;
import ca.timisencotech.projectmanagementapis.repository.ProjectGroupMemberRepo;
import ca.timisencotech.projectmanagementapis.repository.ProjectGroupRepository;
import ca.timisencotech.projectmanagementapis.repository.UserSignUpRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectGroupMemberRepositoryTest {
		 
	@Autowired
	ProjectGroupRepository projectGroupRepository;
	
		@Autowired
		UserSignUpRepository userSignUpRepository;
		
		@Autowired
		ProjectGroupMemberRepo projectGroupMemberRepo;
		  
		@Test
		  public void saveTest() {
			  
			
			ProjectGroupMemberDetails  projectGroupMemberDetails = new  ProjectGroupMemberDetails();
			
			
			ProjectGroupDetails findProjectGroupDetails = projectGroupRepository.findProjectGroupDetailsByGroupName("Sherwood Project","Group 3");
			UserSignUpDetails findUserSignUpDetails = userSignUpRepository.findUserSignUpDetailsByEmail("userABEmail@gmail.com");

			projectGroupMemberDetails.setActivitiesUpdate("ddasdsvdvdsvsv");
	
			projectGroupMemberDetails.setIsActive(true);
			projectGroupMemberDetails.setUserSignUpDetails(findUserSignUpDetails);
			projectGroupMemberDetails.setProjectGroupDetails(findProjectGroupDetails);
			
			
	
			  
			projectGroupMemberRepo.save(projectGroupMemberDetails);
			 assertNotNull(projectGroupMemberRepo.findProjectMemberByProjectname("Sherwood Project","userABEmail@gmail.com"));
		  }
	  
		  @Test
		  public void findProjectSupervisorByProjectAndSupervisorNameTest() {
				 assertNotNull(projectGroupMemberRepo.findProjectMemberByProjectname("Sherwood Project","userABEmail@gmail.com"));
				 }
	
	}




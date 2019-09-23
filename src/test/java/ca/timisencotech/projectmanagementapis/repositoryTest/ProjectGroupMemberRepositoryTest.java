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
import ca.timisencotech.projectmanagementapis.repository.ProjectGroupRepo;
import ca.timisencotech.projectmanagementapis.repository.UserSignUpRepo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectGroupMemberRepositoryTest {
		 
	@Autowired
	ProjectGroupRepo projectGroupRepo;
	
		@Autowired
		UserSignUpRepo userSignUpRepo;
		
		@Autowired
		ProjectGroupMemberRepo projectGroupMemberRepo;
		  
		@Test
		  public void saveTest() {
			  
			
			ProjectGroupMemberDetails  projectGroupMemberDetails = new  ProjectGroupMemberDetails();
			
			
			ProjectGroupDetails findProjectGroupDetails = projectGroupRepo.findProjectGroupDetailsByGroupName("Sherwood Project","Group 3");
			UserSignUpDetails findUserSignUpDetails = userSignUpRepo.findUserSignUpDetailsByEmail("userABEmail@gmail.com");

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




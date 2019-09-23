package ca.timisencotech.projectmanagementapis.repositoryTest;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.timisencotech.projectmanagementapis.dto.ProjectGroupMemberDetails;
import ca.timisencotech.projectmanagementapis.dto.ProjectSupervisorsDetails;
import ca.timisencotech.projectmanagementapis.dto.SupervisorsMembersDetails;
import ca.timisencotech.projectmanagementapis.repository.ProjectGroupMemberRepo;
import ca.timisencotech.projectmanagementapis.repository.ProjectSupervisorsRepo;
import ca.timisencotech.projectmanagementapis.repository.SupervisorsMembersRepo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SupervisorsMembersRepositoryTest {
		 
	@Autowired
	ProjectSupervisorsRepo projectSupervisorsRepo;
	
	
	@Autowired
	ProjectGroupMemberRepo projectGroupMemberRepo;
	
		@Autowired
		SupervisorsMembersRepo supervisorsMembersRepo;

		  @Test
		  public void saveTest() {
			  

				SupervisorsMembersDetails supervisorsMembersDetails = new  SupervisorsMembersDetails();
				
				ProjectSupervisorsDetails findProjectSupervisorsDetails =  projectSupervisorsRepo.findProjectSupervisorByProjectAndSupervisorName("Winnipeg Project","userEmail@gmail.com");
				ProjectGroupMemberDetails findProjectGroupMemberDetails =  projectGroupMemberRepo.findProjectMemberByProjectname("Winnipeg Project","userACAGEmail@gmail.com");
				supervisorsMembersDetails.setProjectGroupMemberDetails(findProjectGroupMemberDetails);
				supervisorsMembersDetails.setProjectSupervisorsDetails(findProjectSupervisorsDetails);
				
				supervisorsMembersRepo.save(supervisorsMembersDetails);
				assertNotNull(supervisorsMembersRepo.findSupervisorsMembersDetails("Winnipeg Project","userEmail@gmail.com","userACAGEmail@gmail.com"));
		  }
		  
		  
		  @Test
		  public void findProjectSupervisorByProjectAndSupervisorNameTest() {
			  
				assertNotNull(supervisorsMembersRepo.findSupervisorsMembersDetails("Winnipeg Project","userEmail@gmail.com","userACAGEmail@gmail.com"));
				    }
	
	}




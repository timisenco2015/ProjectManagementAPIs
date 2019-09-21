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
import ca.timisencotech.projectmanagementapis.repository.ProjectSupervisorsRepository;
import ca.timisencotech.projectmanagementapis.repository.SupervisorsMembersRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SupervisorsMembersRepositoryTest {
		 
	@Autowired
	ProjectSupervisorsRepository projectSupervisorsRepository;
	
	
	@Autowired
	ProjectGroupMemberRepo projectGroupMemberRepo;
	
		@Autowired
		SupervisorsMembersRepository supervisorsMembersRepository;

		  @Test
		  public void saveTest() {
			  

				SupervisorsMembersDetails supervisorsMembersDetails = new  SupervisorsMembersDetails();
				
				ProjectSupervisorsDetails findProjectSupervisorsDetails =  projectSupervisorsRepository.findProjectSupervisorByProjectAndSupervisorName("Winnipeg Project","userEmail@gmail.com");
				ProjectGroupMemberDetails findProjectGroupMemberDetails =  projectGroupMemberRepo.findProjectMemberByProjectname("Winnipeg Project","userACAGEmail@gmail.com");
				supervisorsMembersDetails.setProjectGroupMemberDetails(findProjectGroupMemberDetails);
				supervisorsMembersDetails.setProjectSupervisorsDetails(findProjectSupervisorsDetails);
				
				supervisorsMembersRepository.save(supervisorsMembersDetails);
				assertNotNull(supervisorsMembersRepository.findSupervisorsMembersDetails("Winnipeg Project","userEmail@gmail.com","userACAGEmail@gmail.com"));
		  }
		  
		  
		  @Test
		  public void findProjectSupervisorByProjectAndSupervisorNameTest() {
			  
				assertNotNull(supervisorsMembersRepository.findSupervisorsMembersDetails("Winnipeg Project","userEmail@gmail.com","userACAGEmail@gmail.com"));
				    }
	
	}




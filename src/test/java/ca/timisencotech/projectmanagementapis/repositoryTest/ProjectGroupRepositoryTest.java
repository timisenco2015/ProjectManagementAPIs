package ca.timisencotech.projectmanagementapis.repositoryTest;

import static org.junit.Assert.assertNotNull;
import java.sql.Timestamp;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.timisencotech.projectmanagementapis.dto.ProjectGroupDetails;
import ca.timisencotech.projectmanagementapis.dto.ProjectSupervisorsDetails;
import ca.timisencotech.projectmanagementapis.repository.ProjectGroupRepository;
import ca.timisencotech.projectmanagementapis.repository.ProjectSupervisorsRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectGroupRepositoryTest {
		 
		@Autowired
		ProjectGroupRepository projectGroupRepo;
		
		
		@Autowired
		ProjectSupervisorsRepository projectSupervisorsRepo;

		  @Test
		  public void saveTest() {
			  
			
			  ProjectSupervisorsDetails findProjectSupervisorsDetails = projectSupervisorsRepo.findProjectSupervisorByProjectAndSupervisorName("Sherwood Project","userEmail@gmail.com");
					
			  Date date= new Date();
				Timestamp createdDate = new Timestamp(date.getTime());
			
			
				
				ProjectGroupDetails projectGroupDetails = new ProjectGroupDetails();
				
				projectGroupDetails.setDescription("dfdsfddv");
				createdDate = new Timestamp(date.getTime());
				projectGroupDetails.setGroupCreatedDate(createdDate);
				projectGroupDetails.setGroupName("Group 3");
				projectGroupDetails.setIsActive(true);
				projectGroupDetails.setProjectSupervisorsDetails(findProjectSupervisorsDetails);
				
				assertNotNull(projectGroupRepo.findProjectGroupDetailsByGroupName("Sherwood Project","Group 3"));
		  }
		  
		  
		  @Test
		  public void findProjectSupervisorByProjectAndSupervisorNameTest() {
			  
				assertNotNull(projectGroupRepo.findProjectGroupDetailsByGroupName("Sherwood Project","Group 3"));
			}
	
	}




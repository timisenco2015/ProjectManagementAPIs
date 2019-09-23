package ca.timisencotech.projectmanagementapis.repositoryTest;

import static org.junit.Assert.assertNotNull;
import java.sql.Timestamp;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.timisencotech.projectmanagementapis.dto.ProjectStatusDetails;
import ca.timisencotech.projectmanagementapis.dto.ProjectSupervisorsDetails;
import ca.timisencotech.projectmanagementapis.repository.ProjectStatusRepo;
import ca.timisencotech.projectmanagementapis.repository.ProjectSupervisorsRepo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectStatusRepositoryTest {
		 
		@Autowired
		ProjectStatusRepo projectStatusRepo;
		
		
		@Autowired
		ProjectSupervisorsRepo projectSupervisorsRepo;

		  @Test
		  public void saveTest() {
			  
			  ProjectSupervisorsDetails findProjectSupervisorsDetails =projectSupervisorsRepo.findProjectSupervisorByProjectAndSupervisorName("Sherwood Project","userAEmail@gmail.com");
				
			  Date date= new Date();
				
				
				
				ProjectStatusDetails projectStatusDetails = new ProjectStatusDetails();
				
				Timestamp completedDate = new Timestamp(date.getTime());
				projectStatusDetails.setCompletedDate(completedDate);
				
				projectStatusDetails.setDescription("dfdssvsdv");
				
				projectStatusDetails.setDonePercentage(45.45);
				
				
				Timestamp updatedDate = new Timestamp(date.getTime());
				projectStatusDetails.setUpdatedDate(updatedDate);
				
				projectStatusDetails.setProjectSupervisorsDetails(findProjectSupervisorsDetails);
					
			
	
			  
				projectStatusRepo.save(projectStatusDetails);
				assertNotNull(projectStatusRepo.findProjectStatusDetails("Sherwood Project","userAEmail@gmail.com"));
		  }
		  
		  
		  @Test
		  public void findProjectSupervisorByProjectAndSupervisorNameTest() {
			  
			
				assertNotNull(projectStatusRepo.findProjectStatusDetails("Sherwood Project","userAEmail@gmail.com"));
				  }
	
	}




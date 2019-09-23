package ca.timisencotech.projectmanagementapis.repositoryTest;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.timisencotech.projectmanagementapis.dto.ProjectSupervisorsDetails;
import ca.timisencotech.projectmanagementapis.dto.SupervisorTasksDetails;
import ca.timisencotech.projectmanagementapis.dto.TaskDetails;
import ca.timisencotech.projectmanagementapis.repository.ProjectSupervisorsRepo;
import ca.timisencotech.projectmanagementapis.repository.SupervisorTasksRepo;
import ca.timisencotech.projectmanagementapis.repository.TaskRepo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SupervisorTasksRepositoryTest {
		 
	@Autowired
	ProjectSupervisorsRepo projectSupervisorsRepo;
	
	@Autowired
	TaskRepo taskRepo;
	
		
		@Autowired
		SupervisorTasksRepo supervisorTasksRepo;

		  @Test
		  public void saveTest() {
			  
			  ProjectSupervisorsDetails findProjectSupervisorsDetails = projectSupervisorsRepo.findProjectSupervisorByProjectAndSupervisorName("Sherwood Project","userAEmail@gmail.com");
				
				TaskDetails findTaskDetails = taskRepo.findByTaskNameAndProjectName("Sherwood Project","Sub Task3");
				
				SupervisorTasksDetails supervisorTasksDetails = new  SupervisorTasksDetails();
				
				supervisorTasksDetails.setProjectSupervisorsDetails(findProjectSupervisorsDetails);
				supervisorTasksDetails.setTaskDetails(findTaskDetails);
				
				supervisorTasksRepo.save(supervisorTasksDetails);
				assertNotNull(supervisorTasksRepo.findSupervisorsByProjectnameAndSupervisorNameAndTaskName("Sherwood Project", "userAEmail@gmail.com", "Sub Task3"));
		  }
		  
		  
		  @Test
		  public void findProjectSupervisorByProjectAndSupervisorNameTest() {
			  
				assertNotNull(supervisorTasksRepo.findSupervisorsByProjectnameAndSupervisorNameAndTaskName("Sherwood Project", "userAEmail@gmail.com", "Sub Task3"));
				    }
	
	}




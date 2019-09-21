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
import ca.timisencotech.projectmanagementapis.repository.ProjectSupervisorsRepository;
import ca.timisencotech.projectmanagementapis.repository.SupervisorTasksRepository;
import ca.timisencotech.projectmanagementapis.repository.TaskRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SupervisorTasksRepositoryTest {
		 
	@Autowired
	ProjectSupervisorsRepository projectSupervisorsRepository;
	
	@Autowired
	TaskRepository taskRepository;
	
		
		@Autowired
		SupervisorTasksRepository supervisorTasksRepository;

		  @Test
		  public void saveTest() {
			  
			  ProjectSupervisorsDetails findProjectSupervisorsDetails = projectSupervisorsRepository.findProjectSupervisorByProjectAndSupervisorName("Sherwood Project","userAEmail@gmail.com");
				
				TaskDetails findTaskDetails = taskRepository.findByTaskNameAndProjectName("Sherwood Project","Sub Task3");
				
				SupervisorTasksDetails supervisorTasksDetails = new  SupervisorTasksDetails();
				
				supervisorTasksDetails.setProjectSupervisorsDetails(findProjectSupervisorsDetails);
				supervisorTasksDetails.setTaskDetails(findTaskDetails);
				
				supervisorTasksRepository.save(supervisorTasksDetails);
				assertNotNull(supervisorTasksRepository.findSupervisorsByProjectnameAndSupervisorNameAndTaskName("Sherwood Project", "userAEmail@gmail.com", "Sub Task3"));
		  }
		  
		  
		  @Test
		  public void findProjectSupervisorByProjectAndSupervisorNameTest() {
			  
				assertNotNull(supervisorTasksRepository.findSupervisorsByProjectnameAndSupervisorNameAndTaskName("Sherwood Project", "userAEmail@gmail.com", "Sub Task3"));
				    }
	
	}




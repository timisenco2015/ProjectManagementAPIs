package ca.timisencotech.projectmanagementapis.dtoTest;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.timisencotech.projectmanagementapis.dto.ProjectSupervisorsDetails;
import ca.timisencotech.projectmanagementapis.dto.SupervisorTasksDetails;
import ca.timisencotech.projectmanagementapis.dto.TaskDetails;
import ca.timisencotech.projectmanagementapis.repository.ProjectSupervisorsRepo;
import ca.timisencotech.projectmanagementapis.repository.TaskRepo;





@RunWith(SpringRunner.class)
@SpringBootTest
public class SupervisorTasksDetailsTest 
{
	@Autowired
	ProjectSupervisorsRepo projectSupervisorsRepo;
	
	@Autowired
	TaskRepo taskRepo;
	
	@Test
	public void testSettersGetters() 
	{

		ProjectSupervisorsDetails findProjectSupervisorsDetails = projectSupervisorsRepo.findProjectSupervisorByProjectAndSupervisorName("Sherwood Project","userAEmail@gmail.com");
		
		TaskDetails findTaskDetails = taskRepo.findByTaskNameAndProjectName("Sherwood Project","Sub Task2");
		
		SupervisorTasksDetails supervisorTasksDetails = new  SupervisorTasksDetails();
		
		supervisorTasksDetails.setProjectSupervisorsDetails(findProjectSupervisorsDetails);
		supervisorTasksDetails.setTaskDetails(findTaskDetails);
		
		
		assertEquals(findTaskDetails,supervisorTasksDetails.getProjectSupervisorsDetails());
		assertEquals(findProjectSupervisorsDetails,supervisorTasksDetails.getTaskDetails());
		
		
	}

}

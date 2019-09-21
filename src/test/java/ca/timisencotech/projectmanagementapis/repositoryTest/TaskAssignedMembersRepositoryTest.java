package ca.timisencotech.projectmanagementapis.repositoryTest;

import static org.junit.Assert.assertNotNull;

import java.sql.Timestamp;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.timisencotech.projectmanagementapis.dto.ProjectGroupMemberDetails;
import ca.timisencotech.projectmanagementapis.dto.SupervisorTasksDetails;
import ca.timisencotech.projectmanagementapis.dto.TaskAssignedMembersDetails;
import ca.timisencotech.projectmanagementapis.repository.ProjectGroupMemberRepo;
import ca.timisencotech.projectmanagementapis.repository.SupervisorTasksRepository;
import ca.timisencotech.projectmanagementapis.repository.TaskAssignedMemberRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskAssignedMembersRepositoryTest {
		 
	@Autowired
	SupervisorTasksRepository supervisorTasksRepo;
	
	@Autowired
	ProjectGroupMemberRepo projectGroupMemberRepo;
		
	@Autowired
	TaskAssignedMemberRepository TaskAssignedMemberRepo;

		  @Test
		  public void saveTest() {
			 SupervisorTasksDetails findSupervisorTasksDetails = supervisorTasksRepo.findSupervisorsByProjectnameAndSupervisorNameAndTaskName("Sherwood Project", "userAEmail@gmail.com", "Sub Task2");
				
				ProjectGroupMemberDetails findProjectGroupMemberDetails = projectGroupMemberRepo.findProjectMemberByProjectname("Sherwood Project","userABEmail@gmail.com");
				
				
				TaskAssignedMembersDetails taskAssignedMembersDetails = new TaskAssignedMembersDetails();
				
				//check setter and getter for date assigned
				Date date= new Date();
				Timestamp dateAssigned = new Timestamp(date.getTime());				
				taskAssignedMembersDetails.setDateAssigned(dateAssigned);
				
				taskAssignedMembersDetails.setDescription("sdgdsvsvsvcs");
				taskAssignedMembersDetails.setIsActive(true);
				taskAssignedMembersDetails.setProjectGroupMemberDetails(findProjectGroupMemberDetails);
				taskAssignedMembersDetails.setSupervisorTasksDetails(findSupervisorTasksDetails);
				
			//	TaskAssignedMemberRepo.save(taskAssignedMembersDetails);
			 assertNotNull(TaskAssignedMemberRepo.findTaskAssignedMember("Sherwood Project", "userABEmail@gmail.com", "Sub Task2"));
		  }
		  
		  
		  @Test
		  public void findProjectDetailsByProjectNameTest() {
			  
			 assertNotNull(TaskAssignedMemberRepo.findTaskAssignedMember("Sherwood Project", "userABEmail@gmail.com", "Sub Task2"));
		  }
		  
		 
		  
		
	
	}




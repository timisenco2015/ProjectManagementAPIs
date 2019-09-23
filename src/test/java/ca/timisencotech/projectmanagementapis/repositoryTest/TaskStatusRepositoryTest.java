package ca.timisencotech.projectmanagementapis.repositoryTest;

import static org.junit.Assert.assertNotNull;
import java.sql.Timestamp;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.timisencotech.projectmanagementapis.dto.TaskAssignedMembersDetails;
import ca.timisencotech.projectmanagementapis.dto.TaskStatusDetails;
import ca.timisencotech.projectmanagementapis.repository.TaskAssignedMemberRepo;
import ca.timisencotech.projectmanagementapis.repository.TaskStatusRepo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskStatusRepositoryTest {
		 
	@Autowired
	TaskAssignedMemberRepo taskAssignedMemberRepo;
	
	@Autowired
	TaskStatusRepo taskStatusRepo;
		
	
		  @Test
		  public void saveTest() {
			  
			  TaskStatusDetails taskStatusDetails = new TaskStatusDetails();
				Date date= new Date();
				
				
				TaskAssignedMembersDetails findTaskAssignedMembersDetails =  taskAssignedMemberRepo.findTaskAssignedMember("Sherwood Project","userHEmail@gmail.com","Sub Task1");
			
				Timestamp completedDate = new Timestamp(date.getTime());
				taskStatusDetails.setCompletedDate(completedDate);
				
				taskStatusDetails.setDescription("dfghjk");
				
				taskStatusDetails.setDonePercentage(30.28);
				
				Timestamp updatedDate = new Timestamp(date.getTime());
				taskStatusDetails.setUpdatedDate(updatedDate);
				
				taskStatusDetails.setTaskAssignedMembersDetails(findTaskAssignedMembersDetails);
				
				taskStatusRepo.save(taskStatusDetails);
				assertNotNull(taskStatusRepo.findTaskStatusDetails("Sherwood Project","userACEmail@gmail.com"));
		  }
		  
		  
		  @Test
		  public void findProjectSupervisorByProjectAndSupervisorNameTest() {
			  
			
				assertNotNull(taskStatusRepo.findTaskStatusDetails("Sherwood Project","userACEmail@gmail.com"));
				  }
	
	}




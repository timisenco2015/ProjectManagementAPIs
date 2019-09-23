package ca.timisencotech.projectmanagementapis.dtoTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
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
import ca.timisencotech.projectmanagementapis.repository.SupervisorTasksRepo;




@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskAssignedMembersDetailsTest 
{
	@Autowired
	SupervisorTasksRepo supervisorTasksRepo;
	
	@Autowired
	ProjectGroupMemberRepo projectGroupMemberRepo;
	
	@Test
	public void testSettersGetters() 
	{
		
		SupervisorTasksDetails findSupervisorTasksDetails = supervisorTasksRepo.findSupervisorsByProjectnameAndSupervisorNameAndTaskName("Sherwood Project", "userAEmail@gmail.com", "Sub Task1");
		
		ProjectGroupMemberDetails findProjectGroupMemberDetails = projectGroupMemberRepo.findProjectMemberByProjectname("Sherwood Project","userACEmail@gmail.com");
		
		TaskAssignedMembersDetails taskAssignedMembersDetails = new TaskAssignedMembersDetails();
		
		//check setter and getter for date assigned
		Date date= new Date();
		Timestamp dateAssigned = new Timestamp(date.getTime());				
		taskAssignedMembersDetails.setDateAssigned(dateAssigned);
		
		taskAssignedMembersDetails.setDescription("sdgdsvsvsvcs");
		String testResult1 = "sdgdsvsvsvcs";
		assertEquals(testResult1,taskAssignedMembersDetails.getDescription());
		
		//check setter and getter for activities update
		taskAssignedMembersDetails.setIsActive(true);
		assertTrue(taskAssignedMembersDetails.getIsActive());
				
		
		taskAssignedMembersDetails.setProjectGroupMemberDetails(findProjectGroupMemberDetails);
		assertEquals(findProjectGroupMemberDetails,taskAssignedMembersDetails.getProjectGroupMemberDetails());
		
		
		
		taskAssignedMembersDetails.setSupervisorTasksDetails(findSupervisorTasksDetails);
		assertEquals(findSupervisorTasksDetails,taskAssignedMembersDetails.getSupervisorTasksDetails());
		
		
		
		assertEquals(testResult1,taskAssignedMembersDetails.getDescription());
		assertTrue(taskAssignedMembersDetails.getIsActive());
		assertEquals(findProjectGroupMemberDetails,taskAssignedMembersDetails.getProjectGroupMemberDetails());
		assertEquals(findSupervisorTasksDetails,taskAssignedMembersDetails.getSupervisorTasksDetails());
		
	}

}

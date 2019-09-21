package ca.timisencotech.projectmanagementapis.domainTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.sql.Timestamp;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.timisencotech.projectmanagementapis.domain.TaskAssignedMembers;




@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskAssignedMembersTest 
{
	@Test
	public void testSettersGetters() 
	{
		TaskAssignedMembers taskAssignedMembers = new TaskAssignedMembers();

		//check setter and getter for activities update
		taskAssignedMembers.setActive(true);
		assertTrue(taskAssignedMembers.getIsActive());
		
		//check setter and getter for supervisor that assigned the task
		taskAssignedMembers.setAssignedBy("userAEmail@gmail.com");
		String testResult1 = "userAEmail@gmail.com";
		assertEquals(testResult1,taskAssignedMembers.getAssignedBy());
			
		//check setter and getter for member the task was assigned to
		taskAssignedMembers.setAssignedTo("userACEmail@gmail.com");
		String testResult2 = "userACEmail@gmail.com";
		assertEquals(testResult2,taskAssignedMembers.getAssignedTo());
		
		//check setter and getter for date assigned
		 Date date= new Date();
		Timestamp dateAssigned = new Timestamp(date.getTime());
		taskAssignedMembers.setDateAssigned(dateAssigned);;
		assertEquals(dateAssigned,taskAssignedMembers.getDateAssigned());
		
		
		//check setter and getter for description
		taskAssignedMembers.setDescription("sdgdsvsvsvcs");
		String testResult4 = "sdgdsvsvsvcs";
		 assertEquals(testResult4,taskAssignedMembers.getDescription());
			
			//check setter and getter for project name
		 taskAssignedMembers.setProjectName("Sherwood Project");
		String testResult5 = "Sherwood Project";
		assertEquals(testResult5,taskAssignedMembers.getProjectName());
		
		//check setter and getter for task name
		 taskAssignedMembers.setTaskName("Sub Task1");
		String testResult6 = "Sub Task1";
		assertEquals(testResult6,taskAssignedMembers.getTaskName());
		


		assertTrue(taskAssignedMembers.getIsActive());
		assertEquals(testResult1,taskAssignedMembers.getAssignedBy());
		assertEquals(testResult2,taskAssignedMembers.getAssignedTo());
		assertEquals(dateAssigned,taskAssignedMembers.getDateAssigned());
		assertEquals(testResult4,taskAssignedMembers.getDescription());
		assertEquals(testResult5,taskAssignedMembers.getProjectName());	
		assertEquals(testResult6,taskAssignedMembers.getTaskName());
	}

}

package ca.timisencotech.projectmanagementapis.dtoTest;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.timisencotech.projectmanagementapis.dto.TaskAssignedMembersDetails;
import ca.timisencotech.projectmanagementapis.dto.TaskStatusDetails;
import ca.timisencotech.projectmanagementapis.repository.TaskAssignedMemberRepository;





@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskStatusDetailsTest 
{
	@Autowired
	TaskAssignedMemberRepository taskAssignedMemberRepository;
	

	
	@Test
	public void testSettersGetters() 
	{
		TaskStatusDetails taskStatusDetails = new TaskStatusDetails();
		Date date= new Date();
		
		
		TaskAssignedMembersDetails findTaskAssignedMembersDetails =  taskAssignedMemberRepository.findTaskAssignedMember("Sherwood Project","userACEmail@gmail.com","Sub Task1");
		
		
		
		//List<TaskStatusDetails> findTaskStatusDetails(String projectName,String memberName);

		//check setter and getter for completed by
		Timestamp completedDate = new Timestamp(date.getTime());
		taskStatusDetails.setCompletedDate(completedDate);
		assertEquals(completedDate,taskStatusDetails.getCompletedDate());
		
		//check setter and getter for description
		taskStatusDetails.setDescription("dfghjk");
		String	testResult1 = "dfghjk";
		assertEquals(testResult1,taskStatusDetails.getDescription());
				
		//check setter and getter for done percentage
		taskStatusDetails.setDonePercentage(40.28);
		double	testResult2 = 40.28;
		assertEquals(testResult2,taskStatusDetails.getDonePercentage(),0.00);
		
	
		//check setter and getter for completed date
		Timestamp updatedDate = new Timestamp(date.getTime());
		taskStatusDetails.setUpdatedDate(updatedDate);
		assertEquals(updatedDate,taskStatusDetails.getUpdatedDate());
		
		
		//check setter and getter for task assigned members
		taskStatusDetails.setTaskAssignedMembersDetails(findTaskAssignedMembersDetails);
		assertEquals(findTaskAssignedMembersDetails,taskStatusDetails.getTaskAssignedMembersDetails());
		
		
		assertEquals(completedDate,taskStatusDetails.getCompletedDate());
		assertEquals("dfghjk",taskStatusDetails.getDescription());
		assertEquals(40.28,taskStatusDetails.getDonePercentage(),0.00);
		assertEquals(updatedDate,taskStatusDetails.getUpdatedDate());
		assertEquals(findTaskAssignedMembersDetails,taskStatusDetails.getTaskAssignedMembersDetails());
		
		
		
	}

}

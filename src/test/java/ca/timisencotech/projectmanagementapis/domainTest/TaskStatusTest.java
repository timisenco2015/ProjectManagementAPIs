package ca.timisencotech.projectmanagementapis.domainTest;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.timisencotech.projectmanagementapis.domain.TaskStatus;





@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskStatusTest 
{
	@Test
	public void testSettersGetters() 
	{
		TaskStatus taskStatus = new TaskStatus();
		Date date= new Date();

		//check setter and getter for completed by
		Timestamp completedDate = new Timestamp(date.getTime());
		taskStatus.setCompletedDate(completedDate);
		assertEquals(completedDate,taskStatus.getCompletedDate());
		
		//check setter and getter for description
		taskStatus.setDescription("dfghjk");
		String	testResult1 = "dfghjk";
		assertEquals(testResult1,taskStatus.getDescription());
				
		//check setter and getter for done percentage
		taskStatus.setDonePercentage(40.28);
		double	testResult2 = 40.28;
		assertEquals(testResult2,taskStatus.getDonePercentage(),0.00);
		
		//check setter and getter for project name
		taskStatus.setProjectName("Sherwood Project");
		testResult1 = "Sherwood Project";
		assertEquals(testResult1,taskStatus.getProjectName());
		
		//check setter and getter for completed date
		Timestamp updatedDate = new Timestamp(date.getTime());
		taskStatus.setUpdatedDate(updatedDate);
		assertEquals(updatedDate,taskStatus.getUpdatedDate());
		
		//check setter and getter for task name
		taskStatus.setTaskName("Sub Task1");
		testResult1 ="Sub Task1";
		assertEquals(testResult1,taskStatus.getTaskName());
		
		
		
		//check setter and getter for member name
				taskStatus.setMemberName("userACEmail@gmail.com");
				testResult1 ="userACEmail@gmail.com";
				assertEquals(testResult1,taskStatus.getMemberName());
		
		
		assertEquals(completedDate,taskStatus.getCompletedDate());
		assertEquals("dfghjk",taskStatus.getDescription());
		assertEquals(40.28,taskStatus.getDonePercentage(),0.00);
		assertEquals("Sherwood Project",taskStatus.getProjectName());
		assertEquals(updatedDate,taskStatus.getUpdatedDate());
		assertEquals("Sub Task1",taskStatus.getTaskName());
		assertEquals("userACEmail@gmail.com",taskStatus.getMemberName());	
		
	}

}

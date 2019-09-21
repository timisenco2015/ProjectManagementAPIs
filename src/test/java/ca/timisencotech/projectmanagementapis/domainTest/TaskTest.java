package ca.timisencotech.projectmanagementapis.domainTest;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.timisencotech.projectmanagementapis.domain.Task;





@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskTest 
{
	@Test
	public void testSettersGetters() 
	{
		Task task = new Task();
		
		
	
		//check setter and getter for first name
		task.setProjectName("Edmonton Project");
		String testResult1 = "Edmonton Project";
		assertEquals(testResult1,task.getProjectName());
		
		//check setter and getter for created date
		Date date= new Date();
		Timestamp loginTime = new Timestamp(date.getTime());
		task.setCreatedDate(loginTime);
		assertEquals(loginTime, task.getCreatedDate());
		
		//check setter and getter for start date
	
		 loginTime = new Timestamp(date.getTime());
		 task.setStartDate(loginTime);
		assertEquals(loginTime, task.getStartDate());
		
		//check setter and getter for end date
		 loginTime = new Timestamp(date.getTime());
		 task.setEndDate(loginTime);
		assertEquals(loginTime, task.getEndDate());
		
		//check setter and getter for created by
		testResult1 = "userEmail@gmail.com";
		task.setCreatedBy("userEmail@gmail.com");
		assertEquals(testResult1, task.getCreatedBy());
		
		//check setter and getter for description
		task.setDescription("dfdsdsgdsgds");
		testResult1 = "dfdsdsgdsgds";
		assertEquals(testResult1, task.getDescription());
		
		//check setter and getter for task name
				task.setTaskName("Sub Task1");
				testResult1 = "Sub Task1";
				assertEquals(testResult1, task.getDescription());
				
		
	


		assertEquals("Edmonton Project",task.getProjectName());
		assertEquals(loginTime, task.getCreatedDate());
		assertEquals(loginTime, task.getStartDate());
		assertEquals(loginTime, task.getEndDate());
		assertEquals("userEmail@gmail.com", task.getCreatedBy());
		assertEquals("dfdsdsgdsgds",  task.getDescription());
		assertEquals("Sub Task1",  task.getTaskName());
		
		
	}

}

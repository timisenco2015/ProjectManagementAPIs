package ca.timisencotech.projectmanagementapis.domainTest;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.timisencotech.projectmanagementapis.domain.SupervisorTasks;





@RunWith(SpringRunner.class)
@SpringBootTest
public class SupervisorTasksTest 
{
	@Test
	public void testSettersGetters() 
	{

		SupervisorTasks supervisorTasks = new  SupervisorTasks();
		
		//check setter and getter for description
		supervisorTasks.setProjectName("Sherwood Project");
		String	testResult1 = "Sherwood Project";
		assertEquals(testResult1,supervisorTasks.getProjectName());
				
		//check setter and getter for done percentage
		supervisorTasks.setSupervisorName("userAEmail@gmail.com");
		String	testResult2 = "userAEmail@gmail.com";
		assertEquals(testResult2,supervisorTasks.getSupervisorName());
		
		//check setter and getter for project name
		supervisorTasks.setTaskName("Sub Task2");
		String testResult3 = "Sub Task2";
		assertEquals(testResult3,supervisorTasks.getTaskName());
		
		
		
		assertEquals(testResult1,supervisorTasks.getProjectName());
		assertEquals(testResult2,supervisorTasks.getSupervisorName());
		assertEquals(testResult3,supervisorTasks.getTaskName());
		
		
	}

}

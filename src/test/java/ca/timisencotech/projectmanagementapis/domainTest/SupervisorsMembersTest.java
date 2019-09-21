package ca.timisencotech.projectmanagementapis.domainTest;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.timisencotech.projectmanagementapis.domain.SupervisorsMembers;





@RunWith(SpringRunner.class)
@SpringBootTest
public class SupervisorsMembersTest 
{
	@Test
	public void testSettersGetters() 
	{

		SupervisorsMembers supervisorsMembers = new  SupervisorsMembers();
		
		//check setter and getter for description
		
		
		
		supervisorsMembers.setMemberName("userACAFEmail@gmail.com");
		String	testResult1 = "userACAFEmail@gmail.com";
		assertEquals(testResult1,supervisorsMembers.getMemberName());
				
		//check setter and getter for done percentage
		supervisorsMembers.setProjectName("Winnipeg Project");
		String	testResult2 = "Winnipeg Project";
		assertEquals(testResult2,supervisorsMembers.getProjectName());
		
		//check setter and getter for project name
		supervisorsMembers.setSupervisorName("userEmail@gmail.com");
		String testResult3 = "userEmail@gmail.com";
		assertEquals(testResult3,supervisorsMembers.getSupervisorName());
		
		
		
		assertEquals(testResult1,supervisorsMembers.getSupervisorName());
		assertEquals(testResult2,supervisorsMembers.getProjectName());
		assertEquals(testResult3,supervisorsMembers.getSupervisorName());
		
		
	}

}

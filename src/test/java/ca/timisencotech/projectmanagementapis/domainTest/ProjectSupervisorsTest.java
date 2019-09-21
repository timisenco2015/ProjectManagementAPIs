package ca.timisencotech.projectmanagementapis.domainTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.timisencotech.projectmanagementapis.domain.ProjectSupervisors;





@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectSupervisorsTest 
{
	@Test
	public void testSettersGetters() 
	{
		//check setter and getter for isActive
		ProjectSupervisors projectSupervisors = new ProjectSupervisors();
		projectSupervisors.setIsActive(true);
		assertTrue(projectSupervisors.getIsActive());
		
		//check setter and getter for project name
		String	testResult1 = "Sherwood Project";
		projectSupervisors.setProjectName("Sherwood Project");
		assertEquals(testResult1,projectSupervisors.getProjectName());
		
		//check setter and getter for supervisor name
		testResult1 = "userEmail@gmail.com";
		projectSupervisors.setSupervisorName("userEmail@gmail.com");
		assertEquals(testResult1,projectSupervisors.getSupervisorName());
		
	
		assertTrue(projectSupervisors.getIsActive());
		assertEquals("Sherwood Project",projectSupervisors.getProjectName());
		assertEquals("userEmail@gmail.com",projectSupervisors.getSupervisorName());
			
		
	}

}

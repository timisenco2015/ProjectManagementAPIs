package ca.timisencotech.projectmanagementapis.domainTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.timisencotech.projectmanagementapis.domain.ProjectSupervisorsDetail;





@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectSupervisorsDetailTest 
{
	@Test
	public void testSettersGetters() 
	{
		//check setter and getter for isActive
		ProjectSupervisorsDetail projectSupervisorsDetail = new ProjectSupervisorsDetail();
		projectSupervisorsDetail.setIsActive(true);
		assertTrue(projectSupervisorsDetail.getIsActive());
		
		//check setter and getter for project name
		String	testResult1 = "Sherwood Project";
		projectSupervisorsDetail.setProjectName("Sherwood Project");
		assertEquals(testResult1,projectSupervisorsDetail.getProjectName());
		
		//check setter and getter for supervisor name
		testResult1 = "userEmail@gmail.com";
		projectSupervisorsDetail.setSupervisorName("userEmail@gmail.com");
		assertEquals(testResult1,projectSupervisorsDetail.getSupervisorName());
		
	
		assertTrue(projectSupervisorsDetail.getIsActive());
		assertEquals("Sherwood Project",projectSupervisorsDetail.getProjectName());
		assertEquals("userEmail@gmail.com",projectSupervisorsDetail.getSupervisorName());
			
		
	}

}

package ca.timisencotech.projectmanagementapis.domainTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.timisencotech.projectmanagementapis.domain.ProjectGroupMembers;




@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectGroupMembersTest 
{
	@Test
	public void testSettersGetters() 
	{
		ProjectGroupMembers projectGroupMembers = new ProjectGroupMembers();
		
		
	
		
		//check setter and getter for activities update
		projectGroupMembers.setActivitiesUpdate("ddasdsvdvdsvsv");
		String testResult1 ="ddasdsvdvdsvsv";
		assertEquals(testResult1,projectGroupMembers.getActivitiesUpdate());
		
		//check setter and getter for isActive
		projectGroupMembers.setIsActive(true);
		assertTrue(projectGroupMembers.getIsActive());
				
		//check setter and getter for group name
		projectGroupMembers.setGroupName("Group1");
		String testResult2 = "Group1";
		assertEquals(testResult1,projectGroupMembers.getGroupName());
		
		//check setter and getter for group name
		projectGroupMembers.setMemberName("userHEmail@gmail.com");
		String testResult3 = "userHEmail@gmail.com";
		assertEquals(testResult1,projectGroupMembers.getMemberName());
		
		
		//check setter and getter for project name
		projectGroupMembers.setProjectName("Sherwood Project");
		String testResult4 = "Sherwood Project";
		 assertEquals(testResult1,projectGroupMembers.getProjectName());
			
		


		 assertEquals(testResult1,projectGroupMembers.getActivitiesUpdate());
		 assertTrue(projectGroupMembers.getIsActive());
		 assertEquals(testResult2,projectGroupMembers.getGroupName());
		 assertEquals(testResult3,projectGroupMembers.getMemberName());
		 assertEquals(testResult4,projectGroupMembers.getProjectName());
			
		
	}

}

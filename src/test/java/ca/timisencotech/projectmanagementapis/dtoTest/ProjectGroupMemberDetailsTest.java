package ca.timisencotech.projectmanagementapis.dtoTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.timisencotech.projectmanagementapis.dto.ProjectGroupDetails;
import ca.timisencotech.projectmanagementapis.dto.ProjectGroupMemberDetails;
import ca.timisencotech.projectmanagementapis.dto.UserSignUpDetails;
import ca.timisencotech.projectmanagementapis.repository.ProjectGroupRepository;
import ca.timisencotech.projectmanagementapis.repository.UserSignUpRepository;




@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectGroupMemberDetailsTest 
{
	
	@Autowired
	ProjectGroupRepository projectGroupRepository;
	
	
	@Autowired
	UserSignUpRepository userSignUpRepository;
	
	
	@Test
	public void testSettersGetters() 
	{
		 ProjectGroupMemberDetails  projectGroupMemberDetails = new  ProjectGroupMemberDetails();
		
		
		ProjectGroupDetails findProjectGroupDetails = projectGroupRepository.findProjectGroupDetailsByGroupName("Sherwood Project","Group 3");
		UserSignUpDetails findUserSignUpDetails = userSignUpRepository.findUserSignUpDetailsByEmail("userBEmail@gmail.com");

		//check setter and getter for activities update
		
		projectGroupMemberDetails.setActivitiesUpdate("ddasdsvdvdsvsv");
		String testResult1 ="ddasdsvdvdsvsv";
		assertEquals(testResult1,projectGroupMemberDetails.getActivitiesUpdate());
		
		//check setter and getter for isActive
		projectGroupMemberDetails.setIsActive(true);
		assertTrue(projectGroupMemberDetails.getIsActive());
				
		//check setter and getter for UserSignUpDetails
		projectGroupMemberDetails.setUserSignUpDetails(findUserSignUpDetails);
		assertEquals(findUserSignUpDetails,projectGroupMemberDetails.getUserSignUpDetails());
		
		//check setter and getter for ProjectGroupDetails
		projectGroupMemberDetails.setProjectGroupDetails(findProjectGroupDetails);
		assertEquals(findProjectGroupDetails,projectGroupMemberDetails.getProjectGroupDetails());
		
		
		
		


		assertEquals(testResult1,projectGroupMemberDetails.getActivitiesUpdate());
		assertTrue(projectGroupMemberDetails.getIsActive());
		assertEquals(findUserSignUpDetails,projectGroupMemberDetails.getUserSignUpDetails());
		assertEquals(findProjectGroupDetails,projectGroupMemberDetails.getProjectGroupDetails());
		 
	}

}

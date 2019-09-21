package ca.timisencotech.projectmanagementapis.dtoTest;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.timisencotech.projectmanagementapis.dto.ProjectGroupMemberDetails;
import ca.timisencotech.projectmanagementapis.dto.ProjectSupervisorsDetails;
import ca.timisencotech.projectmanagementapis.dto.SupervisorsMembersDetails;
import ca.timisencotech.projectmanagementapis.repository.ProjectGroupMemberRepo;
import ca.timisencotech.projectmanagementapis.repository.ProjectSupervisorsRepository;





@RunWith(SpringRunner.class)
@SpringBootTest
public class SupervisorsMembersDetailsTest 
{
	@Autowired
	ProjectSupervisorsRepository projectSupervisorsRepository;
	
	@Autowired
	ProjectGroupMemberRepo projectGroupMemberRepo;
	
	@Test
	public void testSettersGetters() 
	{

		SupervisorsMembersDetails supervisorsMembersDetails = new  SupervisorsMembersDetails();
		
		ProjectSupervisorsDetails findProjectSupervisorsDetails =  projectSupervisorsRepository.findProjectSupervisorByProjectAndSupervisorName("Winnipeg Project","userEmail@gmail.com");
		ProjectGroupMemberDetails findProjectGroupMemberDetails =  projectGroupMemberRepo.findProjectMemberByProjectname("Winnipeg Project","userACAFEmail@gmail.com");
		
		
		
		//check setter and getter for description
		
		
		
		supervisorsMembersDetails.setProjectGroupMemberDetails(findProjectGroupMemberDetails);
		assertEquals(findProjectGroupMemberDetails,supervisorsMembersDetails.getProjectGroupMemberDetails());
				
		//check setter and getter for done percentage
		supervisorsMembersDetails.setProjectSupervisorsDetails(findProjectSupervisorsDetails);
		assertEquals(findProjectSupervisorsDetails,supervisorsMembersDetails.getProjectSupervisorsDetails());
		
		
		
		
		assertEquals(findProjectSupervisorsDetails,supervisorsMembersDetails.getProjectSupervisorsDetails());
		assertEquals(findProjectGroupMemberDetails,supervisorsMembersDetails.getProjectGroupMemberDetails());
		
	}

}

package ca.timisencotech.projectmanagementapis.daoTest;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.timisencotech.projectmanagementapis.dao.implementation.SupervisorsMembersDAOImp;
import ca.timisencotech.projectmanagementapis.domain.SupervisorsMembers;
import ca.timisencotech.projectmanagementapis.exception.ApiError;
import ca.timisencotech.projectmanagementapis.repository.SupervisorsMembersRepository;
import ca.timisencotech.projectmanagementapis.validation.Container;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SupervisorsMembersDAOImpTest<T> {
	
	
	 @Autowired
	 SupervisorsMembersDAOImp supervisorsMembersDAOImp;
	 
	 @Autowired
	 SupervisorsMembersRepository supervisorsMembersRepository;
 
	
	
	
	
	
	 
	 
	 @Test
	 public void addSupervisorMemberServiceTest() 
	 {

		 SupervisorsMembers supervisorsMembers = new SupervisorsMembers();
			supervisorsMembers.setMemberName("userACAFEmail@gmail.com");
			supervisorsMembers.setProjectName("Winnipeg Project");
			supervisorsMembers.setSupervisorName("userEmail@gmail.com");
			
		
		 Container<T> supervisorsMembersContainer = supervisorsMembersDAOImp.addSupervisorMember(supervisorsMembers);
		String typeOfObject = supervisorsMembersContainer.getObjectType();
		
		if(typeOfObject.equalsIgnoreCase("Class Object"))
		{
		 
			SupervisorsMembers resultSupervisorsMembers=(SupervisorsMembers)supervisorsMembersContainer.getObject();
			assertEquals("userACAFEmail@gmail.com", resultSupervisorsMembers.getMemberName());
			assertEquals("userEmail@gmail.com", resultSupervisorsMembers.getSupervisorName());
			assertEquals("Winnipeg Project", resultSupervisorsMembers.getProjectName());
		
		}
		
		
		// checks for unique constraints
		
		 supervisorsMembers = new SupervisorsMembers();
			supervisorsMembers.setMemberName("userACAFEmail@gmail.com");
			supervisorsMembers.setProjectName("Winnipeg Project");
			supervisorsMembers.setSupervisorName("userEmail@gmail.com");
			
		
			supervisorsMembersContainer = supervisorsMembersDAOImp.addSupervisorMember(supervisorsMembers);
		typeOfObject = supervisorsMembersContainer.getObjectType();
		
		if (typeOfObject.equalsIgnoreCase("Error Object"))
			{
				ApiError apiError = (ApiError)supervisorsMembersContainer.getObject();
				assertEquals("Persistence Error", apiError.getStatus());
			}
			
			
		
	 }




	 
	 
}

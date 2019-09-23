package ca.timisencotech.projectmanagementapis.daoTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.timisencotech.projectmanagementapis.dao.implementation.ProjectSupervisorsDAOImp;
import ca.timisencotech.projectmanagementapis.domain.ProjectSupervisors;
import ca.timisencotech.projectmanagementapis.exception.ApiError;
import ca.timisencotech.projectmanagementapis.validation.Container;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectSupervisorsDAOImpTest<T> {
	
	
	 @Autowired
	 ProjectSupervisorsDAOImp projectSupervisorsDAOImp;
	 
 
		
	
	 
	 
	 @Test 
	 public void addProjectSupervisorsDetailsTest() 
	 {

	
		
		 ProjectSupervisors projectSupervisors = new ProjectSupervisors();
			projectSupervisors.setIsActive(true);
			projectSupervisors.setProjectName("Winnipeg Project");
			projectSupervisors.setSupervisorName("userACAFEmail@gmail.com");
			
			


		 Container<T>projectSupervisorsContainer = projectSupervisorsDAOImp.addProjectSupervisors(projectSupervisors);
		String typeOfObject = projectSupervisorsContainer.getObjectType();
		
		if(typeOfObject.equalsIgnoreCase("Class Object"))
		{
		 
			 ProjectSupervisors resultProjectSupervisors=	(ProjectSupervisors)projectSupervisorsContainer.getObject();
		 assertTrue(projectSupervisors.getIsActive());
		 assertEquals("Winnipeg Project",resultProjectSupervisors.getProjectName());
		 assertEquals("userACAFEmail@gmail.com", resultProjectSupervisors.getSupervisorName());
		}
		else if(typeOfObject.equalsIgnoreCase("Error Object"))
		{
			 
			
			
			ApiError apiError = (ApiError)projectSupervisorsContainer.getObject();
			assertEquals("Constraint error", apiError.getMessage());
		}
		
		
	 }

	 
	 
	
}

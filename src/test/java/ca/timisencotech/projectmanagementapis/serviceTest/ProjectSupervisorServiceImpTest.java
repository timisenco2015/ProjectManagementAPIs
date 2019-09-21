package ca.timisencotech.projectmanagementapis.serviceTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.DataBinder;
import ca.timisencotech.projectmanagementapis.domain.ProjectSupervisors;
import ca.timisencotech.projectmanagementapis.exception.ApiError;
import ca.timisencotech.projectmanagementapis.exception.ErrorObject;
import ca.timisencotech.projectmanagementapis.exception.ValidationError;
import ca.timisencotech.projectmanagementapis.service.ProjectSupervisorsService;
import ca.timisencotech.projectmanagementapis.validation.Container;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectSupervisorServiceImpTest<T>
{
	
	 @Autowired
	 ProjectSupervisorsService projectSupervisorsService;
	

	@Test
	public void addProjectSupervisorsDetailsTest() throws JSONException 
	 {
		ProjectSupervisors projectSupervisors = new ProjectSupervisors();
		projectSupervisors.setIsActive(true);
		projectSupervisors.setProjectName("Winnipeg Project");
		projectSupervisors.setSupervisorName("userEmail@gmail.com");
		
		  
		  	

			 DataBinder binder = new DataBinder(projectSupervisors);
			 Container<T> projectSupervisorsContainer = projectSupervisorsService.addProjectSupervisorsDetails(projectSupervisors, binder.getBindingResult());
					
			String typeOfObject = projectSupervisorsContainer.getObjectType();
			if(typeOfObject.equalsIgnoreCase("Class Object"))
			{
			 
				
				ProjectSupervisors resultprojectSupervisors=(ProjectSupervisors)projectSupervisorsContainer.getObject();
				assertTrue( resultprojectSupervisors.getIsActive());
				assertEquals("Winnipeg Project",resultprojectSupervisors.getProjectName());
				assertEquals("userEmail@gmail.com", resultprojectSupervisors.getSupervisorName());
				
			}
			
			
		// checks for unique constraints
			projectSupervisors = new ProjectSupervisors();
			projectSupervisors.setIsActive(true);
			projectSupervisors.setProjectName("Winnipeg Project");
			projectSupervisors.setSupervisorName("userEmail@gmail.com");
			
			binder = new DataBinder(projectSupervisors);
			projectSupervisorsContainer = projectSupervisorsService.addProjectSupervisorsDetails(projectSupervisors, binder.getBindingResult());
			typeOfObject = projectSupervisorsContainer.getObjectType();
				if (typeOfObject.equalsIgnoreCase("Error Object"))
				{
					ErrorObject errorObject = (ErrorObject) projectSupervisorsContainer.getObject();
					if(errorObject instanceof ApiError)
					{
						ApiError apiError = (ApiError) errorObject;
						assertEquals("Persistence Error", apiError.getStatus());
			
					}
				}
				
			// checks for validation error
				projectSupervisors = new ProjectSupervisors();
				projectSupervisors.setIsActive(true);
				projectSupervisors.setProjectName("Winnipeg Project");
				projectSupervisors.setSupervisorName("userEmail@gmail.com");
				
				  binder = new DataBinder(projectSupervisors);
				  projectSupervisorsContainer = projectSupervisorsService.addProjectSupervisorsDetails(projectSupervisors, binder.getBindingResult());
							
					typeOfObject = projectSupervisorsContainer.getObjectType();
					if (typeOfObject.equalsIgnoreCase("Error Object"))
					{

						ErrorObject errorObject = (ErrorObject)projectSupervisorsContainer.getObject();
						
						 if (errorObject instanceof ValidationError)
						{
							ValidationError validationError = (ValidationError)errorObject;
							assertEquals("Failed", validationError.getMessageObject().getString("errorStatus"));
							assertEquals("Failed validation test for all or most of the fields", validationError.getMessageObject().getString("message"));
							
							
						}
					}
					
					
	 }
	
	
	 	
	 	
	 	
	
}

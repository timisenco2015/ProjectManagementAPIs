package ca.timisencotech.projectmanagementapis.serviceTest;

import static org.junit.Assert.assertEquals;
import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.DataBinder;
import ca.timisencotech.projectmanagementapis.domain.SupervisorTasks;
import ca.timisencotech.projectmanagementapis.exception.ApiError;
import ca.timisencotech.projectmanagementapis.exception.ErrorObject;
import ca.timisencotech.projectmanagementapis.exception.ValidationError;
import ca.timisencotech.projectmanagementapis.service.SupervisorsTasksService;
import ca.timisencotech.projectmanagementapis.validation.Container;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SupervisorTasksServiceImpTest<T>
{
	
	 @Autowired
	 SupervisorsTasksService supervisorsTasksService;
	

	@Test
	public void addSupervisorTasksTest() throws JSONException 
	 {
		SupervisorTasks supervisorTasks = new  SupervisorTasks();
		supervisorTasks.setProjectName("Sherwood Project");
		supervisorTasks.setSupervisorName("userAEmail@gmail.com");
		supervisorTasks.setTaskName("Sub Task4");
		
	
		  	

			 DataBinder binder = new DataBinder(supervisorTasks);
			 Container<T> supervisorTasksContainer = supervisorsTasksService.addSupervisorTasks(supervisorTasks, binder.getBindingResult());
					
			String typeOfObject = supervisorTasksContainer.getObjectType();
			if(typeOfObject.equalsIgnoreCase("Class Object"))
			{
			 
				SupervisorTasks resultSupervisorTasks=	(SupervisorTasks)supervisorTasksContainer.getObject();
				assertEquals("Sherwood Project", resultSupervisorTasks.getProjectName());
				assertEquals("userAEmail@gmail.com",resultSupervisorTasks.getSupervisorName());
				assertEquals("Sub Task4",resultSupervisorTasks.getTaskName());
			}
			
			
		// checks for unique constraints
			 supervisorTasks = new  SupervisorTasks();
			supervisorTasks.setProjectName("Sherwood Project");
			supervisorTasks.setSupervisorName("userAEmail@gmail.com");
			supervisorTasks.setTaskName("Sub Task4");
			
		
			  	

				  binder = new DataBinder(supervisorTasks);
				 supervisorTasksContainer = supervisorsTasksService.addSupervisorTasks(supervisorTasks, binder.getBindingResult());
						
				 typeOfObject = supervisorTasksContainer.getObjectType();
				if (typeOfObject.equalsIgnoreCase("Error Object"))
				{
					ErrorObject errorObject = (ErrorObject)supervisorTasksContainer.getObject();
					if(errorObject instanceof ApiError)
					{
						ApiError apiError = (ApiError)supervisorTasksContainer.getObject();
						assertEquals("Persistence Error", apiError.getStatus());
			
					}
				}
				
			// checks for validation error
				
				 supervisorTasks = new  SupervisorTasks();
					supervisorTasks.setProjectName("Sherwood Project");
					supervisorTasks.setSupervisorName("userAEmail@gmail.com");
					
					binder = new DataBinder(supervisorTasks);
						supervisorTasksContainer = supervisorsTasksService.addSupervisorTasks(supervisorTasks, binder.getBindingResult());
								
						 typeOfObject = supervisorTasksContainer.getObjectType();
						if (typeOfObject.equalsIgnoreCase("Error Object"))
					{

						ErrorObject errorObject = (ErrorObject)supervisorTasksContainer.getObject();
						
						 if (errorObject instanceof ValidationError)
						{
							ValidationError validationError = (ValidationError)errorObject;
							assertEquals("Failed", validationError.getMessageObject().getString("errorStatus"));
							assertEquals("Failed validation test for all or most of the fields", validationError.getMessageObject().getString("message"));
							
							
						}
					}
					
					
	 }
	
	
	 	
	 	
	 	
	
}

package ca.timisencotech.projectmanagementapis.serviceTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Timestamp;
import java.util.Date;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.DataBinder;
import ca.timisencotech.projectmanagementapis.domain.TaskAssignedMembers;
import ca.timisencotech.projectmanagementapis.exception.ApiError;
import ca.timisencotech.projectmanagementapis.exception.ErrorObject;
import ca.timisencotech.projectmanagementapis.exception.ValidationError;
import ca.timisencotech.projectmanagementapis.service.TaskAssignedMembersService;
import ca.timisencotech.projectmanagementapis.validation.Container;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskAssignedMemberServiceImpTest<T>
{
	
	 @Autowired
	 TaskAssignedMembersService taskAssignedMembersService;
	

	@Test
	public void assignedTaskToMembersTest() throws JSONException 
	 {
		 Date date= new Date();
			Timestamp dateAssigned = new Timestamp(date.getTime());
			
			
			TaskAssignedMembers taskAssignedMembers = new TaskAssignedMembers();
			taskAssignedMembers.setActive(true);
			taskAssignedMembers.setAssignedBy("userAEmail@gmail.com");
			taskAssignedMembers.setAssignedTo("userABEmail@gmail.com");
			taskAssignedMembers.setDateAssigned(dateAssigned);
			taskAssignedMembers.setDescription("gfghftdrdg");
			taskAssignedMembers.setProjectName("Sherwood Project");
			taskAssignedMembers.setTaskName("Sub task3");	

			 DataBinder binder = new DataBinder(taskAssignedMembers);
			 Container<T> taskAssignedMembersContainer = taskAssignedMembersService.assignedTaskToMembers(taskAssignedMembers,  binder.getBindingResult());
					
			String typeOfObject = taskAssignedMembersContainer.getObjectType();
			if(typeOfObject.equalsIgnoreCase("Class Object"))
			{
				TaskAssignedMembers resultTaskAssignedMembers=	(TaskAssignedMembers)taskAssignedMembersContainer.getObject();
				assertTrue(resultTaskAssignedMembers.getIsActive());
				 assertEquals("userAEmail@gmail.com", resultTaskAssignedMembers.getAssignedBy());
				 assertEquals("userABEmail@gmail.com", resultTaskAssignedMembers.getAssignedTo());
				 assertEquals(dateAssigned, resultTaskAssignedMembers.getDateAssigned());
				 assertEquals("gfghftdrdg",resultTaskAssignedMembers.getDescription());
				 assertEquals("Sherwood Project", resultTaskAssignedMembers.getProjectName());
				assertEquals("Sub task3", resultTaskAssignedMembers.getTaskName());
				}
			
			
		// checks for unique constraints
			taskAssignedMembers = new TaskAssignedMembers();
			taskAssignedMembers.setActive(true);
			taskAssignedMembers.setAssignedBy("userAEmail@gmail.com");
			taskAssignedMembers.setAssignedTo("userABEmail@gmail.com");
			taskAssignedMembers.setDateAssigned(dateAssigned);
			taskAssignedMembers.setDescription("gfghftdrdg");
			taskAssignedMembers.setProjectName("Sherwood Project");
			taskAssignedMembers.setTaskName("Sub task3");	

			 binder = new DataBinder(taskAssignedMembers);
			 taskAssignedMembersContainer = taskAssignedMembersService.assignedTaskToMembers(taskAssignedMembers,  binder.getBindingResult());
					
			typeOfObject = taskAssignedMembersContainer.getObjectType();
			if (typeOfObject.equalsIgnoreCase("Error Object"))
				{
					ErrorObject errorObject = (ErrorObject)taskAssignedMembersContainer.getObject();
					if(errorObject instanceof ApiError)
					{
						ApiError apiError = (ApiError) errorObject;
						assertEquals("Persistence Error", apiError.getStatus());
			
					}
				}
				
			// checks for validation error
			taskAssignedMembers = new TaskAssignedMembers();
			taskAssignedMembers.setActive(true);
			taskAssignedMembers.setAssignedBy("userAEmail@gmail.com");
			taskAssignedMembers.setAssignedTo("userABEmail@gmail.com");
			taskAssignedMembers.setDateAssigned(dateAssigned);
			taskAssignedMembers.setDescription("gfghftdrdg");
			taskAssignedMembers.setProjectName("Sherwood Project");
			taskAssignedMembers.setTaskName("Sub task3");	

			 binder = new DataBinder(taskAssignedMembers);
			 taskAssignedMembersContainer = taskAssignedMembersService.assignedTaskToMembers(taskAssignedMembers,  binder.getBindingResult());
					
			typeOfObject = taskAssignedMembersContainer.getObjectType();
			if (typeOfObject.equalsIgnoreCase("Error Object"))
					{

						ErrorObject errorObject = (ErrorObject)taskAssignedMembersContainer.getObject();
						
						 if (errorObject instanceof ValidationError)
						{
							ValidationError validationError = (ValidationError)errorObject;
							assertEquals("Failed", validationError.getMessageObject().getString("errorStatus"));
							assertEquals("Failed validation test for all or most of the fields", validationError.getMessageObject().getString("message"));
							
							
						}
					}
					
					
	 }
	
	
	 	
	 	
	 	
	
}

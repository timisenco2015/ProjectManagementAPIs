package ca.timisencotech.projectmanagementapis.serviceTest;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;
import java.util.Date;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.DataBinder;
import ca.timisencotech.projectmanagementapis.domain.Task;
import ca.timisencotech.projectmanagementapis.exception.ApiError;
import ca.timisencotech.projectmanagementapis.exception.ErrorObject;
import ca.timisencotech.projectmanagementapis.exception.ValidationError;
import ca.timisencotech.projectmanagementapis.service.TaskService;
import ca.timisencotech.projectmanagementapis.validation.Container;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskServiceImpTest<T>
{
	
	 @Autowired
	 TaskService taskService;
	

	@Test
	public void addTaskTest() throws JSONException 
	 {
		Date date= new Date();
		Timestamp loginTime = new Timestamp(date.getTime());
		
		  	Task task = new Task();
		  	task.setProjectName("Brandon Project");
		  	
		  	loginTime = new Timestamp(date.getTime());
		  	task.setCreatedDate(loginTime);
		  	
		  	loginTime = new Timestamp(date.getTime());
		  	task.setStartDate(loginTime);
		  	
		  	loginTime = new Timestamp(date.getTime());
		  	task.setEndDate(loginTime);
		  	
		  	
		  	task.setCreatedBy("userEmail@gmail.com");
		  	task.setDescription("sdfdfdfdfdfdfd");
		  	task.setTaskName("Sub Task1");
		  	
		  	

			 DataBinder binder = new DataBinder(task);
			 Container<T> taskContainer = taskService.addTask(task, binder.getBindingResult());
					
			String typeOfObject = taskContainer.getObjectType();
			if(typeOfObject.equalsIgnoreCase("Class Object"))
			{
			 
				Task resultTask=	(Task)taskContainer.getObject();
				assertEquals("Brandon Project", resultTask.getProjectName());
				assertEquals("sdfdfdfdfdfdfd",resultTask.getDescription());
				assertEquals("userEmail@gmail.com",resultTask.getCreatedBy());
				assertEquals("Sub Task1",resultTask.getTaskName());
			}
			
			
		// checks for unique constraints
			date= new Date();
			loginTime = new Timestamp(date.getTime());
			
			  task = new Task();
			  	task.setProjectName("Brandon Project");
			  	
			  	loginTime = new Timestamp(date.getTime());
			  	task.setCreatedDate(loginTime);
			  	
			  	loginTime = new Timestamp(date.getTime());
			  	task.setStartDate(loginTime);
			  	
			  	loginTime = new Timestamp(date.getTime());
			  	task.setEndDate(loginTime);
			  	
			  	
			  	task.setCreatedBy("userEmail@gmail.com");
			  	task.setDescription("sdfdfdfdfdfdfd");
			  	task.setTaskName("Sub Task1");
			  	
			  	

				 binder = new DataBinder(task);
				 taskContainer = taskService.addTask(task, binder.getBindingResult());
						
				 typeOfObject = taskContainer.getObjectType();
				if (typeOfObject.equalsIgnoreCase("Error Object"))
				{
					ErrorObject errorObject = (ErrorObject)taskContainer.getObject();
					if(errorObject instanceof ApiError)
					{
						ApiError apiError = (ApiError)taskContainer.getObject();
						assertEquals("Persistence Error", apiError.getStatus());
			
					}
				}
				
			// checks for validation error
				
				date= new Date();
				loginTime = new Timestamp(date.getTime());
				
				  task = new Task();
				  	task.setProjectName("Brandon Project");
				  	
				  	loginTime = new Timestamp(date.getTime());
				  	task.setCreatedDate(loginTime);
				  	
				  	loginTime = new Timestamp(date.getTime());
				  	task.setStartDate(loginTime);
				  	
				  	loginTime = new Timestamp(date.getTime());
				  	task.setEndDate(loginTime);
				  	
				  	
				  	task.setCreatedBy("userEmail@gmail.com");
				  	task.setDescription("sdfdfdfdfdfdfd");
				  	
				  	

					 binder = new DataBinder(task);
					 taskContainer = taskService.addTask(task, binder.getBindingResult());
							
					 typeOfObject = taskContainer.getObjectType();
					if (typeOfObject.equalsIgnoreCase("Error Object"))
					{

						ErrorObject errorObject = (ErrorObject)taskContainer.getObject();
						
						 if (errorObject instanceof ValidationError)
						{
							ValidationError validationError = (ValidationError)errorObject;
							assertEquals("Failed", validationError.getMessageObject().getString("errorStatus"));
							assertEquals("Failed validation test for all or most of the fields", validationError.getMessageObject().getString("message"));
							
							
						}
					}
					
					
	 }
	
	
	 	
	 	
	 	
	
}

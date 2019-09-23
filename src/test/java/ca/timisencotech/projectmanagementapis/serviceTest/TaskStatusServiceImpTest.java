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
import ca.timisencotech.projectmanagementapis.domain.TaskStatus;
import ca.timisencotech.projectmanagementapis.exception.ApiError;
import ca.timisencotech.projectmanagementapis.exception.ErrorObject;
import ca.timisencotech.projectmanagementapis.exception.ValidationError;
import ca.timisencotech.projectmanagementapis.service.TaskStatusService;
import ca.timisencotech.projectmanagementapis.validation.Container;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskStatusServiceImpTest<T>
{
	
	 @Autowired
	 TaskStatusService taskStatusService;
	

	@Test
	public void addTaskStatusTest() throws JSONException 
	 {
		 Date date= new Date();
			
			TaskStatus  taskStatus = new  TaskStatus();
			Timestamp completedDate = new Timestamp(date.getTime());
			taskStatus.setCompletedDate(completedDate);
			taskStatus.setDescription("bdbdbbcxvb");
			taskStatus.setDonePercentage(30.34);
			taskStatus.setMemberName("userHEmail@gmail.com");
			taskStatus.setProjectName("Sherwood Project");
			taskStatus.setTaskName("Sub Task1");
			Timestamp updatedDate = new Timestamp(date.getTime());
			taskStatus.setUpdatedDate(updatedDate);

		DataBinder binder = new DataBinder(taskStatus);
		Container<T> taskStatusContainer = taskStatusService.addTaskStatus(taskStatus, binder.getBindingResult());
					
		String typeOfObject = taskStatusContainer.getObjectType();
		if(typeOfObject.equalsIgnoreCase("Class Object"))
		{
			 
				
			TaskStatus resulTaskStatus=(TaskStatus)taskStatusContainer.getObject();
				assertEquals(completedDate,resulTaskStatus.getCompletedDate());
				assertEquals("bdbdbbcxvb",resulTaskStatus.getDescription());
				assertEquals(30.34,resulTaskStatus.getDonePercentage(),0);
				assertEquals("Sherwood Project",resulTaskStatus.getProjectName());
				assertEquals("userHEmail@gmail.com", resulTaskStatus.getMemberName());
				assertEquals(updatedDate,resulTaskStatus.getUpdatedDate());
				assertEquals("Sub Task1",resulTaskStatus.getTaskName());
				
			}
			
			
		// checks for unique constraints
		  date= new Date();
			
			taskStatus = new  TaskStatus();
			completedDate = new Timestamp(date.getTime());
			taskStatus.setCompletedDate(completedDate);
			taskStatus.setDescription("bdbdbbcxvb");
			taskStatus.setDonePercentage(30.34);
			taskStatus.setMemberName("userHEmail@gmail.com");
			taskStatus.setProjectName("Sherwood Project");
			taskStatus.setTaskName("Sub Task1");
			updatedDate = new Timestamp(date.getTime());
			taskStatus.setUpdatedDate(updatedDate);

		binder = new DataBinder(taskStatus);
		taskStatusContainer = taskStatusService.addTaskStatus(taskStatus, binder.getBindingResult());
					
		typeOfObject = taskStatusContainer.getObjectType();
		if (typeOfObject.equalsIgnoreCase("Error Object"))
				{
					ErrorObject errorObject = (ErrorObject) taskStatusContainer.getObject();
					if(errorObject instanceof ApiError)
					{
						ApiError apiError = (ApiError) errorObject;
						assertEquals("Persistence Error", apiError.getStatus());
			
					}
				}
				
			// checks for validation error
		date= new Date();
		
		taskStatus = new  TaskStatus();
		completedDate = new Timestamp(date.getTime());
		taskStatus.setCompletedDate(completedDate);
		taskStatus.setDescription("bdbdbbcxvb");
		taskStatus.setDonePercentage(30.34);
		taskStatus.setMemberName("userHEmail@gmail.com");
		taskStatus.setProjectName("Sherwood Project");
		taskStatus.setTaskName("Sub Task1");
		updatedDate = new Timestamp(date.getTime());
		taskStatus.setUpdatedDate(updatedDate);

	binder = new DataBinder(taskStatus);
	taskStatusContainer = taskStatusService.addTaskStatus(taskStatus, binder.getBindingResult());
				
	typeOfObject = taskStatusContainer.getObjectType();
	if (typeOfObject.equalsIgnoreCase("Error Object"))
					{

						ErrorObject errorObject = (ErrorObject)taskStatusContainer.getObject();
						
						 if (errorObject instanceof ValidationError)
						{
							ValidationError validationError = (ValidationError)errorObject;
							assertEquals("Failed", validationError.getMessageObject().getString("errorStatus"));
							assertEquals("Failed validation test for all or most of the fields", validationError.getMessageObject().getString("message"));
							
							
						}
					}
					
					
	 }
	
	
	 	
	 	
	 	
	
}

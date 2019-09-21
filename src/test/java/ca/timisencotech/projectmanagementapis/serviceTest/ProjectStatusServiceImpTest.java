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
import ca.timisencotech.projectmanagementapis.domain.ProjectStatus;
import ca.timisencotech.projectmanagementapis.exception.ApiError;
import ca.timisencotech.projectmanagementapis.exception.ErrorObject;
import ca.timisencotech.projectmanagementapis.exception.ValidationError;
import ca.timisencotech.projectmanagementapis.service.ProjectStatusService;
import ca.timisencotech.projectmanagementapis.validation.Container;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectStatusServiceImpTest<T>
{
	
	 @Autowired
	 ProjectStatusService projectStatusService;
	

	@Test
	public void addProjectStatusDetailsTest() throws JSONException 
	 {
		 Date date= new Date();
			
		 
		 ProjectStatus projectStatus = new ProjectStatus();
		 
		 Timestamp completedDate = new Timestamp(date.getTime());
		 projectStatus.setCompletedDate(completedDate);
		 projectStatus.setDescription("fggfbfb");
		 projectStatus.setDonePercentage(40.45);
		 projectStatus.setProjectName("Sherwood Project");
		 projectStatus.setSupervisorName("userAEmail@gmail.com");
		 Timestamp updatedDate = new Timestamp(date.getTime());
		 projectStatus.setUpdatedDate(updatedDate);
	
		DataBinder binder = new DataBinder(projectStatus);
		Container<T> projectStatusContainer = projectStatusService.addProjectStatusDetails(projectStatus, binder.getBindingResult());
					
		String typeOfObject = projectStatusContainer.getObjectType();
		if(typeOfObject.equalsIgnoreCase("Class Object"))
		{
			 
				
			ProjectStatus resultProjectStatus=(ProjectStatus)projectStatusContainer.getObject();
				assertEquals(completedDate,resultProjectStatus.getCompletedDate());
				assertEquals("fggfbfb",resultProjectStatus.getDescription());
				assertEquals(40.45,resultProjectStatus.getDonePercentage(),0);
				assertEquals("Sherwood Project",resultProjectStatus.getProjectName());
				assertEquals("userEmail@gmail.com", resultProjectStatus.getSupervisorName());
				assertEquals(updatedDate,resultProjectStatus.getUpdatedDate());
				
			}
			
			
		// checks for unique constraints
		date= new Date();
			
		 
		 projectStatus = new ProjectStatus();
		 
		 completedDate = new Timestamp(date.getTime());
		 projectStatus.setCompletedDate(completedDate);
		 projectStatus.setDescription("fggfbfb");
		 projectStatus.setDonePercentage(48.45);
		 projectStatus.setProjectName("Sherwood Project");
		 projectStatus.setSupervisorName("userAEmail@gmail.com");
		 updatedDate = new Timestamp(date.getTime());
		 projectStatus.setUpdatedDate(updatedDate);
	
			
			binder = new DataBinder(projectStatus);
			projectStatusContainer = projectStatusService.addProjectStatusDetails(projectStatus, binder.getBindingResult());
			typeOfObject = projectStatusContainer.getObjectType();
				if (typeOfObject.equalsIgnoreCase("Error Object"))
				{
					ErrorObject errorObject = (ErrorObject) projectStatusContainer.getObject();
					if(errorObject instanceof ApiError)
					{
						ApiError apiError = (ApiError) errorObject;
						assertEquals("Persistence Error", apiError.getStatus());
			
					}
				}
				
			// checks for validation error
				  date= new Date();
				  projectStatus = new ProjectStatus();
				 completedDate = new Timestamp(date.getTime());
				 projectStatus.setCompletedDate(completedDate);
				 projectStatus.setDescription("fggfbfb");
				 projectStatus.setDonePercentage(40.45);
				 updatedDate = new Timestamp(date.getTime());
				 projectStatus.setUpdatedDate(updatedDate);
				binder = new DataBinder(projectStatus);
				projectStatusContainer = projectStatusService.addProjectStatusDetails(projectStatus, binder.getBindingResult());
				typeOfObject = projectStatusContainer.getObjectType();
				if (typeOfObject.equalsIgnoreCase("Error Object"))
					{

						ErrorObject errorObject = (ErrorObject)projectStatusContainer.getObject();
						
						 if (errorObject instanceof ValidationError)
						{
							ValidationError validationError = (ValidationError)errorObject;
							assertEquals("Failed", validationError.getMessageObject().getString("errorStatus"));
							assertEquals("Failed validation test for all or most of the fields", validationError.getMessageObject().getString("message"));
							
							
						}
					}
					
					
	 }
	
	
	 	
	 	
	 	
	
}

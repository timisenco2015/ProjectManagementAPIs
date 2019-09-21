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
import ca.timisencotech.projectmanagementapis.domain.ProjectGroup;
import ca.timisencotech.projectmanagementapis.exception.ApiError;
import ca.timisencotech.projectmanagementapis.exception.ErrorObject;
import ca.timisencotech.projectmanagementapis.exception.ValidationError;
import ca.timisencotech.projectmanagementapis.service.ProjectGroupService;
import ca.timisencotech.projectmanagementapis.validation.Container;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectGroupServiceImpTest<T>
{
	
	 @Autowired
	 ProjectGroupService projectGroupService;
	

	@Test
	public void addProjectDetailsTest() throws JSONException 
	 {
		 Date date= new Date();
			
		 ProjectGroup projectGroup = new ProjectGroup();
		 
		 projectGroup.setGroupName("group1");
		 Timestamp createdDate = new Timestamp(date.getTime());	
		 projectGroup.setCreatedDate(createdDate);
		 projectGroup.setDescription("ddfdfdfdf");
		 projectGroup.setIsActive(true);
		 projectGroup.setProjectName("Sherwd Project");
		 projectGroup.setCreatedBy("userAEmail@gmail.com");
		
		  	

			 DataBinder binder = new DataBinder(projectGroup);
			 Container<T> projectGroupContainer = projectGroupService.addProjectGroupDetails(projectGroup, binder.getBindingResult());
					
			String typeOfObject = projectGroupContainer.getObjectType();
			if(typeOfObject.equalsIgnoreCase("Class Object"))
			{
				ProjectGroup resultProjectGroup=	(ProjectGroup)projectGroupContainer.getObject();
				assertTrue(resultProjectGroup.getIsActive());
				 assertEquals("userAEmail@gmail.com", resultProjectGroup.getCreatedBy());
				 assertEquals(createdDate, resultProjectGroup.getCreatedDate());
				 assertEquals("ddfdfdfdf", resultProjectGroup.getDescription());
				 assertEquals("group1", resultProjectGroup.getGroupName());
				assertEquals("Sherwood Project", resultProjectGroup.getProjectName());
				}
			
			
		// checks for unique constraints
			date= new Date();
				
			projectGroup = new ProjectGroup();
			 
			 projectGroup.setGroupName("group1");
			 createdDate = new Timestamp(date.getTime());	
			 projectGroup.setCreatedDate(createdDate);
			 projectGroup.setDescription("ddfdfdfdf");
			 projectGroup.setIsActive(true);
			 projectGroup.setProjectName("Sherwood Project");
			 projectGroup.setCreatedBy("userAEmail@gmail.com");
			
			 binder = new DataBinder(projectGroup);
			projectGroupContainer = projectGroupService.addProjectGroupDetails(projectGroup, binder.getBindingResult());
			typeOfObject = projectGroupContainer.getObjectType();
				if (typeOfObject.equalsIgnoreCase("Error Object"))
				{
					ErrorObject errorObject = (ErrorObject) projectGroupContainer.getObject();
					if(errorObject instanceof ApiError)
					{
						ApiError apiError = (ApiError) errorObject;
						assertEquals("Persistence Error", apiError.getStatus());
			
					}
				}
				
			// checks for validation error
				
				 createdDate = new Timestamp(date.getTime());	
				 projectGroup.setCreatedDate(createdDate);
				 projectGroup.setDescription("ddfdfdfdf");
				 projectGroup.setIsActive(true);
				 projectGroup.setProjectName("Sherwood Project");
				 projectGroup.setCreatedBy("userAEmail@gmail.com");
				
					
				 binder = new DataBinder(projectGroup);
				projectGroupContainer = projectGroupService.addProjectGroupDetails(projectGroup, binder.getBindingResult());
				typeOfObject = projectGroupContainer.getObjectType();
				if (typeOfObject.equalsIgnoreCase("Error Object"))
					{

						ErrorObject errorObject = (ErrorObject)projectGroupContainer.getObject();
						
						 if (errorObject instanceof ValidationError)
						{
							ValidationError validationError = (ValidationError)errorObject;
							assertEquals("Failed", validationError.getMessageObject().getString("errorStatus"));
							assertEquals("Failed validation test for all or most of the fields", validationError.getMessageObject().getString("message"));
							
							
						}
					}
					
					
	 }
	
	
	 	
	 	
	 	
	
}

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
import ca.timisencotech.projectmanagementapis.domain.Project;
import ca.timisencotech.projectmanagementapis.exception.ApiError;
import ca.timisencotech.projectmanagementapis.exception.ErrorObject;
import ca.timisencotech.projectmanagementapis.exception.ValidationError;
import ca.timisencotech.projectmanagementapis.service.ProjectService;
import ca.timisencotech.projectmanagementapis.validation.Container;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectServiceImpTest<T>
{
	
	 @Autowired
	 ProjectService projectService;
	

	@Test
	public void addProjectDetailsTest() throws JSONException 
	 {
		Date date= new Date();
		Timestamp loginTime = new Timestamp(date.getTime());
		
		  	Project project = new Project();
		  	project.setProjectName("Brandon Project");
		  	
		  	loginTime = new Timestamp(date.getTime());
		  	project.setCreatedDate(loginTime);
		  	
		  	loginTime = new Timestamp(date.getTime());
		  	project.setStartDate(loginTime);
		  	
		  	loginTime = new Timestamp(date.getTime());
		  	project.setEndDate(loginTime);
		  	
		  	
		  	project.setCreatedBy("userEmail@gmail.com");
		  	project.setDescription("sdfdfdfdfdfdfd");
		  	
		  	
		  	

			 DataBinder binder = new DataBinder(project);
			 Container<T> projectInformationContainer = projectService.addProjectpDetails(project, binder.getBindingResult());
					
			String typeOfObject = projectInformationContainer.getObjectType();
			if(typeOfObject.equalsIgnoreCase("Class Object"))
			{
			 
				Project resultProjectInformation=	(Project)projectInformationContainer.getObject();
				assertEquals("Brandon Project", resultProjectInformation.getProjectName());
				assertEquals("sdfdfdfdfdfdfd",resultProjectInformation.getDescription());
				assertEquals("userEmail@gmail.com", resultProjectInformation.getCreatedBy());
				
			}
			
			
		// checks for unique constraints
			date= new Date();
			 loginTime = new Timestamp(date.getTime());
			
			  	 project = new Project();
			  	project.setProjectName("Brandon Project");
			  	
			  	loginTime = new Timestamp(date.getTime());
			  	project.setCreatedDate(loginTime);
			  	
			  	loginTime = new Timestamp(date.getTime());
			  	project.setStartDate(loginTime);
			  	
			  	loginTime = new Timestamp(date.getTime());
			  	project.setEndDate(loginTime);
			  	
			  	
			  	project.setCreatedBy("userEmail@gmail.com");
			  	project.setDescription("sdfdfdfdfdfdfd");
			  	
			  	

				 binder = new DataBinder(project);
				projectInformationContainer = projectService.addProjectpDetails(project, binder.getBindingResult());
						
				typeOfObject = projectInformationContainer.getObjectType();
				if (typeOfObject.equalsIgnoreCase("Error Object"))
				{
					ErrorObject errorObject = (ErrorObject) projectInformationContainer.getObject();
					if(errorObject instanceof ApiError)
					{
						ApiError apiError = (ApiError) projectInformationContainer.getObject();
						assertEquals("Persistence Error", apiError.getStatus());
			
					}
				}
				
			// checks for validation error
				
				date= new Date();
				loginTime = new Timestamp(date.getTime());
				
				  	project = new Project();
				  	project.setProjectName("Fort Project");
				  	
				  	loginTime = new Timestamp(date.getTime());
				  	project.setCreatedDate(loginTime);
				  	
				  
				  	
				  	
				  	project.setCreatedBy("userHEmail@gmail.com");
				  	project.setDescription("sdfdfdfdfdfdfd");
				  	
				  	
				  	

					 binder = new DataBinder(project);
					 projectInformationContainer = projectService.addProjectpDetails(project, binder.getBindingResult());
							
					typeOfObject = projectInformationContainer.getObjectType();
					if (typeOfObject.equalsIgnoreCase("Error Object"))
					{

						ErrorObject errorObject = (ErrorObject)projectInformationContainer.getObject();
						
						 if (errorObject instanceof ValidationError)
						{
							ValidationError validationError = (ValidationError)errorObject;
							assertEquals("Failed", validationError.getMessageObject().getString("errorStatus"));
							assertEquals("Failed validation test for all or most of the fields", validationError.getMessageObject().getString("message"));
							
							
						}
					}
					
					
	 }
	
	
	 	
	 	
	 	
	
}

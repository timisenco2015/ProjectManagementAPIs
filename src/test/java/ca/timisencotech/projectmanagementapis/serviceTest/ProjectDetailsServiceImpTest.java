package ca.timisencotech.projectmanagementapis.serviceTest;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.DataBinder;
import ca.timisencotech.projectmanagementapis.domain.ProjectInformation;
import ca.timisencotech.projectmanagementapis.exception.ApiError;
import ca.timisencotech.projectmanagementapis.service.ProjectDetailsService;
import ca.timisencotech.projectmanagementapis.validation.Container;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectDetailsServiceImpTest<T>
{
	
	 @Autowired
	 ProjectDetailsService projectDetailsService;
	

	@Test
	public void addProjectDetailsTest() 
	 {
		Date date= new Date();
		Timestamp loginTime = new Timestamp(date.getTime());
		
		  	ProjectInformation projectInformation = new ProjectInformation();
		  	projectInformation.setProjectName("Winnipeg Project");
		  	
		  	loginTime = new Timestamp(date.getTime());
		  	projectInformation.setCreatedDate(loginTime);
		  	
		  	loginTime = new Timestamp(date.getTime());
		  	projectInformation.setStartDate(loginTime);
		  	
		  	loginTime = new Timestamp(date.getTime());
		  	projectInformation.setEndDate(loginTime);
		  	
		  	
		  	projectInformation.setCreatedBy("userHEmail@gmail.com");
		  	projectInformation.setDescription("sdfdfdfdfdfdfd");
		  	
		  	
		  	

			 DataBinder binder = new DataBinder(projectInformation);
			 Container<T> projectInformationContainer = projectDetailsService.addProjectpDetails(projectInformation, binder.getBindingResult());
					
			String typeOfObject = projectInformationContainer.getObjectType();
			if(typeOfObject.equalsIgnoreCase("Class Object"))
			{
			 
				ProjectInformation resultProjectInformation=	(ProjectInformation)projectInformationContainer.getObject();
				assertEquals("Winnipeg Project", resultProjectInformation.getProjectName());
				assertEquals("sdfdfdfdfdfdfd",resultProjectInformation.getDescription());
				assertEquals("userHEmail@gmail.com", resultProjectInformation.getCreatedBy());
				
			}
			else if (typeOfObject.equalsIgnoreCase("Error Object"))
			{
				ApiError apiError = (ApiError)projectInformationContainer.getObject();
				assertEquals("Constraint error", apiError.getMessage());
			}
			
			
		 
	 }
	
		 
	 	@Test
		 private void addaddProjectDetailsNullConstraintTest()
		 {
			
	 		Date date= new Date();
			Timestamp loginTime = new Timestamp(date.getTime());
			
			  	ProjectInformation projectInformation = new ProjectInformation();
			  	projectInformation.setProjectName("Winnipeg Project");
			  	
			  	loginTime = new Timestamp(date.getTime());
			  	projectInformation.setCreatedDate(loginTime);
			  	
			  
			  	
			  	
			  	projectInformation.setCreatedBy("userHEmail@gmail.com");
			  	projectInformation.setDescription("sdfdfdfdfdfdfd");
			  	
			  	
			  	

				 DataBinder binder = new DataBinder(projectInformation);
				 Container<T> projectInformationContainer = projectDetailsService.addProjectpDetails(projectInformation, binder.getBindingResult());
						
				String typeOfObject = projectInformationContainer.getObjectType();
				if(typeOfObject.equalsIgnoreCase("Class Object"))
				{
				 
					ProjectInformation resultProjectInformation=	(ProjectInformation)projectInformationContainer.getObject();
					assertEquals("Winnipeg Project", resultProjectInformation.getProjectName());
					assertEquals("sdfdfdfdfdfdfd",resultProjectInformation.getDescription());
					assertEquals("userHEmail@gmail.com", resultProjectInformation.getCreatedBy());
					
				}
				else if (typeOfObject.equalsIgnoreCase("Error Object"))
				{
					ApiError apiError = (ApiError)projectInformationContainer.getObject();
					assertEquals("Constraint error", apiError.getMessage());
				}
				
				
				
		 }
	 	
	 	
	 	
	
}

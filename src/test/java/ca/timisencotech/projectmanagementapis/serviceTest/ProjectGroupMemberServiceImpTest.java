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
import ca.timisencotech.projectmanagementapis.domain.ProjectGroupMembers;
import ca.timisencotech.projectmanagementapis.exception.ApiError;
import ca.timisencotech.projectmanagementapis.exception.ErrorObject;
import ca.timisencotech.projectmanagementapis.exception.ValidationError;
import ca.timisencotech.projectmanagementapis.service.ProjectGroupMemberService;
import ca.timisencotech.projectmanagementapis.validation.Container;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectGroupMemberServiceImpTest<T>
{
	
	 @Autowired
	 ProjectGroupMemberService projectGroupMemberService;
	

	@Test
	public void addProjectDetailsTest() throws JSONException 
	 {
		ProjectGroupMembers projectGroupMembers = new ProjectGroupMembers();
		
		projectGroupMembers.setIsActive(true);
		projectGroupMembers.setGroupName("group1");
		projectGroupMembers.setActivitiesUpdate("sdfsdfdsfdsfsd");
		projectGroupMembers.setMemberName("userAAEmail@gmail.com");
		projectGroupMembers.setProjectName("Sherwood Project");
			

			 DataBinder binder = new DataBinder(projectGroupMembers);
			 Container<T> projectGroupMemberContainer = projectGroupMemberService.addMemberToProjectGroup(projectGroupMembers, binder.getBindingResult());
					
			String typeOfObject = projectGroupMemberContainer.getObjectType();
			if(typeOfObject.equalsIgnoreCase("Class Object"))
			{
				ProjectGroupMembers resultProjectGroupMember=	(ProjectGroupMembers)projectGroupMemberContainer.getObject();
				assertTrue(resultProjectGroupMember.getIsActive());
				 assertEquals("userAAEmail@gmail.com", resultProjectGroupMember.getMemberName());
				assertEquals("sdfsdfdsfdsfsd",resultProjectGroupMember.getActivitiesUpdate());
				 assertEquals("group1", resultProjectGroupMember.getGroupName());
				assertEquals("Sherwood Project", resultProjectGroupMember.getProjectName());
				}
			
			
		// checks for unique constraints
			projectGroupMembers = new ProjectGroupMembers();
			projectGroupMembers.setIsActive(true);
			projectGroupMembers.setGroupName("group1");
			projectGroupMembers.setActivitiesUpdate("sdfsdfdsfdsfsd");
			projectGroupMembers.setMemberName("userAAEmail@gmail.com");
			projectGroupMembers.setProjectName("Sherwood Project");
			binder = new DataBinder(projectGroupMembers);
			projectGroupMemberContainer = projectGroupMemberService.addMemberToProjectGroup(projectGroupMembers, binder.getBindingResult());
			typeOfObject = projectGroupMemberContainer.getObjectType();
				if (typeOfObject.equalsIgnoreCase("Error Object"))
				{
					ErrorObject errorObject = (ErrorObject)projectGroupMemberContainer.getObject();
					if(errorObject instanceof ApiError)
					{
						ApiError apiError = (ApiError) errorObject;
						assertEquals("Persistence Error", apiError.getStatus());
			
					}
				}
				
			// checks for validation error
				projectGroupMembers = new ProjectGroupMembers();
				projectGroupMembers.setIsActive(true);
				projectGroupMembers.setGroupName("group1");
				projectGroupMembers.setActivitiesUpdate("sdfsdfdsfdsfsd");
				projectGroupMembers.setMemberName("userAAEmail@gmail.com");
				binder = new DataBinder(projectGroupMembers);
				projectGroupMemberContainer = projectGroupMemberService.addMemberToProjectGroup(projectGroupMembers, binder.getBindingResult());
				typeOfObject = projectGroupMemberContainer.getObjectType();
					if (typeOfObject.equalsIgnoreCase("Error Object"))
					{

						ErrorObject errorObject = (ErrorObject)projectGroupMemberContainer.getObject();
						
						 if (errorObject instanceof ValidationError)
						{
							ValidationError validationError = (ValidationError)errorObject;
							assertEquals("Failed", validationError.getMessageObject().getString("errorStatus"));
							assertEquals("Failed validation test for all or most of the fields", validationError.getMessageObject().getString("message"));
							
							
						}
					}
					
					
	 }
	
	
	 	
	 	
	 	
	
}

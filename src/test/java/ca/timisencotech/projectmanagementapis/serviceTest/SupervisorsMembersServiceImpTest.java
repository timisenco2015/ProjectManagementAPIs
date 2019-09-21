package ca.timisencotech.projectmanagementapis.serviceTest;

import static org.junit.Assert.assertEquals;
import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.DataBinder;
import ca.timisencotech.projectmanagementapis.domain.SupervisorsMembers;
import ca.timisencotech.projectmanagementapis.exception.ApiError;
import ca.timisencotech.projectmanagementapis.exception.ErrorObject;
import ca.timisencotech.projectmanagementapis.exception.ValidationError;
import ca.timisencotech.projectmanagementapis.service.SupervisorsMembersService;
import ca.timisencotech.projectmanagementapis.validation.Container;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SupervisorsMembersServiceImpTest<T>
{
	
	 @Autowired
	 SupervisorsMembersService supervisorsMembersService;
	

	@Test
	public void addSupervisorsMembersTest() throws JSONException 
	 {
		SupervisorsMembers supervisorsMembers = new SupervisorsMembers();
		supervisorsMembers.setMemberName("userACAIEmail@gmail.com");
		supervisorsMembers.setProjectName("Winnipeg Project");
		supervisorsMembers.setSupervisorName("userEmail@gmail.com");
		
	
		  	

			 DataBinder binder = new DataBinder(supervisorsMembers);
			 Container<T> supervisorsMembersContainer =supervisorsMembersService.addSupervisorMember(supervisorsMembers,binder.getBindingResult());
					
			String typeOfObject = supervisorsMembersContainer.getObjectType();
			if(typeOfObject.equalsIgnoreCase("Class Object"))
			{
			 
				SupervisorsMembers resultSupervisorsMembers=(SupervisorsMembers)supervisorsMembersContainer.getObject();
				assertEquals("Winnipeg Project", resultSupervisorsMembers.getProjectName());
				assertEquals("userEmail@gmail.com",resultSupervisorsMembers.getSupervisorName());
				assertEquals("userACAIEmail@gmail.com",resultSupervisorsMembers.getMemberName());
			}
			
			
		// checks for unique constraints

			supervisorsMembers = new SupervisorsMembers();
			supervisorsMembers.setMemberName("userACAIEmail@gmail.com");
			supervisorsMembers.setProjectName("Winnipeg Project");
			supervisorsMembers.setSupervisorName("userEmail@gmail.com");
			
			binder = new DataBinder(supervisorsMembers);
			supervisorsMembersContainer =supervisorsMembersService.addSupervisorMember(supervisorsMembers,binder.getBindingResult());
			typeOfObject = supervisorsMembersContainer.getObjectType();
			if (typeOfObject.equalsIgnoreCase("Error Object"))
				{
					ErrorObject errorObject = (ErrorObject)supervisorsMembersContainer.getObject();
					if(errorObject instanceof ApiError)
					{
						ApiError apiError = (ApiError)errorObject;
						assertEquals("Persistence Error", apiError.getStatus());
			
					}
				}
				
			// checks for validation error
				
			supervisorsMembers = new SupervisorsMembers();
			supervisorsMembers.setMemberName("userACAIEmail@gmail.com");
			supervisorsMembers.setSupervisorName("userEmail@gmail.com");
			
			binder = new DataBinder(supervisorsMembers);
			supervisorsMembersContainer =supervisorsMembersService.addSupervisorMember(supervisorsMembers,binder.getBindingResult());
			typeOfObject = supervisorsMembersContainer.getObjectType();
			if (typeOfObject.equalsIgnoreCase("Error Object"))
					{

						ErrorObject errorObject = (ErrorObject)supervisorsMembersContainer.getObject();
						
						 if (errorObject instanceof ValidationError)
						{
							ValidationError validationError = (ValidationError)errorObject;
							assertEquals("Failed", validationError.getMessageObject().getString("errorStatus"));
							assertEquals("Failed validation test for all or most of the fields", validationError.getMessageObject().getString("message"));
							
							
						}
					}
					
					
	 }
	
	
	 	
	 	
	 	
	
}

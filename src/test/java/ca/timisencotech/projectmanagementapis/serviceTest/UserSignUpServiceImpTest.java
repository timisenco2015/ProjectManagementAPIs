package ca.timisencotech.projectmanagementapis.serviceTest;

import static org.junit.Assert.assertEquals;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.DataBinder;
import ca.timisencotech.projectmanagementapis.domain.UserSignUp;
import ca.timisencotech.projectmanagementapis.exception.ApiError;
import ca.timisencotech.projectmanagementapis.exception.ErrorObject;
import ca.timisencotech.projectmanagementapis.exception.ValidationError;
import ca.timisencotech.projectmanagementapis.service.UserSignUpService;
import ca.timisencotech.projectmanagementapis.validation.Container;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserSignUpServiceImpTest<T>
{
	
	 @Autowired
	 UserSignUpService userSignUpService;
	

	@Test
	public void addUserSignUpTest() throws JSONException 
	 {
		  
			UserSignUp userSignUp = new UserSignUp();
			userSignUp.setEmail("userHEmail@gmail.com");
			userSignUp.setPassword("Test@2018");
			

			 DataBinder binder = new DataBinder(userSignUp);
			 Container<T> userLoginDetailsContainer = userSignUpService.addUserSignUpDetails(userSignUp, binder.getBindingResult());
					
			String typeOfObject = userLoginDetailsContainer.getObjectType();
			if(typeOfObject.equalsIgnoreCase("Class Object"))
			{
			 
				UserSignUp resultUserSignUpDetail=	(UserSignUp)userLoginDetailsContainer.getObject();
				assertEquals("userEmail@gmail.com", resultUserSignUpDetail.getEmail());
				assertEquals("Test@2018",resultUserSignUpDetail.getPassword());
			
				
			}
			else if (typeOfObject.equalsIgnoreCase("Error Object"))
			{
				ErrorObject errorObject = (ErrorObject)userLoginDetailsContainer.getObject();
				if(errorObject instanceof ApiError)
				{
					ApiError apiError = (ApiError)errorObject;
					assertEquals("Persistence Error", apiError.getStatus());
				}
				else if (errorObject instanceof ValidationError)
				{
					ValidationError validationError = (ValidationError)errorObject;
					assertEquals("Failed", validationError.getMessageObject().getString("errorStatus"));
					assertEquals("Failed validation test for all or most of the fields", validationError.getMessageObject().getString("message"));
					
					
				}
				
			}
			
			
		 
	 }
	
		 
	 	@Test
		 public void addUserLoginNullConstraintTest() throws JSONException
		 {
			

			UserSignUp userSignUp = new UserSignUp();
			userSignUp.setEmail("userGEmail@gmail.com");
			
			

			 DataBinder binder = new DataBinder(userSignUp);
			 Container<T> userLoginDetailsContainer = userSignUpService.addUserSignUpDetails(userSignUp, binder.getBindingResult());
					
			String typeOfObject = userLoginDetailsContainer.getObjectType();
			if(typeOfObject.equalsIgnoreCase("Class Object"))
			{
			 
				UserSignUp resultUserSignUpDetail=	(UserSignUp)userLoginDetailsContainer.getObject();
				assertEquals("userGEmail@gmail.com", resultUserSignUpDetail.getEmail());
				assertEquals("Test@2018",resultUserSignUpDetail.getPassword());
			
				
			}
			else if (typeOfObject.equalsIgnoreCase("Error Object"))
			{
				ErrorObject errorObject = (ErrorObject)userLoginDetailsContainer.getObject();
				if(errorObject instanceof ApiError)
				{
					ApiError apiError = (ApiError)errorObject;
					assertEquals("Persistence Error", apiError.getStatus());
					
				}
				else if (errorObject instanceof ValidationError)
				{
					ValidationError validationError = (ValidationError)errorObject;
					assertEquals("Failed", validationError.getMessageObject().getString("errorStatus"));
					assertEquals("Failed validation test for all or most of the fields", validationError.getMessageObject().getString("message"));
					
					
				}}
				
		 }
	 	
	 	
	 	
		 @Test
		 public void updateUserPasswordServiceTest() throws JSONException 
			 {
			 
			 //Test for update user password
			 UserSignUp userSignUp = new UserSignUp();
				userSignUp.setEmail("userHEmail@gmail.com");
				userSignUp.setPassword("Test@2023");
				
				 DataBinder binder = new DataBinder(userSignUp);
				 Container<T> userLoginDetailsContainer = userSignUpService.addUserSignUpDetails(userSignUp, binder.getBindingResult());
						
				String typeOfObject = userLoginDetailsContainer.getObjectType();
				if(typeOfObject.equalsIgnoreCase("Class Object"))
				{
				 
					UserSignUp resultUserSignUpDetail=	(UserSignUp)userLoginDetailsContainer.getObject();
					assertEquals("userEmail@gmail.com", resultUserSignUpDetail.getEmail());
					assertEquals("Test@2023",resultUserSignUpDetail.getPassword());
				
					
				}
				else if (typeOfObject.equalsIgnoreCase("Error Object"))
				{
					ErrorObject errorObject = (ErrorObject)userLoginDetailsContainer.getObject();
					if(errorObject instanceof ApiError)
					{
						ApiError apiError = (ApiError)errorObject;
						assertEquals("Persistence Error", apiError.getStatus());
						
					}
					else if (errorObject instanceof ValidationError)
					{
						ValidationError validationError = (ValidationError)errorObject;
						assertEquals("Failed", validationError.getMessageObject().getString("errorStatus"));
						assertEquals("Failed validation test for all or most of the fields", validationError.getMessageObject().getString("message"));
						
						
					}}
				
				else if (typeOfObject.equalsIgnoreCase("Update Object"))
				{
					ApiError apiError = (ApiError)userLoginDetailsContainer.getObject();
					assertEquals("Unable to update password", apiError.getStatus());
				}
				
			 }
	
		 
		
}

package ca.timisencotech.projectmanagementapis.serviceTest;

import static org.junit.Assert.assertEquals;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.DataBinder;
import ca.timisencotech.projectmanagementapis.domain.User;
import ca.timisencotech.projectmanagementapis.exception.ApiError;
import ca.timisencotech.projectmanagementapis.exception.ErrorObject;
import ca.timisencotech.projectmanagementapis.exception.ValidationError;
import ca.timisencotech.projectmanagementapis.service.UserService;
import ca.timisencotech.projectmanagementapis.validation.Container;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImpTest<T>
{
	
	 @Autowired
	 UserService userService;
	

	@Test
	public void addNewUserTest() throws JSONException 
	 {
		  User user = new User();
		  user.setFirstName("Wyke");
		  user.setLastName("Limo");
		  user.setMiddleName("O");
		  user.setPhoneNo("2049626879");
		  user.setUserAddress("616 Armitage");
		  user.setUserEmail("userHEmail@gmail.com");
		  user.setUserGender("Male");

			 DataBinder binder = new DataBinder(user);
			 Container<T> userDetailsContainer = userService.addNewUser(user, binder.getBindingResult());
					
			String typeOfObject = userDetailsContainer.getObjectType();
			if(typeOfObject.equalsIgnoreCase("Class Object"))
			{
			 
				User resultUserDetail=	(User)userDetailsContainer.getObject();
				assertEquals("Wyke",resultUserDetail.getFirstName());
				assertEquals("Limo", resultUserDetail.getLastName());
				assertEquals("O", resultUserDetail.getMiddleName());
				assertEquals("2049626879", resultUserDetail.getPhoneNo());
				assertEquals("616 Armitage", resultUserDetail.getUserAddress());
				assertEquals("userHEmail@gmail.com", resultUserDetail.getUserEmail());
				assertEquals("Male", resultUserDetail.getUserGender());
			}
		
		//check for null validation error	
			 user = new User();
			 
				// userDetail.setCountryPhoneCode("+1");
				 user.setFirstName("Yemite");
				 user.setMiddleName("O");
				 
				 user.setUserAddress("616 Armitgae Crescent, Sherwood Park, Alberta. T8H 0T7");
				user.setUserEmail("userBEmail@gmail.com");	
				user.setUserGender("FeMale");
				  binder = new DataBinder(user);
				  userDetailsContainer = userService.addNewUser(user, binder.getBindingResult());
						
				 typeOfObject = userDetailsContainer.getObjectType();
					if (typeOfObject.equalsIgnoreCase("Error Object"))
					{
						ErrorObject errorObject = (ErrorObject)userDetailsContainer.getObject();
						
						 if (errorObject instanceof ValidationError)
						{
							ValidationError validationError = (ValidationError)errorObject;
							assertEquals("Failed", validationError.getMessageObject().getString("errorStatus"));
							assertEquals("Failed validation test for all or most of the fields", validationError.getMessageObject().getString("message"));
							
							
						}}
					
					
			// checks for unique constraint error		
					
					 
					 user = new User();
					  user.setFirstName("Wyke");
					  user.setLastName("Limo");
					  user.setMiddleName("O");
					  user.setPhoneNo("2049626879");
					  user.setUserAddress("616 Armitage");
					  user.setUserEmail("userHEmail@gmail.com");
					  user.setUserGender("Male");

					 binder = new DataBinder(user);
					 userDetailsContainer = userService.addNewUser(user, binder.getBindingResult());
							
					typeOfObject = userDetailsContainer.getObjectType();
						if(typeOfObject.equalsIgnoreCase("Class Object"))
						{
						 
							User resultUserDetail=	(User)userDetailsContainer.getObject();
						 assertEquals("Ayobamii", resultUserDetail.getFirstName());
						 assertEquals("O", resultUserDetail.getMiddleName());
						 assertEquals("Idowu", resultUserDetail.getLastName());
						 assertEquals("2049623752", resultUserDetail.getPhoneNo());
						 assertEquals("616 Armitgae Crescent, Sherwood Park, Alberta. T8H 0T7", resultUserDetail.getUserAddress());
						 assertEquals("ayobami.o.idowu@gmail.com", resultUserDetail.getUserEmail());
						 assertEquals("Male", resultUserDetail.getUserGender());
						}
						else if (typeOfObject.equalsIgnoreCase("Error Object"))
						{
							if (typeOfObject.equalsIgnoreCase("Error Object"))
							{
								ErrorObject errorObject = (ErrorObject)userDetailsContainer.getObject();
								if(errorObject instanceof ApiError)
								{
									ApiError apiError = (ApiError)userDetailsContainer.getObject();
									assertEquals("Persistence Error", apiError.getStatus());
						
								}
							}
						
						}	
		 
	 }
	 

}

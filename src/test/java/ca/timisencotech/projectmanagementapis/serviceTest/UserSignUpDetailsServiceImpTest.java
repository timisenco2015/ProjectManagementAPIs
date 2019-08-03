package ca.timisencotech.projectmanagementapis.serviceTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.DataBinder;
import ca.timisencotech.projectmanagementapis.domain.UserSignUpDetail;
import ca.timisencotech.projectmanagementapis.exception.ApiError;
import ca.timisencotech.projectmanagementapis.service.UserSignUpDetailsService;
import ca.timisencotech.projectmanagementapis.validation.Container;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserSignUpDetailsServiceImpTest<T>
{
	
	 @Autowired
	 UserSignUpDetailsService userSignUpDetailsService;
	

	@Test
	public void addUserSignUpDetailsTest() 
	 {
		  
			UserSignUpDetail userSignUpDetail = new UserSignUpDetail();
			userSignUpDetail.setUserEmail("userHEmail@gmail.com");
			userSignUpDetail.setPassword("Test@2018");
			

			 DataBinder binder = new DataBinder(userSignUpDetail);
			 Container<T> userLoginDetailsContainer = userSignUpDetailsService.addUserSignUpDetails(userSignUpDetail, binder.getBindingResult());
					
			String typeOfObject = userLoginDetailsContainer.getObjectType();
			if(typeOfObject.equalsIgnoreCase("Class Object"))
			{
			 
				UserSignUpDetail resultUserSignUpDetail=	(UserSignUpDetail)userLoginDetailsContainer.getObject();
				assertEquals("userEmail@gmail.com", resultUserSignUpDetail.getUserEmail());
				assertEquals("Test@2018",resultUserSignUpDetail.getPassword());
			
				
			}
			else if (typeOfObject.equalsIgnoreCase("Error Object"))
			{
				ApiError apiError = (ApiError)userLoginDetailsContainer.getObject();
				assertEquals("Constraint error", apiError.getMessage());
			}
			
			
		 
	 }
	
		 
	 	@Test
		 private void addUserLoginDetailNullConstraintTest()
		 {
			

			UserSignUpDetail userSignUpDetail = new UserSignUpDetail();
			userSignUpDetail.setUserEmail("userGEmail@gmail.com");
			
			

			 DataBinder binder = new DataBinder(userSignUpDetail);
			 Container<T> userLoginDetailsContainer = userSignUpDetailsService.addUserSignUpDetails(userSignUpDetail, binder.getBindingResult());
					
			String typeOfObject = userLoginDetailsContainer.getObjectType();
			if(typeOfObject.equalsIgnoreCase("Class Object"))
			{
			 
				UserSignUpDetail resultUserSignUpDetail=	(UserSignUpDetail)userLoginDetailsContainer.getObject();
				assertEquals("userGEmail@gmail.com", resultUserSignUpDetail.getUserEmail());
				assertEquals("Test@2018",resultUserSignUpDetail.getPassword());
			
				
			}
			else if (typeOfObject.equalsIgnoreCase("Error Object"))
			{
				ApiError apiError = (ApiError)userLoginDetailsContainer.getObject();
				assertEquals("Constraint error", apiError.getMessage());
			}
				
		 }
	 	
	 	
	 	
		 @Test
		 public void updateUserPasswordServiceTest() 
			 {
			 
			 //Test for update user password
			 UserSignUpDetail userSignUpDetail = new UserSignUpDetail();
				userSignUpDetail.setUserEmail("userHEmail@gmail.com");
				userSignUpDetail.setPassword("Test@2023");
				
				 DataBinder binder = new DataBinder(userSignUpDetail);
				 Container<T> userLoginDetailsContainer = userSignUpDetailsService.addUserSignUpDetails(userSignUpDetail, binder.getBindingResult());
						
				String typeOfObject = userLoginDetailsContainer.getObjectType();
				if(typeOfObject.equalsIgnoreCase("Class Object"))
				{
				 
					UserSignUpDetail resultUserSignUpDetail=	(UserSignUpDetail)userLoginDetailsContainer.getObject();
					assertEquals("userEmail@gmail.com", resultUserSignUpDetail.getUserEmail());
					assertEquals("Test@2023",resultUserSignUpDetail.getPassword());
				
					
				}
				else if (typeOfObject.equalsIgnoreCase("Error Object"))
				{
					ApiError apiError = (ApiError)userLoginDetailsContainer.getObject();
					assertEquals("Constraint error", apiError.getMessage());
				}
				
				else if (typeOfObject.equalsIgnoreCase("Update Object"))
				{
					ApiError apiError = (ApiError)userLoginDetailsContainer.getObject();
					assertEquals("Unable to update password", apiError.getStatus());
				}
				
			 }
	
		 
		
}

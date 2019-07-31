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
import ca.timisencotech.projectmanagementapis.domain.UserLoginDetail;
import ca.timisencotech.projectmanagementapis.exception.ApiError;
import ca.timisencotech.projectmanagementapis.service.UserLoginDetailsService;
import ca.timisencotech.projectmanagementapis.validation.Container;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserLoginDetailsServiceImpTest<T>
{
	
	 @Autowired
	 UserLoginDetailsService userLoginDetailsService;
	

	@Test
	public void addUserLoginDetailsTest() 
	 {
		  	Date date= new Date();
			Timestamp timeStamp = new Timestamp(date.getTime());
			
			UserLoginDetail userLoginDetail = new UserLoginDetail();
			userLoginDetail.setLoginTime(timeStamp);
			userLoginDetail.setUserEmail("userEmail@gmail.com");
			userLoginDetail.setPassword("Test@2018");
			

			 DataBinder binder = new DataBinder(userLoginDetail);
			 Container<T> userLoginDetailsContainer = userLoginDetailsService.addUserLoginDetails(userLoginDetail, binder.getBindingResult());
					
			String typeOfObject = userLoginDetailsContainer.getObjectType();
			if(typeOfObject.equalsIgnoreCase("Class Object"))
			{
			 
				UserLoginDetail resultUserLoginDetail=	(UserLoginDetail)userLoginDetailsContainer.getObject();
				assertEquals("userEmail@gmail.com", resultUserLoginDetail.getUserEmail());
				assertEquals("Test@2018",resultUserLoginDetail.getPassword());
				assertEquals(timeStamp, resultUserLoginDetail.getLoginTime());
				
			}
			else if (typeOfObject.equalsIgnoreCase("Error Object"))
			{
				ApiError apiError = (ApiError)userLoginDetailsContainer.getObject();
				assertEquals("Constraint error", apiError.getMessage());
			}
			
			
		 
	 }
	
		 
	 	@Test
		 private void nullConstraintTest()
		 {
			
				Date date= new Date();
				Timestamp timeStamp = new Timestamp(date.getTime());
				
				UserLoginDetail userLoginDetail = new UserLoginDetail();
				userLoginDetail.setLoginTime(timeStamp);
				userLoginDetail.setUserEmail("userEmail@gmail.com");
				userLoginDetail.setPassword("Test@2018");
				
				 DataBinder binder = new DataBinder(userLoginDetail);
				 Container<T> userLoginDetailsContainer = userLoginDetailsService.addUserLoginDetails(userLoginDetail, binder.getBindingResult());
						
				String typeOfObject = userLoginDetailsContainer.getObjectType();
				if(typeOfObject.equalsIgnoreCase("Class Object"))
				{
				 
					UserLoginDetail resultUserLoginDetail=	(UserLoginDetail)userLoginDetailsContainer.getObject();
				 assertEquals("userEmail@gmail.com", resultUserLoginDetail.getUserEmail());
				 assertEquals(timeStamp, resultUserLoginDetail.getLoginTime());
				
				}
				else if (typeOfObject.equalsIgnoreCase("Error Object"))
				{
					ApiError apiError = (ApiError)userLoginDetailsContainer.getObject();
					assertEquals("Constraint error", apiError.getMessage());
				}
				
				
		 }
	 	
	 	
	 	 @Test
		 public void confirmUserLoginDetailsServiceTest() 
			 {
			 
			 //Test for correct login details
	 		 

				Date date= new Date();
				Timestamp timeStamp = new Timestamp(date.getTime());
				
				UserLoginDetail userLoginDetail = new UserLoginDetail();
				userLoginDetail.setUserEmail("userEmail@gmail.com");
				userLoginDetail.setPassword("Test@2018");
				 DataBinder binder = new DataBinder(userLoginDetail);
					

				 Container<T> userLoginDetailsContainer = userLoginDetailsService.confirmdUserLoginDetails(userLoginDetail,binder.getBindingResult());
				String typeOfObject = userLoginDetailsContainer.getObjectType();
				
				
				if(typeOfObject.equalsIgnoreCase("Class Object"))
				{
				 
					UserLoginDetail resultUserLoginDetail=	(UserLoginDetail)userLoginDetailsContainer.getObject();
				 assertEquals("userEmail@gmail.com", resultUserLoginDetail.getUserEmail());
				 assertEquals("Test@2018", resultUserLoginDetail.getPassword());
				assertEquals(timeStamp, resultUserLoginDetail.getLoginTime());
				
				}
				else if (typeOfObject.equalsIgnoreCase("Error Object"))
				{
					ApiError apiError = (ApiError)userLoginDetailsContainer.getObject();
					assertEquals("Constraint error", apiError.getMessage());
				}
				else if (typeOfObject.equalsIgnoreCase("Null Object"))
				{
					ApiError apiError = (ApiError)userLoginDetailsContainer.getObject();
					assertEquals("Repository returned null", apiError.getStatus());
				
				}
				
			 }
		 
		 
		 @Test
		 public void updateUserPasswordServiceTest() 
			 {
			 
			 //Test for update user password
				UserLoginDetail userLoginDetail = new UserLoginDetail();
				userLoginDetail.setUserEmail("userEmail@gmail.com");
				userLoginDetail.setPassword("Test@2018");
				 DataBinder binder = new DataBinder(userLoginDetail);
					

				 Container<T> userLoginDetailsContainer =  userLoginDetailsService.updateUserPassword(userLoginDetail,binder.getBindingResult());
				String typeOfObject = userLoginDetailsContainer.getObjectType();
				if(typeOfObject.equalsIgnoreCase("Class Object"))
				{
				 
					UserLoginDetail resultUserLoginDetail=	(UserLoginDetail)userLoginDetailsContainer.getObject();
				 assertEquals("userEmail@gmail.com", resultUserLoginDetail.getUserEmail());
				 assertEquals("Test@2018", resultUserLoginDetail.getPassword());
				
				
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

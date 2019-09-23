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
import ca.timisencotech.projectmanagementapis.domain.UserLogin;
import ca.timisencotech.projectmanagementapis.exception.ApiError;
import ca.timisencotech.projectmanagementapis.service.UserLoginService;
import ca.timisencotech.projectmanagementapis.validation.Container;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserLoginServiceImpTest<T>
{
	
	 @Autowired
	 UserLoginService userLoginService;
	

	 	
	 	
	 	 @Test
		 public void confirmUserLoginServiceTest() 
			 {
			 
			 //Test for correct login details
	 		Date date= new Date();
			Timestamp loginTime = new Timestamp(date.getTime());
			
			UserLogin userLogin = new UserLogin();
			userLogin.setLoginTime(loginTime);
			userLogin.setUserEmail("userEmail@gmail.com");
			userLogin.setPassword("Test@2018");
			
					
			 DataBinder binder = new DataBinder(userLogin);
				
				 Container<T> userLoginDetailsContainer = userLoginService.confirmedUserLogin(userLogin,binder.getBindingResult());
				String typeOfObject = userLoginDetailsContainer.getObjectType();
				
				
				if(typeOfObject.equalsIgnoreCase("Class Object"))
				{
				 
					UserLogin resultUserLoginDetail=	(UserLogin)userLoginDetailsContainer.getObject();
				 assertEquals("userEmail@gmail.com", resultUserLoginDetail.getUserEmail());
				 assertEquals("Test@2018", resultUserLoginDetail.getPassword());
				assertEquals(loginTime, resultUserLoginDetail.getLoginTime());
				
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
		 
	
}

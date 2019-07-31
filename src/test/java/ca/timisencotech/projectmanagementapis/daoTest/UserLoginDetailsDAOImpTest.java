package ca.timisencotech.projectmanagementapis.daoTest;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.timisencotech.projectmanagementapis.dao.implementation.UserLoginDetailsDAOImp;
import ca.timisencotech.projectmanagementapis.domain.UserLoginDetail;
import ca.timisencotech.projectmanagementapis.exception.ApiError;
import ca.timisencotech.projectmanagementapis.validation.Container;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserLoginDetailsDAOImpTest<T> {
	
	
	 @Autowired
	 UserLoginDetailsDAOImp userLoginDetailsDAOImp;
	 
 
	 @Test
	 public void addServiceTest() 
		 {
		 Date date= new Date();
			Timestamp timeStamp = new Timestamp(date.getTime());
			
		 
		 UserLoginDetail userLoginDetail = new UserLoginDetail();
			userLoginDetail.setLoginTime(timeStamp);
			userLoginDetail.setUserEmail("userEmail@gmail.com");
			userLoginDetail.setPassword("Test@2018");
			
			
			 Container<T> userLoginDetailsContainer = userLoginDetailsDAOImp.addUserLoginDetails(userLoginDetail);
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
				assertEquals("Constraints error", apiError.getMessage());
			}
			
			
			
		 }
		
	 @Test
	 public void nullAddServiceConstraintTest()
	 {
		
			Date date= new Date();
			Timestamp timeStamp = new Timestamp(date.getTime());
			
			UserLoginDetail userLoginDetail = new UserLoginDetail();
			userLoginDetail.setLoginTime(timeStamp);
			userLoginDetail.setUserEmail("userEmail@gmail.com");
			userLoginDetail.setPassword("Test@2018");
			
			 Container<T> userLoginDetailsContainer = userLoginDetailsDAOImp.addUserLoginDetails(userLoginDetail);
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
			UserLoginDetail userLoginDetail = new UserLoginDetail();
			userLoginDetail.setUserEmail("userEmail@gmail.com");
			userLoginDetail.setPassword("Test@2018");
			

			 Container<T> userLoginDetailsContainer = userLoginDetailsDAOImp.confirmdUserLoginDetails(userLoginDetail);
			String typeOfObject = userLoginDetailsContainer.getObjectType();
			if(typeOfObject.equalsIgnoreCase("Class Object"))
			{
			 
				UserLoginDetail resultUserLoginDetail=	(UserLoginDetail)userLoginDetailsContainer.getObject();
			 assertEquals("userEmail@gmail.com", resultUserLoginDetail.getUserEmail());
			 assertEquals("Test@2018", resultUserLoginDetail.getPassword());
			// assertEquals(timeStamp, resultUserLoginDetail.getLoginTime());
			
			}
			else if (typeOfObject.equalsIgnoreCase("Error Object"))
			{
				ApiError apiError = (ApiError)userLoginDetailsContainer.getObject();
				assertEquals("Constraint error", apiError.getMessage());
			}
			
			//Test for incorrect login details
			UserLoginDetail incorrectUserLoginDetail = new UserLoginDetail();
			incorrectUserLoginDetail.setUserEmail("userEmail@gmail.com");
			incorrectUserLoginDetail.setPassword("Test@2018");
			

			  userLoginDetailsContainer = userLoginDetailsDAOImp.confirmdUserLoginDetails(incorrectUserLoginDetail);
			 typeOfObject = userLoginDetailsContainer.getObjectType();
			if(typeOfObject.equalsIgnoreCase("Class Object"))
			{
			 
				UserLoginDetail resultUserLoginDetail=	(UserLoginDetail)userLoginDetailsContainer.getObject();
			 assertEquals("userEmail@gmail.com", resultUserLoginDetail.getUserEmail());
			 assertEquals("Test@2018", resultUserLoginDetail.getPassword());
			// assertEquals(timeStamp, resultUserLoginDetail.getLoginTime());
			
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

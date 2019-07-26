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
	 
		 

}

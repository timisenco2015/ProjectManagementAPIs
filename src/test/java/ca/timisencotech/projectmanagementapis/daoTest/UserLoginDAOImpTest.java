package ca.timisencotech.projectmanagementapis.daoTest;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.timisencotech.projectmanagementapis.dao.implementation.UserLoginDAOImp;
import ca.timisencotech.projectmanagementapis.dao.implementation.UserSignUpDAOImp;
import ca.timisencotech.projectmanagementapis.domain.UserLogin;
import ca.timisencotech.projectmanagementapis.exception.ApiError;
import ca.timisencotech.projectmanagementapis.validation.Container;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserLoginDAOImpTest<T> {
	
	
	 @Autowired
	 UserLoginDAOImp userLoginDAOImp;
	 
	 @Autowired
	 UserSignUpDAOImp userSignUpDAOImp;
	 
	
	

	 
	 
	 @Test
	 public void confirmUserLoginDetailsServiceTest() 
		 {
		 
		 //Test for correct login details
	 
		 
		Date date= new Date();
		Timestamp loginTime = new Timestamp(date.getTime());
			
		UserLogin userLogin = new UserLogin();
		 userLogin.setUserEmail("userEmail@gmail.com");
		 userLogin.setPassword("Test@2022");
		 userLogin.setLoginTime(loginTime);
		 
		 Container<T> userLoginDetailsContainer =  userLoginDAOImp.confirmedUserLogin(userLogin);
			String typeOfObject = userLoginDetailsContainer.getObjectType();
			if(typeOfObject.equalsIgnoreCase("Class Object"))
			{
			 
				UserLogin resultUserLoginDetail=	(UserLogin)userLoginDetailsContainer.getObject();
			 assertEquals("userEmail@gmail.com", resultUserLoginDetail.getUserEmail());
			 assertEquals("Test@2022", resultUserLoginDetail.getPassword());
			 assertEquals(loginTime, resultUserLoginDetail.getLoginTime());
			
			}
		
			
			
			//Test for incorrect login details
			UserLogin incorrectUserLoginDetail = new UserLogin();
			incorrectUserLoginDetail.setUserEmail("userEmail@gmail.com");
			incorrectUserLoginDetail.setPassword("Test@2024");
			

			  userLoginDetailsContainer = userLoginDAOImp.confirmedUserLogin(incorrectUserLoginDetail);
			 typeOfObject = userLoginDetailsContainer.getObjectType();
		 if (typeOfObject.equalsIgnoreCase("Null Object"))
			{
			 
				ApiError apiError = (ApiError)userLoginDetailsContainer.getObject();
				assertEquals("Incorrect login details user email: userEmail@gmail.comand password:Test@2024", apiError.getMessage());
			
			}
		 }
		 
		 
		

}

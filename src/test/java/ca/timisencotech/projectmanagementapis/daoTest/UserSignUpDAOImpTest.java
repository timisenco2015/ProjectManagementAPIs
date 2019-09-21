package ca.timisencotech.projectmanagementapis.daoTest;

import static org.junit.Assert.assertEquals;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.timisencotech.projectmanagementapis.dao.implementation.UserSignUpDAOImp;
import ca.timisencotech.projectmanagementapis.domain.UserSignUp;
import ca.timisencotech.projectmanagementapis.exception.ApiError;
import ca.timisencotech.projectmanagementapis.validation.Container;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserSignUpDAOImpTest<T> {
	
	
	 @Autowired
	 UserSignUpDAOImp userSignUpDAOImp;
	 
 
	 @Test
	 public void addUserSignUpDetailTest() 
		 {
		
		 UserSignUp userSignUp = new UserSignUp();
			
		 userSignUp.setUserEmail("userEmail@gmail.com");
		 userSignUp.setPassword("Test@2022");
			
			
			 Container<T> userSignUpDetailContainer = userSignUpDAOImp.addUserSignUpDetails(userSignUp);
			String typeOfObject = userSignUpDetailContainer.getObjectType();
			if(typeOfObject.equalsIgnoreCase("Class Object"))
			{
			 
				UserSignUp resultUserSignUpDetail=	(UserSignUp)userSignUpDetailContainer.getObject();
			 assertEquals("userEmail@gmail.com", resultUserSignUpDetail.getUserEmail());
			 assertEquals("Test@2022", resultUserSignUpDetail.getPassword());
			}
			else if (typeOfObject.equalsIgnoreCase("Error Object"))
			{
				ApiError apiError = (ApiError)userSignUpDetailContainer.getObject();
				assertEquals("Persistence Error", apiError.getStatus());
			}
			
			
			
		 }
		
	 @Test
	 public void addUserSignUpDetailsNullConstraintTest()
	 {
		
		 UserSignUp userSignUp = new UserSignUp();
			
		 userSignUp.setUserEmail("userEmail@gmail.com");
		// userSignUpDetail.setPassword("Test@2022");
			
			
		 Container<T> userSignUpDetailContainer = userSignUpDAOImp.addUserSignUpDetails(userSignUp);
			String typeOfObject = userSignUpDetailContainer.getObjectType();
			if(typeOfObject.equalsIgnoreCase("Class Object"))
			{
			 
				UserSignUp resultUserSignUpDetail=	(UserSignUp)userSignUpDetailContainer.getObject();
			 assertEquals("userEmail@gmail.com", resultUserSignUpDetail.getUserEmail());
			
			
			}
			else if (typeOfObject.equalsIgnoreCase("Error Object"))
			{
				ApiError apiError = (ApiError)userSignUpDetailContainer.getObject();
				assertEquals("Persistence Error", apiError.getStatus());
			}
			
			
	 }
	 
	
	 
	 
	 @Test
	 public void updateUserPassworTest() 
		 {
		 
		 //Test for correct login details
		
		 
			UserSignUp userSignUp = new UserSignUp();
			
			 userSignUp.setUserEmail("userEmail@gmail.com");
			 userSignUp.setPassword("Test@2018");
			

			 Container<T> userSignUpDetailsContainer =userSignUpDAOImp.updateUserPassword(userSignUp);
			String typeOfObject = userSignUpDetailsContainer.getObjectType();
			if(typeOfObject.equalsIgnoreCase("Class Object"))
			{
			 
				UserSignUp resultUserSignUpDetail=(UserSignUp)userSignUpDetailsContainer.getObject();
			 assertEquals("userEmail@gmail.com", resultUserSignUpDetail.getUserEmail());
			 assertEquals("Test@2018", resultUserSignUpDetail.getPassword());
			
			}
			else if (typeOfObject.equalsIgnoreCase("Error Object"))
			{
				ApiError apiError = (ApiError)userSignUpDetailsContainer.getObject();
				assertEquals("Persistence Error", apiError.getMessage());
			}
			
		
			
		 }
	 
	 
	

}

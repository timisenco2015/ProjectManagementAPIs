package ca.timisencotech.projectmanagementapis.daoTest;

import static org.junit.Assert.assertEquals;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.timisencotech.projectmanagementapis.dao.implementation.UserSignUpDetailsDAOImp;
import ca.timisencotech.projectmanagementapis.domain.UserSignUpDetail;
import ca.timisencotech.projectmanagementapis.exception.ApiError;
import ca.timisencotech.projectmanagementapis.validation.Container;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserSignUpDetailsDAOImpTest<T> {
	
	
	 @Autowired
	 UserSignUpDetailsDAOImp userSignUpDetailsDAOImp;
	 
 
	 @Test
	 public void addUserSignUpDetailTest() 
		 {
		
		 UserSignUpDetail userSignUpDetail = new UserSignUpDetail();
			
		 userSignUpDetail.setUserEmail("userEmail@gmail.com");
		 userSignUpDetail.setPassword("Test@2022");
			
			
			 Container<T> userSignUpDetailContainer = userSignUpDetailsDAOImp.addUserSignUpDetails(userSignUpDetail);
			String typeOfObject = userSignUpDetailContainer.getObjectType();
			if(typeOfObject.equalsIgnoreCase("Class Object"))
			{
			 
				UserSignUpDetail resultUserSignUpDetail=	(UserSignUpDetail)userSignUpDetailContainer.getObject();
			 assertEquals("userEmail@gmail.com", resultUserSignUpDetail.getUserEmail());
			 assertEquals("Test@2022", resultUserSignUpDetail.getPassword());
			}
			else if (typeOfObject.equalsIgnoreCase("Error Object"))
			{
				ApiError apiError = (ApiError)userSignUpDetailContainer.getObject();
				assertEquals("Constraints error", apiError.getMessage());
			}
			
			
			
		 }
		
	 @Test
	 public void addUserSignUpDetailsNullConstraintTest()
	 {
		
		 UserSignUpDetail userSignUpDetail = new UserSignUpDetail();
			
		 userSignUpDetail.setUserEmail("userEmail@gmail.com");
		// userSignUpDetail.setPassword("Test@2022");
			
			
		 Container<T> userSignUpDetailContainer = userSignUpDetailsDAOImp.addUserSignUpDetails(userSignUpDetail);
			String typeOfObject = userSignUpDetailContainer.getObjectType();
			if(typeOfObject.equalsIgnoreCase("Class Object"))
			{
			 
				UserSignUpDetail resultUserSignUpDetail=	(UserSignUpDetail)userSignUpDetailContainer.getObject();
			 assertEquals("userEmail@gmail.com", resultUserSignUpDetail.getUserEmail());
			
			
			}
			else if (typeOfObject.equalsIgnoreCase("Error Object"))
			{
				ApiError apiError = (ApiError)userSignUpDetailContainer.getObject();
				assertEquals("Constraint error", apiError.getMessage());
			}
			
			
	 }
	 
	
	 
	 
	 @Test
	 public void updateUserPassworTest() 
		 {
		 
		 //Test for correct login details
		
		 
			UserSignUpDetail userSignUpDetail = new UserSignUpDetail();
			
			 userSignUpDetail.setUserEmail("userEmail@gmail.com");
			 userSignUpDetail.setPassword("Test@2018");
			

			 Container<T> userSignUpDetailsContainer =userSignUpDetailsDAOImp.updateUserPassword(userSignUpDetail);
			String typeOfObject = userSignUpDetailsContainer.getObjectType();
			if(typeOfObject.equalsIgnoreCase("Class Object"))
			{
			 
				UserSignUpDetail resultUserSignUpDetail=(UserSignUpDetail)userSignUpDetailsContainer.getObject();
			 assertEquals("userEmail@gmail.com", resultUserSignUpDetail.getUserEmail());
			 assertEquals("Test@2018", resultUserSignUpDetail.getPassword());
			
			}
			else if (typeOfObject.equalsIgnoreCase("Error Object"))
			{
				ApiError apiError = (ApiError)userSignUpDetailsContainer.getObject();
				assertEquals("Constraint error", apiError.getMessage());
			}
			
		
			
		 }
	 
	 
	

}

package ca.timisencotech.projectmanagementapis.daoTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.timisencotech.projectmanagementapis.dao.implementation.UserDetailsDAOImp;
import ca.timisencotech.projectmanagementapis.domain.User;
import ca.timisencotech.projectmanagementapis.dto.UserSignUpDetails;
import ca.timisencotech.projectmanagementapis.exception.ApiError;
import ca.timisencotech.projectmanagementapis.validation.Container;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDAOImpTest<T> {
	
	
	 @Autowired
	 UserDetailsDAOImp userDetailsDAOImp;
	 
 
	 
		private void addNewUserServiceTest() 
		 {
	
		
		 User user = new User();
		 user.setFirstName("Ayobami");
		 user.setMiddleName("O");
		 user.setLastName("Idowu");
		 user.setPhoneNo("2049623752");
		 user.setUserAddress("616 Armitgae Crescent, Sherwood Park, Alberta. T8H 0T7");
		user.setUserEmail("userEmail@gmail.com");	
		user.setUserGender("Male");
		
			 Container<T> userDetailsContainer = userDetailsDAOImp.addNewUser(user);
			String typeOfObject = userDetailsContainer.getObjectType();
			if(typeOfObject.equalsIgnoreCase("Class Object"))
			{
			 
				User resultUserDetail=	(User)userDetailsContainer.getObject();
		
			 assertEquals("Ayobami", resultUserDetail.getFirstName());
			 assertEquals("O", resultUserDetail.getMiddleName());
			 assertEquals("Idowu", resultUserDetail.getLastName());
			 assertEquals("2049623752", resultUserDetail.getPhoneNo());
			 assertEquals("616 Armitgae Crescent, Sherwood Park, Alberta. T8H 0T7", resultUserDetail.getUserAddress());
			 assertEquals("userEmail@gmail.com", resultUserDetail.getUserEmail());
			 assertEquals("Male", resultUserDetail.getUserGender());
			}
			else if (typeOfObject.equalsIgnoreCase("Error Object"))
			{
				ApiError apiError = (ApiError)userDetailsContainer.getObject();
				assertEquals("Persistence Error", apiError.getStatus());
				 
			}
			
			
			
		 }
		

	 
	 @Test
		public void addNewUserConstraintErrorTest() 
		 {
			
		//checks for phone field unique test
		 //addNewUserUniquePhoneConstraintTest();
		
		 //checks for add new user test
		 addNewUserServiceTest();
		 
		 //checks if user has already sign up
		// addNewUserEmailNullValueConstraintTest();
			
		 }
		 

	
		 
		 private void addNewUserUniquePhoneConstraintTest()
		 {
			
			 User user = new User();
			 
			 user.setFirstName("Ayobamii");
			 user.setMiddleName("O");
			 user.setLastName("Idowu");
			 user.setPhoneNo("2049623752");
			 user.setUserAddress("616 Armitgae Crescent, Sherwood Park, Alberta. T8H 0T7");
			user.setUserEmail("checkidowu@gmail.com");	
			user.setUserGender("Male");
				 Container<T> userDetailsContainer = userDetailsDAOImp.addNewUser(user);
				String typeOfObject = userDetailsContainer.getObjectType();
			 if (typeOfObject.equalsIgnoreCase("Error Object"))
				{
				
					ApiError apiError = (ApiError)userDetailsContainer.getObject();
					assertEquals("Constraint error", apiError.getMessage());
				
				}
				
				
				
		 }
		 
		 
		 private void addNewUserEmailNullValueConstraintTest()
		 {
			
			 User user = new User();
			 
			 user.setFirstName("Ayobamii");
			 user.setMiddleName("O");
			 user.setLastName("Idowu");
			 user.setPhoneNo("2049623752");
			 user.setUserAddress("616 Armitgae Crescent, Sherwood Park, Alberta. T8H 0T7");
			user.setUserEmail("checkAidowu@gmail.com");	
			user.setUserGender("Male");
				 Container<T> userDetailsContainer = userDetailsDAOImp.addNewUser(user);
				String typeOfObject = userDetailsContainer.getObjectType();
				 if (typeOfObject.equalsIgnoreCase("Null Object"))
					{
						ApiError apiError = (ApiError)userDetailsContainer.getObject();
						assertEquals("We dont have this user email: checkAidowu@gmail.com in our database", apiError.getMessage());
					}
			
		 }
		 
		 

}

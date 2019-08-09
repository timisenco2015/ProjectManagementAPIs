package ca.timisencotech.projectmanagementapis.daoTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.timisencotech.projectmanagementapis.dao.implementation.UserDetailsDAOImp;
import ca.timisencotech.projectmanagementapis.domain.UserDetail;
import ca.timisencotech.projectmanagementapis.exception.ApiError;
import ca.timisencotech.projectmanagementapis.validation.Container;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDetailsDAOImpTest<T> {
	
	
	 @Autowired
	 UserDetailsDAOImp userDetailsDAOImp;
	 
 
	 
		private void addNewUserServiceTest() 
		 {
	
		 
		 UserDetail userDetail = new UserDetail();
		 userDetail.setFirstName("Ayobami");
		 userDetail.setMiddleName("O");
		 userDetail.setLastName("Idowu");
		 userDetail.setPhoneNo("2049623752");
		 userDetail.setUserAddress("616 Armitgae Crescent, Sherwood Park, Alberta. T8H 0T7");
		userDetail.setUserEmail("userEmail@gmail.com");	
		userDetail.setUserGender("Male");
			 Container<T> userDetailsContainer = userDetailsDAOImp.addNewUser(userDetail);
			String typeOfObject = userDetailsContainer.getObjectType();
			if(typeOfObject.equalsIgnoreCase("Class Object"))
			{
			 
				UserDetail resultUserDetail=	(UserDetail)userDetailsContainer.getObject();
		
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
		 addNewUserUniquePhoneConstraintTest();
		
		 //checks for add new user test
		 addNewUserServiceTest();
		 
		 //checks if user has already sign up
		 addNewUserEmailNullValueConstraintTest();
			
		 }
		 

	
		 
		 private void addNewUserUniquePhoneConstraintTest()
		 {
			
			 UserDetail userDetail = new UserDetail();
			 
			 userDetail.setFirstName("Ayobamii");
			 userDetail.setMiddleName("O");
			 userDetail.setLastName("Idowu");
			 userDetail.setPhoneNo("2049623752");
			 userDetail.setUserAddress("616 Armitgae Crescent, Sherwood Park, Alberta. T8H 0T7");
			userDetail.setUserEmail("checkidowu@gmail.com");	
			userDetail.setUserGender("Male");
				 Container<T> userDetailsContainer = userDetailsDAOImp.addNewUser(userDetail);
				String typeOfObject = userDetailsContainer.getObjectType();
			 if (typeOfObject.equalsIgnoreCase("Error Object"))
				{
				
					ApiError apiError = (ApiError)userDetailsContainer.getObject();
					assertEquals("Constraint error", apiError.getMessage());
				
				}
				
				
				
		 }
		 
		 
		 private void addNewUserEmailNullValueConstraintTest()
		 {
			
			 UserDetail userDetail = new UserDetail();
			 
			 userDetail.setFirstName("Ayobamii");
			 userDetail.setMiddleName("O");
			 userDetail.setLastName("Idowu");
			 userDetail.setPhoneNo("2049623752");
			 userDetail.setUserAddress("616 Armitgae Crescent, Sherwood Park, Alberta. T8H 0T7");
			userDetail.setUserEmail("checkAidowu@gmail.com");	
			userDetail.setUserGender("Male");
				 Container<T> userDetailsContainer = userDetailsDAOImp.addNewUser(userDetail);
				String typeOfObject = userDetailsContainer.getObjectType();
				 if (typeOfObject.equalsIgnoreCase("Null Object"))
					{
						ApiError apiError = (ApiError)userDetailsContainer.getObject();
						assertEquals("We dont have this user email: ayoidowu@gmail.com  in our database", apiError.getMessage());
					}
			
		 }
		 
		 

}

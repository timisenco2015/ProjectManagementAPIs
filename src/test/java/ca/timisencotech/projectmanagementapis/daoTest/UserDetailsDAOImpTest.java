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
	 
 
	 @Test
		public void addServiceTest() 
		 {
	
		 
		 UserDetail userDetail = new UserDetail();
		 
		// userDetail.setCountryPhoneCode("+1");
		 userDetail.setFirstName("Ayobami");
		 userDetail.setMiddleName("O");
		 userDetail.setLastName("Idowu");
		 userDetail.setPhoneNo("2049623752");
		 userDetail.setUserAddress("616 Armitgae Crescent, Sherwood Park, Alberta. T8H 0T7");
		userDetail.setUserEmail("ayobami.o.idowu@gmail.com");	
		userDetail.setUserGender("Male");
			 Container<T> userDetailsContainer = userDetailsDAOImp.addNewUser(userDetail);
			String typeOfObject = userDetailsContainer.getObjectType();
			if(typeOfObject.equalsIgnoreCase("Class Object"))
			{
			 
				UserDetail resultUserDetail=	(UserDetail)userDetailsContainer.getObject();
			// assertEquals("+1", resultUserDetail.getCountryPhoneCode());
			 assertEquals("Ayobami", resultUserDetail.getFirstName());
			 assertEquals("O", resultUserDetail.getMiddleName());
			 assertEquals("Idowu", resultUserDetail.getLastName());
			 assertEquals("2049623752", resultUserDetail.getPhoneNo());
			 assertEquals("616 Armitgae Crescent, Sherwood Park, Alberta. T8H 0T7", resultUserDetail.getUserAddress());
			 assertEquals("ayobami.o.idowu@gmail.com", resultUserDetail.getUserEmail());
			 assertEquals("Male", resultUserDetail.getUserGender());
			}
			else if (typeOfObject.equalsIgnoreCase("Error Object"))
			{
				ApiError apiError = (ApiError)userDetailsContainer.getObject();
				assertEquals("Constraint error", apiError.getMessage());
			}
			
			
			
		 }
		

	 
	 @Test
		public void addServiceConstraintErrorTest() 
		 {
			
		//checks for field(s) unique test
		 uniqueConstraintTest();
		
		 //checks for field(s) null test
		 nullConstraintTest();
			
		 }
		 

		 private void nullConstraintTest()
		 {
			
			 UserDetail userDetail = new UserDetail();
			 
			// userDetail.setCountryPhoneCode("+1");
			 userDetail.setFirstName("Ayobami");
			 userDetail.setMiddleName("O");
			 userDetail.setLastName("Idowu");
		
			 userDetail.setUserAddress("616 Armitgae Crescent, Sherwood Park, Alberta. T8H 0T7");
			userDetail.setUserEmail("ayobami.o.idowu@gmail.com");	
			userDetail.setUserGender("Male");
				 Container<T> userDetailsContainer = userDetailsDAOImp.addNewUser(userDetail);
				String typeOfObject = userDetailsContainer.getObjectType();
				if(typeOfObject.equalsIgnoreCase("Class Object"))
				{
				 
					UserDetail resultUserDetail=	(UserDetail)userDetailsContainer.getObject();
			//	 assertEquals("+1", resultUserDetail.getCountryPhoneCode());
				 assertEquals("Ayobami", resultUserDetail.getFirstName());
				 assertEquals("O", resultUserDetail.getMiddleName());
				 assertEquals("Idowu", resultUserDetail.getLastName());
				
				 assertEquals("616 Armitgae Crescent, Sherwood Park, Alberta. T8H 0T7", resultUserDetail.getUserAddress());
				 assertEquals("ayobami.o.idowu@gmail.com", resultUserDetail.getUserEmail());
				 assertEquals("Male", resultUserDetail.getUserGender());
				}
				else if (typeOfObject.equalsIgnoreCase("Error Object"))
				{
					ApiError apiError = (ApiError)userDetailsContainer.getObject();
					assertEquals("Constraint error", apiError.getMessage());
				}
				
				
		 }
		 
		 private void uniqueConstraintTest()
		 {
			
			 UserDetail userDetail = new UserDetail();
			 
			// userDetail.setCountryPhoneCode("+1");
			 userDetail.setFirstName("Ayobamii");
			 userDetail.setMiddleName("O");
			 userDetail.setLastName("Idowu");
			 userDetail.setPhoneNo("2049623752");
			 userDetail.setUserAddress("616 Armitgae Crescent, Sherwood Park, Alberta. T8H 0T7");
			userDetail.setUserEmail("check.o.idowu@gmail.com");	
			userDetail.setUserGender("Male");
				 Container<T> userDetailsContainer = userDetailsDAOImp.addNewUser(userDetail);
				String typeOfObject = userDetailsContainer.getObjectType();
				if(typeOfObject.equalsIgnoreCase("Class Object"))
				{
				 
					UserDetail resultUserDetail=	(UserDetail)userDetailsContainer.getObject();
				// assertEquals("+1", resultUserDetail.getCountryPhoneCode());
				 assertEquals("Ayobamii", resultUserDetail.getFirstName());
				 assertEquals("O", resultUserDetail.getMiddleName());
				 assertEquals("Idowu", resultUserDetail.getLastName());
				 assertEquals("2049623752", resultUserDetail.getPhoneNo());
				 assertEquals("616 Armitgae Crescent, Sherwood Park, Alberta. T8H 0T7", resultUserDetail.getUserAddress());
				 assertEquals("ayobami.o.idowu@gmail.com", resultUserDetail.getUserEmail());
				 assertEquals("Male", resultUserDetail.getUserGender());
				}
				else if (typeOfObject.equalsIgnoreCase("Error Object"))
				{
				
					ApiError apiError = (ApiError)userDetailsContainer.getObject();
					assertEquals("Constraint error", apiError.getMessage());
				}
				
				
				
		 }
		 

}

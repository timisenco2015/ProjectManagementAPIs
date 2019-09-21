package ca.timisencotech.projectmanagementapis.dao.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import ca.timisencotech.projectmanagementapis.exception.ApiError;
import ca.timisencotech.projectmanagementapis.Application;
import ca.timisencotech.projectmanagementapis.dao.UserDAO;
import ca.timisencotech.projectmanagementapis.domain.User;
import ca.timisencotech.projectmanagementapis.dto.UserDetails;
import ca.timisencotech.projectmanagementapis.dto.UserSignUpDetails;
import ca.timisencotech.projectmanagementapis.exception.PersistentException;
import ca.timisencotech.projectmanagementapis.repository.UserRepository;
import ca.timisencotech.projectmanagementapis.repository.UserSignUpRepository;
import ca.timisencotech.projectmanagementapis.validation.Container;

@Repository
public class UserDetailsDAOImp implements UserDAO {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserSignUpRepository userSignUpRepository;
	
	PersistentException persistentException = new PersistentException();

	@SuppressWarnings("unchecked")
	@Override
	public <T> Container<T> addNewUser(User user) {
		Container<T> genericObject=null; 
		
		UserSignUpDetails findUserSignUpDetails = userSignUpRepository.findUserSignUpDetailsByEmail(user.getUserEmail());
			
		if(findUserSignUpDetails==null)
		{
			genericObject = (Container<T>) new  Container<ApiError> (persistentException.handleSearchReturnNull("We dont have this user email: "+user.getUserEmail()+" in our database"),"Null Object");
		Application.getLogger().info("addNewUser method in UserDetails DAO Implementation. At this point unable to find foreign key email in the database");
			
		}
		else
		{
			UserDetails newUserDetails = new UserDetails();
		newUserDetails.setUserSignUpDetails(findUserSignUpDetails);
		newUserDetails.setFirstName(user.getFirstName());
		newUserDetails.setLastName(user.getLastName());
		newUserDetails.setGender(user.getUserGender());
		newUserDetails.setMiddleName(user.getMiddleName());
		newUserDetails.setPhoneNo(user.getPhoneNo());
		newUserDetails.setAddress(user.getUserAddress());
	
		
		UserDetails responseUserDetails = null;
			 try {
				 
				 responseUserDetails = userRepository.save(newUserDetails);
				 User domainUserDetail = new User();
				 domainUserDetail.setFirstName(responseUserDetails.getFirstName());
				 domainUserDetail.setLastName(responseUserDetails.getLastName());
				 domainUserDetail.setMiddleName(responseUserDetails.getMiddleName());
				 domainUserDetail.setPhoneNo(responseUserDetails.getPhoneNo());
				 domainUserDetail.setUserAddress(responseUserDetails.getAddress());
				 domainUserDetail.setUserEmail(user.getUserEmail());
				 domainUserDetail.setUserGender(responseUserDetails.getGender());
				 Application.getLogger().info("addNewUser method in UserDetails DAO Implementation. At this point new user has successful saved to the database. Return userdetails from repo is"+domainUserDetail);
				
					
				 genericObject = (Container<T>) new Container<User>(domainUserDetail,"Class Object");
				 } 
			 
		
			 
			 catch (DataAccessException dataAccessException) {
				 Application.getLogger().info("addNewUser method in UserDetails DAO Implementation. At this point there is an error that has prevented saving new user to the database");
				 
				 genericObject = (Container<T>) new  Container<ApiError> (persistentException.handleDataAccessException((DataAccessException)dataAccessException),"Error Object");
			
			 }
		}
	
		return genericObject;
	}


}

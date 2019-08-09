package ca.timisencotech.projectmanagementapis.dao.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import ca.timisencotech.projectmanagementapis.exception.ApiError;
import ca.timisencotech.projectmanagementapis.Application;
import ca.timisencotech.projectmanagementapis.dao.UserDetailsDAO;
import ca.timisencotech.projectmanagementapis.domain.UserDetail;
import ca.timisencotech.projectmanagementapis.dto.UserDetails;
import ca.timisencotech.projectmanagementapis.dto.UserSignUpDetails;
import ca.timisencotech.projectmanagementapis.exception.PersistentException;
import ca.timisencotech.projectmanagementapis.repository.UserDetailsRepository;
import ca.timisencotech.projectmanagementapis.repository.UserSignUpDetailsRepository;
import ca.timisencotech.projectmanagementapis.validation.Container;

@Repository
public class UserDetailsDAOImp implements UserDetailsDAO {
	
	@Autowired
	UserDetailsRepository userDetailsRepository;
	
	@Autowired
	UserSignUpDetailsRepository userSignUpDetailsRepository;
	
	PersistentException persistentException = new PersistentException();

	@SuppressWarnings("unchecked")
	@Override
	public <T> Container<T> addNewUser(UserDetail userDetail) {
		Container<T> genericObject=null; 
		UserSignUpDetails findUserLoginDetails = userSignUpDetailsRepository.findByEmail(userDetail.getUserEmail());
			
		if(findUserLoginDetails==null)
		{
			genericObject = (Container<T>) new  Container<ApiError> (persistentException.handleSearchReturnNull("We dont have this user email: "+userDetail.getUserEmail()+" in our database"),"Null Object");
		Application.getLogger().info("addNewUser method in UserDetails DAO Implementation. At this point unable to find foreign key email in the database");
			
		}
		else
		{
			UserDetails newUserDetails = new UserDetails();
		newUserDetails.setUserSignUpDetails(findUserLoginDetails);
		newUserDetails.setFirstName(userDetail.getFirstName());
		newUserDetails.setLastName(userDetail.getLastName());
		newUserDetails.setGender(userDetail.getUserGender());
		newUserDetails.setMiddleName(userDetail.getMiddleName());
		newUserDetails.setPhoneNo(userDetail.getPhoneNo());
		newUserDetails.setAddress(userDetail.getUserAddress());
	
		
		UserDetails responseUserDetails = null;
			 try {
				 
				 responseUserDetails = userDetailsRepository.save(newUserDetails);
				 UserDetail domainUserDetail = new UserDetail();
				 domainUserDetail.setFirstName(responseUserDetails.getFirstName());
				 domainUserDetail.setLastName(responseUserDetails.getLastName());
				 domainUserDetail.setMiddleName(responseUserDetails.getMiddleName());
				 domainUserDetail.setPhoneNo(responseUserDetails.getPhoneNo());
				 domainUserDetail.setUserAddress(responseUserDetails.getAddress());
				 domainUserDetail.setUserEmail(userDetail.getUserEmail());
				 domainUserDetail.setUserGender(responseUserDetails.getGender());
				 Application.getLogger().info("addNewUser method in UserDetails DAO Implementation. At this point new user has successful saved to the database. Return userdetails from repo is"+domainUserDetail);
				
					
				 genericObject = (Container<T>) new Container<UserDetail>(domainUserDetail,"Class Object");
				 } 
			 
		
			 
			 catch (DataAccessException dataAccessException) {
				 Application.getLogger().info("addNewUser method in UserDetails DAO Implementation. At this point there is an error that has prevented saving new user to the database");
				 
				 genericObject = (Container<T>) new  Container<ApiError> (persistentException.handleDataAccessException((DataAccessException)dataAccessException),"Error Object");
			
			 }
		}
	
		return genericObject;
	}


}

package ca.timisencotech.projectmanagementapis.dao.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import ca.timisencotech.projectmanagementapis.exception.ApiError;
import ca.timisencotech.projectmanagementapis.Application;
import ca.timisencotech.projectmanagementapis.dao.UserDetailsDAO;
import ca.timisencotech.projectmanagementapis.domain.UserDetail;
import ca.timisencotech.projectmanagementapis.dto.UserDetails;
import ca.timisencotech.projectmanagementapis.dto.UserLoginDetails;
import ca.timisencotech.projectmanagementapis.exception.PersistentException;
import ca.timisencotech.projectmanagementapis.repository.UserDetailsRepository;
import ca.timisencotech.projectmanagementapis.repository.UserLoginDetailsRepository;
import ca.timisencotech.projectmanagementapis.validation.Container;

@Repository
public class UserDetailsDAOImp implements UserDetailsDAO {
	
	@Autowired
	UserDetailsRepository userDetailsRepository;
	
	@Autowired
	UserLoginDetailsRepository userLoginDetailsRepository;
	
	PersistentException persistentException = new PersistentException();

	@SuppressWarnings("unchecked")
	@Override
	public <T> Container<T> addNewUser(UserDetail userDetail) {
		Container<T> genericObject=null; 
		UserLoginDetails findUserLoginDetails = userLoginDetailsRepository.findByEmail(userDetail.getUserEmail());
		if(findUserLoginDetails==null)
		{
			genericObject = (Container<T>) new  Container<ApiError> (persistentException.handleSearchReturnNull("We dont have this state or province Id: "+userDetail.getUserEmail()+" in our database"),"Error Object");
			Application.getLogger().info("addCities method in Cities DAO Implementation. At this point unable to find foreign key statePronvinceId in the database");
			
		}
		else
		{
		UserDetails newUserDetails = new UserDetails();
		newUserDetails.setUserLoginDetails(findUserLoginDetails);
		newUserDetails.setFirstName(userDetail.getFirstName());
		newUserDetails.setLastName(userDetail.getLastName());
		newUserDetails.setUserGender(userDetail.getUserGender());
		newUserDetails.setMiddleName(userDetail.getMiddleName());
		newUserDetails.setCountryPhoneCode(userDetail.getCountryPhoneCode());
		newUserDetails.setPhoneNo(userDetail.getPhoneNo());
		newUserDetails.setUserAddress(userDetail.getUserAddress());
		
		UserDetails responseUserDetails = null;
			 try {
				 
				 responseUserDetails = userDetailsRepository.save(newUserDetails);
				 UserDetail domainUserDetail = new UserDetail();
				 domainUserDetail.setCountryPhoneCode(responseUserDetails.getCountryPhoneCode());
				 domainUserDetail.setFirstName(responseUserDetails.getFirstName());
				 domainUserDetail.setLastName(responseUserDetails.getLastName());
				 domainUserDetail.setMiddleName(responseUserDetails.getMiddleName());
				 domainUserDetail.setPhoneNo(responseUserDetails.getPhoneNo());
				 domainUserDetail.setUserAddress(responseUserDetails.getUserAddress());
				 domainUserDetail.setUserEmail(userDetail.getUserEmail());
				 domainUserDetail.setUserGender(responseUserDetails.getUserGender());
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

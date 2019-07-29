package ca.timisencotech.projectmanagementapis.dao.implementation;

import java.sql.Timestamp;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import ca.timisencotech.projectmanagementapis.exception.ApiError;
import ca.timisencotech.projectmanagementapis.Application;
import ca.timisencotech.projectmanagementapis.dao.UserLoginDetailsDAO;
import ca.timisencotech.projectmanagementapis.domain.UserLoginDetail;
import ca.timisencotech.projectmanagementapis.dto.UserLoginDetails;
import ca.timisencotech.projectmanagementapis.exception.PersistentException;
import ca.timisencotech.projectmanagementapis.repository.UserDetailsRepository;
import ca.timisencotech.projectmanagementapis.repository.UserLoginDetailsRepository;
import ca.timisencotech.projectmanagementapis.validation.Container;

@Repository
public class UserLoginDetailsDAOImp implements UserLoginDetailsDAO {
	
	@Autowired
	UserLoginDetailsRepository userLoginDetailsRepository;
	
	@Autowired
	UserDetailsRepository userDetailsRepository;
	
	PersistentException persistentException = new PersistentException();

	@SuppressWarnings("unchecked")
	@Override
	public <T> Container<T> addUserLoginDetails(UserLoginDetail userLoginDetail) {
		Container<T> genericObject=null; 
		
		Date date= new Date();
		Timestamp timeStamp = new Timestamp(date.getTime());
		
		UserLoginDetails newUserLoginDetails = new UserLoginDetails();
		newUserLoginDetails.setPassword(userLoginDetail.getPassword());
		newUserLoginDetails.setLoginTime(timeStamp);
		newUserLoginDetails.setUserEmail(userLoginDetail.getUserEmail());
		
			 try {
				 
				 UserLoginDetails responseUserDetails = userLoginDetailsRepository.save(newUserLoginDetails);
				 UserLoginDetail domainUserLoginDetail = new UserLoginDetail();
				 domainUserLoginDetail.setLoginTime(responseUserDetails.getLoginTime());
				 domainUserLoginDetail.setPassword(responseUserDetails.getPassword());
				 domainUserLoginDetail.setUserEmail(responseUserDetails.getUserEmail());
				 
				 Application.getLogger().info("addNewUser method in UserDetails DAO Implementation. At this point new user has successful saved to the database. Return userdetails from repo is"+domainUserLoginDetail);
				 
				 genericObject = (Container<T>) new Container<UserLoginDetail>(domainUserLoginDetail,"Class Object");
			    } 
			 
		
			 
			 catch (DataAccessException dataAccessException) {
				 Application.getLogger().info("addNewUser method in UserDetails DAO Implementation. At this point there is an error that has prevented saving new user to the database");
				 
				 genericObject = (Container<T>) new  Container<ApiError> (persistentException.handleDataAccessException((DataAccessException)dataAccessException),"Error Object");
		
			 
			 }
		
		
		return genericObject;
	}


}

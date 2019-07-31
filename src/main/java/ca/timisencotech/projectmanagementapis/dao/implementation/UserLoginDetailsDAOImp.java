package ca.timisencotech.projectmanagementapis.dao.implementation;

import java.sql.Timestamp;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
	
	
	@SuppressWarnings("unchecked")
	@Override
	public <T> Container<T> confirmdUserLoginDetails(UserLoginDetail userLoginDetail) {
	
		Container<T> genericObject=null;
		UserLoginDetails newUserLoginDetails = new UserLoginDetails();
		newUserLoginDetails.setPassword(userLoginDetail.getPassword());
		newUserLoginDetails.setUserEmail(userLoginDetail.getUserEmail());
		
		UserLoginDetails responseUserLoginDetails = userLoginDetailsRepository.findByEmailAndPassword(userLoginDetail.getUserEmail(),userLoginDetail.getPassword());
	

		 try { 
		
			 	if(responseUserLoginDetails!=null)
			 	{
			 		 UserLoginDetail domainUserLoginDetail = new UserLoginDetail();
					 domainUserLoginDetail.setLoginTime(responseUserLoginDetails.getLoginTime());
					 domainUserLoginDetail.setPassword(responseUserLoginDetails.getPassword());
					 domainUserLoginDetail.setUserEmail(responseUserLoginDetails.getUserEmail());
					 
					 Application.getLogger().info("confirmdUserLoginDetails method in UserDetails DAO Implementation. At this point user login details has successful been confirmed. Return userdetails from repo is"+domainUserLoginDetail);
					 
					 genericObject = (Container<T>) new Container<UserLoginDetail>(domainUserLoginDetail,"Class Object");
				    
			 	}
			 	else
			 	{
			 		genericObject = (Container<T>) new  Container<ApiError> (new ApiError("Persistence Error", "Repository returned null"),"Null Object");
			 	}
		 }
		 catch (DataAccessException dataAccessException) {
			 Application.getLogger().info("confirmdUserLoginDetails method in UserDetails DAO Implementation. At this point there is an error that has prevented confirming user login details");
			 
			 genericObject = (Container<T>) new  Container<ApiError> (persistentException.handleDataAccessException((DataAccessException)dataAccessException),"Error Object");
	
		 
		 }
		 return genericObject;
	}
		
	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public <T> Container<T> updateUserPassword(UserLoginDetail userLoginDetail) {
	
		Container<T> genericObject=null;
		int responseUserLoginDetails = userLoginDetailsRepository.updatePassword(userLoginDetail.getPassword(),userLoginDetail.getUserEmail());
			
		 try { 
				

		
			 	if(responseUserLoginDetails>0)
			 	{
			 		
					 Application.getLogger().info("updateUserPassword method in UserDetails DAO Implementation. At this point user password has successfully been changed in the database. Return userdetails from repo is"+userLoginDetail);
					 genericObject = (Container<T>) new Container<UserLoginDetail>(userLoginDetail,"Class Object");
				    
			 	}
			 	else
			 	{
			 		genericObject = (Container<T>) new  Container<ApiError> (new ApiError("Persistence Error", "Unable to update password"),"Update Object");
			 	}
			 	
		 }
		 catch (DataAccessException dataAccessException) {
			 Application.getLogger().info("updateUserPassword method in UserDetails DAO Implementation. At this point there is an error that has prevented changing user password in the database");
			 genericObject = (Container<T>) new  Container<ApiError> (persistentException.handleDataAccessException((DataAccessException)dataAccessException),"Error Object");
	
		 
		 }
		
		 return genericObject;
	}

}

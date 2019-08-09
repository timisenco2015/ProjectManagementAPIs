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
import ca.timisencotech.projectmanagementapis.dto.UserSignUpDetails;
import ca.timisencotech.projectmanagementapis.exception.PersistentException;
import ca.timisencotech.projectmanagementapis.repository.UserLoginDetailsRepository;
import ca.timisencotech.projectmanagementapis.repository.UserSignUpDetailsRepository;
import ca.timisencotech.projectmanagementapis.validation.Container;

@Repository
public class UserLoginDetailsDAOImp implements UserLoginDetailsDAO {
	
	@Autowired
	UserLoginDetailsRepository userLoginDetailsRepository;
	
	@Autowired
	UserSignUpDetailsRepository userSignUpDetailsRepository;
	
	PersistentException persistentException = new PersistentException();

	@SuppressWarnings("unchecked")
	@Override
	public <T> Container<T> addUserLoginDetails(UserLoginDetail userLoginDetail) {
		Container<T> genericObject=null; 
		
		Date date= new Date();
		Timestamp timeStamp = new Timestamp(date.getTime());
		String email = userLoginDetail.getUserEmail();
		try {
			
			UserSignUpDetails findUserLoginDetails = userSignUpDetailsRepository.findUserSignUpDetailsByEmail(email);
			
			if(findUserLoginDetails==null)
			{
				genericObject = (Container<T>) new  Container<ApiError> (persistentException.handleSearchReturnNull("Incorrect login details user email: "+email+ " in our database"),"Error Object");
				Application.getLogger().info("addUserLoginDetails method in UserLoginDetails DAO Implementation. At this point unable to find foreign key email in the database");
				
			}
			
			else
			{
			
			UserLoginDetails newUserLoginDetails = new UserLoginDetails();
			newUserLoginDetails.setPassword(userLoginDetail.getPassword());
			newUserLoginDetails.setLoginTime(timeStamp);
			newUserLoginDetails.setUserSignUpDetails(findUserLoginDetails);
				 UserLoginDetails responseUserDetails = userLoginDetailsRepository.save(newUserLoginDetails);
				 UserLoginDetail domainUserLoginDetail = new UserLoginDetail();
				 domainUserLoginDetail.setLoginTime(responseUserDetails.getLoginTime());
				 domainUserLoginDetail.setPassword(responseUserDetails.getPassword());
				 domainUserLoginDetail.setUserEmail(userLoginDetail.getUserEmail());
				 
				 Application.getLogger().info("addNewUser method in UserDetails DAO Implementation. At this point new user has successful saved to the database. Return UserLoginDetails from repo is"+domainUserLoginDetail);
				 
				 genericObject = (Container<T>) new Container<UserLoginDetail>(domainUserLoginDetail,"Class Object");
			    } 
			 
		}
			 
			 catch (DataAccessException dataAccessException) {
				 Application.getLogger().info("addNewUser method in UserDetails DAO Implementation. At this point there is an error that has prevented saving new user login details to the database");
				 
				 genericObject = (Container<T>) new  Container<ApiError> (persistentException.handleDataAccessException((DataAccessException)dataAccessException),"Error Object");
		
			 
			 }
		
		
		return genericObject;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public <T> Container<T> confirmedUserLoginDetails(UserLoginDetail userLoginDetail) {
	
		Container<T> genericObject=null;
		String email =userLoginDetail.getUserEmail();
		String password = userLoginDetail.getPassword();
		Timestamp loginTime = userLoginDetail.getLoginTime();
		
		
		UserSignUpDetails responseUserSignUpDetails = userSignUpDetailsRepository.findByEmailAndPassword(email,password);
			

		 try { 
		
			 	if(responseUserSignUpDetails!=null)
			 	{
			 		
			 		UserSignUpDetails newUserSignUpDetails = new UserSignUpDetails();
			 		newUserSignUpDetails.setUserEmail(email);
			 		newUserSignUpDetails.setPassword(password);
			 		
			 		UserLoginDetails newUserLoginDetails = new UserLoginDetails();
			 		newUserLoginDetails.setUserSignUpDetails(newUserSignUpDetails);
			 		newUserLoginDetails.setPassword(password);
			 		newUserLoginDetails.setLoginTime(loginTime);
			 		
			 		UserLoginDetails responseUserLoginDetails= userLoginDetailsRepository.save(newUserLoginDetails);
			 		
			 		
			 		UserLoginDetail domainUserLoginDetail = new UserLoginDetail();
			 		
			 		domainUserLoginDetail.setPassword(responseUserLoginDetails.getPassword());
			 		domainUserLoginDetail.setUserEmail(email);
			 		domainUserLoginDetail.setLoginTime(responseUserLoginDetails.getLoginTime());
					 Application.getLogger().info("confirmdUserLoginDetails method in UserLoginDetails DAO Implementation. At this point user login details has successful been confirmed. Return userdetails from repo is"+domainUserLoginDetail);
					 
					 genericObject = (Container<T>) new Container<UserLoginDetail>(domainUserLoginDetail,"Class Object");
				    
			 	}
			 	else
			 	{
			 		genericObject = (Container<T>) new  Container<ApiError> (persistentException.handleSearchReturnNull("Incorrect login details user email: "+userLoginDetail.getUserEmail()+ "and password:"+userLoginDetail.getPassword()),"Null Object");
					Application.getLogger().info("addUserLoginDetails method in UserLoginDetails DAO Implementation. At this point unable to confirm user email and password");
				
			 	}
		 }
		 catch (DataAccessException dataAccessException) {
			 Application.getLogger().info("confirmdUserLoginDetails method in UserLoginDetails DAO Implementation. At this point there is an error that has prevented confirming user login details");
			 
			 genericObject = (Container<T>) new  Container<ApiError> (persistentException.handleDataAccessException((DataAccessException)dataAccessException),"Error Object");
	
		 
		 }
		 return genericObject;
	}

}

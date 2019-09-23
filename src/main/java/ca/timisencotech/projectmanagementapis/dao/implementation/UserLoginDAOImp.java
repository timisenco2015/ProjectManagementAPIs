package ca.timisencotech.projectmanagementapis.dao.implementation;

import java.sql.Timestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import ca.timisencotech.projectmanagementapis.exception.ApiError;
import ca.timisencotech.projectmanagementapis.Application;
import ca.timisencotech.projectmanagementapis.dao.UserLoginDAO;
import ca.timisencotech.projectmanagementapis.domain.UserLogin;
import ca.timisencotech.projectmanagementapis.dto.UserLoginDetails;
import ca.timisencotech.projectmanagementapis.dto.UserSignUpDetails;
import ca.timisencotech.projectmanagementapis.exception.PersistentException;
import ca.timisencotech.projectmanagementapis.repository.UserLoginRepo;
import ca.timisencotech.projectmanagementapis.repository.UserSignUpRepo;
import ca.timisencotech.projectmanagementapis.validation.Container;

@Repository
public class UserLoginDAOImp implements UserLoginDAO {
	
	@Autowired
	UserLoginRepo userLoginRepo;
	
	@Autowired
	UserSignUpRepo userSignUpRepo;
	
	PersistentException persistentException = new PersistentException();


	
	
	@SuppressWarnings("unchecked")
	@Override
	public <T> Container<T> confirmedUserLogin(UserLogin userLogin) {
	
		Container<T> genericObject=null;
		String email =userLogin.getUserEmail();
		String password = userLogin.getPassword();
		Timestamp loginTime = userLogin.getLoginTime();
		
		
		UserSignUpDetails responseUserSignUpDetails = userSignUpRepo.findByEmailAndPassword(email,password);
			

		 try { 
		
			 	if(responseUserSignUpDetails!=null)
			 	{
			 		
			 		
			 		
			 		UserLoginDetails newUserLoginDetails = new UserLoginDetails();
			 		newUserLoginDetails.setUserSignUpDetails(responseUserSignUpDetails);
			 		newUserLoginDetails.setPassword(password);
			 		newUserLoginDetails.setLoginTime(loginTime);
			 		
			 		
			 		
			 		UserLoginDetails responseUserLoginDetails= userLoginRepo.save(newUserLoginDetails);
			 		
			 		
			 		UserLogin domainUserLoginDetail = new UserLogin();
			 		
			 		domainUserLoginDetail.setPassword(responseUserLoginDetails.getPassword());
			 		domainUserLoginDetail.setUserEmail(email);
			 		domainUserLoginDetail.setLoginTime(responseUserLoginDetails.getLoginTime());
					 Application.getLogger().info("confirmdUserLoginDetails method in UserLoginDetails DAO Implementation. At this point user login details has successful been confirmed. Return userdetails from repo is"+domainUserLoginDetail);
					 
					 genericObject = (Container<T>) new Container<UserLogin>(domainUserLoginDetail,"Class Object");
				    
			 	}
			 	else
			 	{
			 		genericObject = (Container<T>) new  Container<ApiError> (persistentException.handleSearchReturnNull("Incorrect login details user email: "+userLogin.getUserEmail()+ "and password:"+userLogin.getPassword()),"Null Object");
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

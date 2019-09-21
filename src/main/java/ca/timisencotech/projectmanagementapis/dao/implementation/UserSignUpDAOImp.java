package ca.timisencotech.projectmanagementapis.dao.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ca.timisencotech.projectmanagementapis.exception.ApiError;
import ca.timisencotech.projectmanagementapis.Application;
import ca.timisencotech.projectmanagementapis.dao.UserSignUpDAO;
import ca.timisencotech.projectmanagementapis.domain.UserSignUp;
import ca.timisencotech.projectmanagementapis.dto.UserSignUpDetails;
import ca.timisencotech.projectmanagementapis.exception.PersistentException;
import ca.timisencotech.projectmanagementapis.repository.UserLoginRepository;
import ca.timisencotech.projectmanagementapis.repository.UserSignUpRepository;
import ca.timisencotech.projectmanagementapis.validation.Container;

@Repository
public class UserSignUpDAOImp implements  UserSignUpDAO {
	
	@Autowired
	UserLoginRepository userLoginRepository;
	
	@Autowired
	UserSignUpRepository userSignUpRepository;
	
	PersistentException persistentException = new PersistentException();

	@SuppressWarnings("unchecked")
	@Override
	public <T> Container<T> addUserSignUpDetails(UserSignUp userSignUp) {
		Container<T> genericObject=null; 
	
		String email = userSignUp.getUserEmail();
		String password = userSignUp.getPassword();
		try {
			
			
			UserSignUpDetails newUserSignUpDetails = new UserSignUpDetails();
			newUserSignUpDetails.setUserEmail(email);
			newUserSignUpDetails.setPassword(password);
			UserSignUpDetails responseUserSignUpDetails = userSignUpRepository.save(newUserSignUpDetails);
			 
			

			UserSignUp domainUserSignUpDetail = new UserSignUp();
		
			domainUserSignUpDetail.setPassword(responseUserSignUpDetails.getPassword());
			domainUserSignUpDetail.setUserEmail(responseUserSignUpDetails.getUserEmail());
			Application.getLogger().info("addUserSignUpDetails method in UserSignUpDetails DAO Implementation. At this point new user has successful saved to the database. Return UserLoginDetails from repo is"+domainUserSignUpDetail);
			genericObject = (Container<T>) new Container<UserSignUp>(domainUserSignUpDetail,"Class Object");
			    
			 
		}
			 
			 catch (DataAccessException dataAccessException) {
				 Application.getLogger().info("addUserSignUpDetails method in UserSignUpDetails DAO Implementation. At this point there is an error that has prevented saving new user signup details to the database");
				 
				 genericObject = (Container<T>) new  Container<ApiError> (persistentException.handleDataAccessException((DataAccessException)dataAccessException),"Error Object");
		
			 
			 }
		
		
		return genericObject;
	}
	
	
	
		
	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public <T> Container<T> updateUserPassword(UserSignUp userSignUp) {
	
		Container<T> genericObject=null;
		int responseUserSignUpDetail = userSignUpRepository.updatePassword(userSignUp.getPassword(),userSignUp.getUserEmail());
			
		 try { 
	
			 	if(responseUserSignUpDetail>0)
			 	{
			 		
					 Application.getLogger().info("updateUserPassword method in UserSignUpDetails DAO Implementation. At this point user password has successfully been changed in the database. Return userdetails from repo is"+userSignUp);
					 genericObject = (Container<T>) new Container<UserSignUp>(userSignUp,"Class Object");
				    
			 	}
			 	else
			 	{
			 		genericObject = (Container<T>) new  Container<ApiError> (new ApiError("Persistence Error", "Unable to update password"),"Update Object");
			 	}
			 	
		 }
		 catch (DataAccessException dataAccessException) {
			 Application.getLogger().info("updateUserPassword method in UserSignUpDetails DAO Implementation. At this point there is an error that has prevented changing user password in the database");
			 genericObject = (Container<T>) new  Container<ApiError> (persistentException.handleDataAccessException((DataAccessException)dataAccessException),"Error Object");
	
		 
		 }
		
		 return genericObject;
	}

}

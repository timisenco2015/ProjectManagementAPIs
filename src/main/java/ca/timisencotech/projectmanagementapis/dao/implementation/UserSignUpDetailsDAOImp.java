package ca.timisencotech.projectmanagementapis.dao.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ca.timisencotech.projectmanagementapis.exception.ApiError;
import ca.timisencotech.projectmanagementapis.Application;
import ca.timisencotech.projectmanagementapis.dao.UserSignUpDetailsDAO;
import ca.timisencotech.projectmanagementapis.domain.UserSignUpDetail;
import ca.timisencotech.projectmanagementapis.dto.UserSignUpDetails;
import ca.timisencotech.projectmanagementapis.exception.PersistentException;
import ca.timisencotech.projectmanagementapis.repository.UserLoginDetailsRepository;
import ca.timisencotech.projectmanagementapis.repository.UserSignUpDetailsRepository;
import ca.timisencotech.projectmanagementapis.validation.Container;

@Repository
public class UserSignUpDetailsDAOImp implements  UserSignUpDetailsDAO {
	
	@Autowired
	UserLoginDetailsRepository userLoginDetailsRepository;
	
	@Autowired
	UserSignUpDetailsRepository userSignUpDetailsRepository;
	
	PersistentException persistentException = new PersistentException();

	@SuppressWarnings("unchecked")
	@Override
	public <T> Container<T> addUserSignUpDetails(UserSignUpDetail userSignUpDetail) {
		Container<T> genericObject=null; 
	
		String email = userSignUpDetail.getUserEmail();
		String password = userSignUpDetail.getPassword();
		try {
			
			
			UserSignUpDetails newUserSignUpDetails = new UserSignUpDetails();
			newUserSignUpDetails.setUserEmail(email);
			newUserSignUpDetails.setPassword(password);
			UserSignUpDetails responseUserSignUpDetails = userSignUpDetailsRepository.save(newUserSignUpDetails);
			 
			

			UserSignUpDetail domainUserSignUpDetail = new UserSignUpDetail();
		
			domainUserSignUpDetail.setPassword(responseUserSignUpDetails.getPassword());
			domainUserSignUpDetail.setUserEmail(responseUserSignUpDetails.getUserEmail());
			Application.getLogger().info("addUserSignUpDetails method in UserSignUpDetails DAO Implementation. At this point new user has successful saved to the database. Return UserLoginDetails from repo is"+domainUserSignUpDetail);
			genericObject = (Container<T>) new Container<UserSignUpDetail>(domainUserSignUpDetail,"Class Object");
			    
			 
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
	public <T> Container<T> updateUserPassword(UserSignUpDetail userSignUpDetail) {
	
		Container<T> genericObject=null;
		int responseUserSignUpDetail = userSignUpDetailsRepository.updatePassword(userSignUpDetail.getPassword(),userSignUpDetail.getUserEmail());
			
		 try { 
	
			 	if(responseUserSignUpDetail>0)
			 	{
			 		
					 Application.getLogger().info("updateUserPassword method in UserSignUpDetails DAO Implementation. At this point user password has successfully been changed in the database. Return userdetails from repo is"+userSignUpDetail);
					 genericObject = (Container<T>) new Container<UserSignUpDetail>(userSignUpDetail,"Class Object");
				    
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

package ca.timisencotech.projectmanagementapis.service.implementation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.validation.BindingResult;

import ca.timisencotech.projectmanagementapis.Application;
import ca.timisencotech.projectmanagementapis.dao.implementation.UserLoginDetailsDAOImp;
import ca.timisencotech.projectmanagementapis.domain.UserLoginDetail;
import ca.timisencotech.projectmanagementapis.exception.ValidationError;
import ca.timisencotech.projectmanagementapis.service.UserLoginDetailsService;
import ca.timisencotech.projectmanagementapis.validation.Container;
import ca.timisencotech.projectmanagementapis.validation.ValidateUserLoginDetails;

@Repository
public class UserLoginDetailsServiceImp implements UserLoginDetailsService {
	
	@Autowired
	private UserLoginDetailsDAOImp userLoginDetailsDAOImp;
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public <T> Container<T> addUserLoginDetails(UserLoginDetail userLoginDetail,BindingResult result) {
		
		
		Container<T> genericObject=null;
		new ValidateUserLoginDetails().validate(userLoginDetail, result);
		ValidationError  validationError = new ValidationError()	;
		if (result.hasErrors())
		{
			
			validationError.setErrorStatus("Failed");
			validationError.setMessage("Failed validation test for all or most of the fields");
			validationError.setAllErrorObject(result.getAllErrors());
   
		 genericObject = (Container<T>) new  Container<ValidationError> (validationError,"Error Object");
		 Application.getLogger().info("New user information validation error. Error info: "+validationError.getMessageObject());

		}
		
		else
		{
			Application.getLogger().info("confirmUserLoginDetails method in UserLoginDetails Service Implementation. Checks if user email and user password matches");
		    
			genericObject=userLoginDetailsDAOImp.addUserLoginDetails(userLoginDetail); 
		}
		return genericObject;
	}


}

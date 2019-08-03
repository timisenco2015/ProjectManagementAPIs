package ca.timisencotech.projectmanagementapis.service.implementation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.validation.BindingResult;
import ca.timisencotech.projectmanagementapis.Application;
import ca.timisencotech.projectmanagementapis.dao.implementation.UserSignUpDetailsDAOImp;
import ca.timisencotech.projectmanagementapis.domain.UserSignUpDetail;
import ca.timisencotech.projectmanagementapis.exception.ValidationError;
import ca.timisencotech.projectmanagementapis.service.UserSignUpDetailsService;
import ca.timisencotech.projectmanagementapis.validation.Container;
import ca.timisencotech.projectmanagementapis.validation.ValidateUserSignUpDetails;

@Repository
public class UserSignUpDetailsServiceImp implements  UserSignUpDetailsService {
	
	@Autowired
	private UserSignUpDetailsDAOImp userSignUpDetailsDAOImp;
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public <T> Container<T> addUserSignUpDetails(UserSignUpDetail userSignUpDetail,BindingResult result) {
		
		
		Container<T> genericObject=null;
		new ValidateUserSignUpDetails().validate(userSignUpDetail, result);
		ValidationError  validationError = new ValidationError()	;
		if (result.hasErrors())
		{
			
			validationError.setErrorStatus("Failed");
			validationError.setMessage("Failed validation test for all or most of the fields");
			validationError.setAllErrorObject(result.getAllErrors());
   
		 genericObject = (Container<T>) new  Container<ValidationError> (validationError,"Error Object");
		 Application.getLogger().info("New user signup validation error. Error info: "+validationError.getMessageObject());

		}
		
		else
		{
			Application.getLogger().info("addUserSignUpDetails method in UserSignUpDetailsServiceImp Service Implementation. add user sign up details");
		    
			genericObject=userSignUpDetailsDAOImp.addUserSignUpDetails(userSignUpDetail);
					
		}
		return genericObject;
	}

	
	
	@SuppressWarnings("unchecked")
	public <T> Container<T> updateUserPassword(UserSignUpDetail userSignUpDetail,BindingResult result)
	{Container<T> genericObject=null;
	new ValidateUserSignUpDetails().validate(userSignUpDetail, result);
	ValidationError  validationError = new ValidationError()	;
	if (result.hasErrors())
	{
		
		validationError.setErrorStatus("Failed");
		validationError.setMessage("Failed validation test for all or most of the fields");
		validationError.setAllErrorObject(result.getAllErrors());

	 genericObject = (Container<T>) new  Container<ValidationError> (validationError,"Error Object");
	 Application.getLogger().info("update password validation error. Error info: "+validationError.getMessageObject());

	}
	
	else
	{
		Application.getLogger().info("updateUserPassword method in UserSignUpDetails Service Implementation. User password updated");
	    
		genericObject=userSignUpDetailsDAOImp.updateUserPassword(userSignUpDetail); 
	}
	return genericObject;	
}
}

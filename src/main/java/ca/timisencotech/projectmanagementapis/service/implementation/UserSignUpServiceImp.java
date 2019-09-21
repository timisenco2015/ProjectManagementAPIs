package ca.timisencotech.projectmanagementapis.service.implementation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import ca.timisencotech.projectmanagementapis.Application;
import ca.timisencotech.projectmanagementapis.dao.implementation.UserSignUpDAOImp;
import ca.timisencotech.projectmanagementapis.domain.UserSignUp;
import ca.timisencotech.projectmanagementapis.exception.ValidationError;
import ca.timisencotech.projectmanagementapis.service.UserSignUpService;
import ca.timisencotech.projectmanagementapis.validation.Container;
import ca.timisencotech.projectmanagementapis.validation.ValidateUserSignUp;

@Service("UserSignUpDetailsService")
@Transactional(propagation=Propagation.SUPPORTS, rollbackFor = Exception.class)
public class UserSignUpServiceImp implements  UserSignUpService {
	
	@Autowired
	private UserSignUpDAOImp userSignUpDAOImp;
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public <T> Container<T> addUserSignUpDetails(UserSignUp userSignUp,BindingResult result) {
		
		
		Container<T> genericObject=null;
		new ValidateUserSignUp().validate(userSignUp, result);
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
		    
			genericObject=userSignUpDAOImp.addUserSignUpDetails(userSignUp);
					
		}
		return genericObject;
	}

	
	
	@SuppressWarnings("unchecked")
	public <T> Container<T> updateUserPassword(UserSignUp userSignUp,BindingResult result)
	{Container<T> genericObject=null;
	new ValidateUserSignUp().validate(userSignUp, result);
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
	    
		genericObject=userSignUpDAOImp.updateUserPassword(userSignUp); 
	}
	return genericObject;	
}
}

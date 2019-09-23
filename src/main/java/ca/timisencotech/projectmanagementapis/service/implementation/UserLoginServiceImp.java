package ca.timisencotech.projectmanagementapis.service.implementation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import ca.timisencotech.projectmanagementapis.Application;
import ca.timisencotech.projectmanagementapis.dao.implementation.UserLoginDAOImp;
import ca.timisencotech.projectmanagementapis.domain.UserLogin;
import ca.timisencotech.projectmanagementapis.exception.ValidationError;
import ca.timisencotech.projectmanagementapis.service.UserLoginService;
import ca.timisencotech.projectmanagementapis.validation.Container;
import ca.timisencotech.projectmanagementapis.validation.ValidateUserLogin;


@Service("UserLoginDetailsService")
@Transactional(propagation=Propagation.SUPPORTS, rollbackFor = Exception.class)
public class UserLoginServiceImp implements UserLoginService {
	
	@Autowired
	private UserLoginDAOImp userLoginDAOImp;
	
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public <T> Container<T> confirmedUserLogin(UserLogin userLogin,BindingResult result) {
		Container<T> genericObject=null;
		new ValidateUserLogin().validate(userLogin, result);
		ValidationError  validationError = new ValidationError()	;
		if (result.hasErrors())
		{
			
			validationError.setErrorStatus("Failed");
			validationError.setMessage("Failed validation test for all or most of the fields");
			validationError.setAllErrorObject(result.getAllErrors());
   
		 genericObject = (Container<T>) new  Container<ValidationError> (validationError,"Error Object");
		 Application.getLogger().info("user login details confirmation validation error. Error info: "+validationError.getMessageObject());

		}
		
		else
		{
			Application.getLogger().info("confirmUserLoginDetails method in UserSignUpDetails Service Implementation. Checks if user email and user password matches");
		    
			genericObject=userLoginDAOImp.confirmedUserLogin(userLogin); 
		}
		return genericObject;	
	}


}

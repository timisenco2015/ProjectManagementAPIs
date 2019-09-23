package ca.timisencotech.projectmanagementapis.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import ca.timisencotech.projectmanagementapis.Application;
import ca.timisencotech.projectmanagementapis.dao.implementation.UserDAOImp;
import ca.timisencotech.projectmanagementapis.domain.User;
import ca.timisencotech.projectmanagementapis.exception.ValidationError;
import ca.timisencotech.projectmanagementapis.service.UserService;
import ca.timisencotech.projectmanagementapis.validation.Container;
import ca.timisencotech.projectmanagementapis.validation.ValidateUser;




@Service("UserDetailsService")
@Transactional(propagation=Propagation.SUPPORTS, rollbackFor = Exception.class)
public class UserServiceImpl<T> implements UserService{
	
	
	@Autowired
	private UserDAOImp userDAOImp;
	
	
	
	@SuppressWarnings({ "hiding", "unchecked" })
	@Override
	public <T> Container<T> addNewUser(User user,BindingResult result) {
		
  
		Container<T> genericObject=null;
		new ValidateUser().validate(user, result);
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
				Application.getLogger().info("addStateProvince method in StatesProvinces Service Implementation. New user has already been added to the database");
			    
				genericObject = userDAOImp.addNewUser(user);
			
			}
			
		return genericObject;
	}

}

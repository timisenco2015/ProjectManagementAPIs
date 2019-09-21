package ca.timisencotech.projectmanagementapis.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import ca.timisencotech.projectmanagementapis.Application;
import ca.timisencotech.projectmanagementapis.dao.implementation.SupervisorsPrivilegesDAOImp;
import ca.timisencotech.projectmanagementapis.domain.SupervisorsPrivileges;
import ca.timisencotech.projectmanagementapis.exception.ValidationError;
import ca.timisencotech.projectmanagementapis.service.SupervisorsPrivilegesService;
import ca.timisencotech.projectmanagementapis.validation.Container;
import ca.timisencotech.projectmanagementapis.validation.ValidateSupervisorPrivileges;

@Service("SupervisorsPrivilegesDetailsService")
@Transactional(propagation=Propagation.SUPPORTS, rollbackFor = Exception.class)
public class SupervisorsPrivilegesServiceImpl implements SupervisorsPrivilegesService {

	@Autowired
	private SupervisorsPrivilegesDAOImp supervisorsPrivilegesDAOImp;

	
	@SuppressWarnings("unchecked")
	@Override
	public <T> Container<T> addSupervisorPrivileges(SupervisorsPrivileges supervisorsPrivileges,BindingResult result) {
		Container<T> genericObject=null;
		new ValidateSupervisorPrivileges().validate(supervisorsPrivileges, result);
		ValidationError  validationError = new ValidationError()	;
			
			if (result.hasErrors())
			{
				
				validationError.setErrorStatus("Failed");
				validationError.setMessage("Failed validation test for all or most of the fields");
				validationError.setAllErrorObject(result.getAllErrors());
	   
			 genericObject = (Container<T>) new  Container<ValidationError> (validationError,"Error Object");
			 Application.getLogger().info("supervisor privileges validation error. Error info: "+validationError.getMessageObject());

			}
			
			else
			{
				
				genericObject = supervisorsPrivilegesDAOImp.addSupervisorsPrivileges(supervisorsPrivileges);
				Application.getLogger().info("addSupervisorPrivileges method in SupervisorsPrivilegesDetails Service Implementation. Supervisor privileges added and saved to the database");
			    
			}
		return genericObject;}

}

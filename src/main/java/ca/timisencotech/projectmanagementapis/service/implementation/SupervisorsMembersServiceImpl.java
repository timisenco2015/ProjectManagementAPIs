package ca.timisencotech.projectmanagementapis.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import ca.timisencotech.projectmanagementapis.Application;
import ca.timisencotech.projectmanagementapis.dao.implementation.SupervisorsMembersDAOImp;
import ca.timisencotech.projectmanagementapis.domain.SupervisorsMembers;
import ca.timisencotech.projectmanagementapis.exception.ValidationError;
import ca.timisencotech.projectmanagementapis.service.SupervisorsMembersService;
import ca.timisencotech.projectmanagementapis.validation.Container;
import ca.timisencotech.projectmanagementapis.validation.ValidateSupervisorsMembers;

@Service("SupervisorsMembersService")
@Transactional(propagation=Propagation.SUPPORTS, rollbackFor = Exception.class)
public class SupervisorsMembersServiceImpl implements SupervisorsMembersService {

	@Autowired
	private SupervisorsMembersDAOImp supervisorsMembersDAOImp;

	
	@SuppressWarnings("unchecked")
	@Override
	public <T> Container<T> addSupervisorMember(SupervisorsMembers supervisorsMembers,BindingResult result) {
		Container<T> genericObject=null;
		new ValidateSupervisorsMembers().validate(supervisorsMembers, result);
		ValidationError  validationError = new ValidationError()	;
			
			if (result.hasErrors())
			{
				
				validationError.setErrorStatus("Failed");
				validationError.setMessage("Failed validation test for all or most of the fields");
				validationError.setAllErrorObject(result.getAllErrors());
	   
			 genericObject = (Container<T>) new  Container<ValidationError> (validationError,"Error Object");
			 Application.getLogger().info("supervisor member validation error. Error info: "+validationError.getMessageObject());

			}
			
			else
			{
				
				genericObject = supervisorsMembersDAOImp.addSupervisorMember(supervisorsMembers);
				Application.getLogger().info("addSupervisorMember method in SupervisorsMembers Service Implementation. Member  has already been added to supervisor member list in the database");
			    
			}
		return genericObject;}

}

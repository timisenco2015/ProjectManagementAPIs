package ca.timisencotech.projectmanagementapis.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import ca.timisencotech.projectmanagementapis.Application;
import ca.timisencotech.projectmanagementapis.dao.implementation.TaskAssignedMembersDAOImp;
import ca.timisencotech.projectmanagementapis.domain.TaskAssignedMembers;
import ca.timisencotech.projectmanagementapis.exception.ValidationError;
import ca.timisencotech.projectmanagementapis.service.TaskAssignedMembersService;
import ca.timisencotech.projectmanagementapis.validation.Container;
import ca.timisencotech.projectmanagementapis.validation.ValidateTasksAssignedMember;


@Service("TaskAssignedMembersService")
@Transactional(propagation=Propagation.SUPPORTS, rollbackFor = Exception.class)
public class TaskAssignedMembersServiceImpl<T> implements TaskAssignedMembersService{
	
	
	@Autowired
	private TaskAssignedMembersDAOImp taskAssignedMembersDAOImp;
	
	
	
	@SuppressWarnings({ "hiding", "unchecked" })
	@Override
	public <T> Container<T> assignedTaskToMembers(TaskAssignedMembers taskAssignedMembers,BindingResult result) {
		
  
		Container<T> genericObject=null;
		new ValidateTasksAssignedMember().validate(taskAssignedMembers, result);
		ValidationError  validationError = new ValidationError()	;
			
			if (result.hasErrors())
			{
				
				validationError.setErrorStatus("Failed");
				validationError.setMessage("Failed validation test for all or most of the fields");
				validationError.setAllErrorObject(result.getAllErrors());
	   
			 genericObject = (Container<T>) new  Container<ValidationError> (validationError,"Error Object");
			 Application.getLogger().info("task member assigned validation error. Error info: "+validationError.getMessageObject());

			}
			
			else
			{
				Application.getLogger().info("assignedTaskToMembers method in TaskAssignedMembers Service Implementation. task has been assigned to member and updated in the database");
			    
				genericObject = taskAssignedMembersDAOImp.assignedTaskToMembers(taskAssignedMembers);
					
			}
		return genericObject;
	}

}

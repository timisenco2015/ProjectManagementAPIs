package ca.timisencotech.projectmanagementapis.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import ca.timisencotech.projectmanagementapis.Application;
import ca.timisencotech.projectmanagementapis.dao.implementation.SupervisorTasksDAOImp;
import ca.timisencotech.projectmanagementapis.domain.SupervisorTasks;
import ca.timisencotech.projectmanagementapis.exception.ValidationError;
import ca.timisencotech.projectmanagementapis.service.SupervisorsTasksService;
import ca.timisencotech.projectmanagementapis.validation.Container;
import ca.timisencotech.projectmanagementapis.validation.ValidateSupervisorsTasks;

@Service("SupervisorsTasksService")
@Transactional(propagation=Propagation.SUPPORTS, rollbackFor = Exception.class)
public class SupervisorsTasksServiceImpl implements SupervisorsTasksService {

	@Autowired
	private SupervisorTasksDAOImp supervisorTasksDAOImp;

	
	@SuppressWarnings("unchecked")
	@Override
	public <T> Container<T> addSupervisorTasks(SupervisorTasks supervisorTasks,BindingResult result) {
		Container<T> genericObject=null;
		new ValidateSupervisorsTasks().validate(supervisorTasks, result);
		ValidationError  validationError = new ValidationError()	;
			
			if (result.hasErrors())
			{
				
				validationError.setErrorStatus("Failed");
				validationError.setMessage("Failed validation test for all or most of the fields");
				validationError.setAllErrorObject(result.getAllErrors());
	   
			 genericObject = (Container<T>) new  Container<ValidationError> (validationError,"Error Object");
			 Application.getLogger().info("supervisor tasks validation error. Error info: "+validationError.getMessageObject());

			}
			
			else
			{
				
				genericObject = supervisorTasksDAOImp.addSupervisorTask(supervisorTasks);
				Application.getLogger().info("addSupervisorTasks method in SupervisorsTasks Service Implementation. Supervisor task added and saved to the database");
			    
			}
		return genericObject;}

}

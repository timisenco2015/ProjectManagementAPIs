package ca.timisencotech.projectmanagementapis.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import ca.timisencotech.projectmanagementapis.Application;
import ca.timisencotech.projectmanagementapis.dao.implementation.TaskDAOImp;
import ca.timisencotech.projectmanagementapis.domain.Task;
import ca.timisencotech.projectmanagementapis.exception.ValidationError;
import ca.timisencotech.projectmanagementapis.service.TaskService;
import ca.timisencotech.projectmanagementapis.validation.Container;
import ca.timisencotech.projectmanagementapis.validation.ValidateTask;


@Service("TaskService")
@Transactional(propagation=Propagation.SUPPORTS, rollbackFor = Exception.class)
public class TaskServiceImpl<T> implements TaskService{
	
	
	@Autowired
	private TaskDAOImp taskDAOImp;
	
	
	
	@SuppressWarnings({ "hiding", "unchecked" })
	@Override
	public <T> Container<T> addTask(Task tasks,BindingResult result)
	{
		
  
		Container<T> genericObject=null;
		new ValidateTask().validate(tasks, result);
		ValidationError  validationError = new ValidationError()	;
		
			if (result.hasErrors())
			{
				
				validationError.setErrorStatus("Failed");
				validationError.setMessage("Failed validation test for all or most of the fields");
				validationError.setAllErrorObject(result.getAllErrors());
	   
			 genericObject = (Container<T>) new  Container<ValidationError> (validationError,"Error Object");
			 Application.getLogger().info("task  validation error. Error info: "+validationError.getMessageObject());

			}
			
			else
			{
				
				genericObject = taskDAOImp.addTask(tasks);
				Application.getLogger().info("addTask method in Task Service Implementation. New  task  has already been saved in the database");
			}
		return genericObject;
	}
	
	@SuppressWarnings({ "unchecked", "hiding" })
	public <T> Container<T> updateTask(Task task,BindingResult result)
	{
		Container<T> genericObject=null;
		new ValidateTask().validate(task, result);
		ValidationError  validationError = new ValidationError()	;
		
			if (result.hasErrors())
			{
				
				validationError.setErrorStatus("Failed");
				validationError.setMessage("Failed validation test for all or most of the fields");
				validationError.setAllErrorObject(result.getAllErrors());
	   
			 genericObject = (Container<T>) new  Container<ValidationError> (validationError,"Error Object");
			 Application.getLogger().info("task  validation error. Error info: "+validationError.getMessageObject());

			}
			
			else
			{
				
				genericObject = taskDAOImp.updateTask(task);
				Application.getLogger().info("addTask method in Task Service Implementation. New  task  has already been saved in the database");
			}
		return genericObject;
	}

}

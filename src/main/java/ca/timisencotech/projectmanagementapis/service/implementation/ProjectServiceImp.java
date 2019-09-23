package ca.timisencotech.projectmanagementapis.service.implementation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import ca.timisencotech.projectmanagementapis.Application;
import ca.timisencotech.projectmanagementapis.dao.implementation.ProjectDAOImp;
import ca.timisencotech.projectmanagementapis.domain.Project;
import ca.timisencotech.projectmanagementapis.exception.ValidationError;
import ca.timisencotech.projectmanagementapis.service.ProjectService;
import ca.timisencotech.projectmanagementapis.validation.Container;
import ca.timisencotech.projectmanagementapis.validation.ValidateProject;

@Service("ProjectService")
@Transactional(propagation=Propagation.SUPPORTS, rollbackFor = Exception.class)
public class ProjectServiceImp implements  ProjectService {
	
	@Autowired
	private ProjectDAOImp projectDAOImp;
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public <T> Container<T> addProjectpDetails(Project project,BindingResult result) {
		
		
		Container<T> genericObject=null;
		new ValidateProject().validate(project, result);
		ValidationError  validationError = new ValidationError()	;
		if (result.hasErrors())
		{
			
			validationError.setErrorStatus("Failed");
			validationError.setMessage("Failed validation test for all or most of the fields");
			validationError.setAllErrorObject(result.getAllErrors());
   
		 genericObject = (Container<T>) new  Container<ValidationError> (validationError,"Error Object");
		 Application.getLogger().info("add new project validation error. Error info: "+validationError.getMessageObject());

		}
		
		else
		{
			Application.getLogger().info("addProjectp method in ProjectDetails Service Implementation. add project");
		    
			genericObject=projectDAOImp.addProject(project);
					
		}
		return genericObject;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <T> Container<T> updateProjectDetails(Project project,BindingResult result)
	{
		Container<T> genericObject=null;
		new ValidateProject().validate(project, result);
		ValidationError  validationError = new ValidationError()	;
		if (result.hasErrors())
		{
			
			validationError.setErrorStatus("Failed");
			validationError.setMessage("Failed validation test for all or most of the fields");
			validationError.setAllErrorObject(result.getAllErrors());
   
		 genericObject = (Container<T>) new  Container<ValidationError> (validationError,"Error Object");
		 Application.getLogger().info("add new project validation error. Error info: "+validationError.getMessageObject());

		}
		
		else
		{
			Application.getLogger().info("updateProject method in Project Service Implementation. update project");
		    
			genericObject=projectDAOImp.addProject(project);
					
		}
		return genericObject;
	}


}

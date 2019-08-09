package ca.timisencotech.projectmanagementapis.service.implementation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import ca.timisencotech.projectmanagementapis.Application;
import ca.timisencotech.projectmanagementapis.dao.implementation.ProjectDetailsDAOImp;
import ca.timisencotech.projectmanagementapis.domain.ProjectInformation;
import ca.timisencotech.projectmanagementapis.exception.ValidationError;
import ca.timisencotech.projectmanagementapis.service.ProjectDetailsService;
import ca.timisencotech.projectmanagementapis.validation.Container;
import ca.timisencotech.projectmanagementapis.validation.ValidateProjectDetails;

@Service("ProjectDetailsService")
@Transactional(propagation=Propagation.SUPPORTS, rollbackFor = Exception.class)
public class ProjectDetailsServiceImp implements  ProjectDetailsService {
	
	@Autowired
	private ProjectDetailsDAOImp projectDetailsDAOImp;
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public <T> Container<T> addProjectpDetails(ProjectInformation projectInformation,BindingResult result) {
		
		
		Container<T> genericObject=null;
		new ValidateProjectDetails().validate(projectInformation, result);
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
			Application.getLogger().info("addProjectpDetails method in ProjectDetailsServiceImp Service Implementation. add project details");
		    
			genericObject=projectDetailsDAOImp.addProjectDetails(projectInformation);
					
		}
		return genericObject;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <T> Container<T> updateProjectDetails(ProjectInformation projectInformation,BindingResult result)
	{
		Container<T> genericObject=null;
		new ValidateProjectDetails().validate(projectInformation, result);
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
			Application.getLogger().info("updateProjectDetails method in ProjectDetailsServiceImp Service Implementation. update project details");
		    
			genericObject=projectDetailsDAOImp.addProjectDetails(projectInformation);
					
		}
		return genericObject;
	}


}

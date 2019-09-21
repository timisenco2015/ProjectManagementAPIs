package ca.timisencotech.projectmanagementapis.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import ca.timisencotech.projectmanagementapis.Application;
import ca.timisencotech.projectmanagementapis.dao.implementation.ProjectGroupDAOImp;
import ca.timisencotech.projectmanagementapis.domain.ProjectGroup;
import ca.timisencotech.projectmanagementapis.exception.ValidationError;
import ca.timisencotech.projectmanagementapis.service.ProjectGroupService;
import ca.timisencotech.projectmanagementapis.validation.Container;
import ca.timisencotech.projectmanagementapis.validation.ValidateProjectGroup;


@Service("ProjectGroupDetailsService")
@Transactional(propagation=Propagation.SUPPORTS, rollbackFor = Exception.class)
public class ProjectGroupServiceImpl<T> implements ProjectGroupService{
	
	
	@Autowired
	private ProjectGroupDAOImp projectGroupDAOImp;
	
	
	
	@SuppressWarnings({ "hiding", "unchecked" })
	@Override
	public <T> Container<T> addProjectGroupDetails(ProjectGroup projectGroup,BindingResult result) {
		
  
		Container<T> genericObject=null;
		new ValidateProjectGroup().validate(projectGroup, result);
		ValidationError  validationError = new ValidationError()	;
			
			if (result.hasErrors())
			{
				
				validationError.setErrorStatus("Failed");
				validationError.setMessage("Failed validation test for all or most of the fields");
				validationError.setAllErrorObject(result.getAllErrors());
	   
			 genericObject = (Container<T>) new  Container<ValidationError> (validationError,"Error Object");
			 Application.getLogger().info("project group validation error. Error info: "+validationError.getMessageObject());

			}
			
			else
			{
				Application.getLogger().info("addProjectGroupDetails method in ProjectGroupDetails Service Implementation. New project group has already been updated in the database");
			    
				genericObject = projectGroupDAOImp.addProjectGroupDetails(projectGroup);
					
			}
		return genericObject;
	}

}

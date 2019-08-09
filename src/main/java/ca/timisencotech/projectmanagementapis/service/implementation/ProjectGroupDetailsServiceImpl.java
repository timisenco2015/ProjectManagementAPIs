package ca.timisencotech.projectmanagementapis.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import ca.timisencotech.projectmanagementapis.Application;
import ca.timisencotech.projectmanagementapis.dao.implementation.ProjectGroupDetailsDAOImp;
import ca.timisencotech.projectmanagementapis.domain.ProjectGroupDetail;
import ca.timisencotech.projectmanagementapis.exception.ValidationError;
import ca.timisencotech.projectmanagementapis.service.ProjectGroupDetailsService;
import ca.timisencotech.projectmanagementapis.validation.Container;
import ca.timisencotech.projectmanagementapis.validation.ValidateProjectGroupDetails;


@Service("ProjectGroupDetailsService")
@Transactional(propagation=Propagation.SUPPORTS, rollbackFor = Exception.class)
public class ProjectGroupDetailsServiceImpl<T> implements ProjectGroupDetailsService{
	
	
	@Autowired
	private ProjectGroupDetailsDAOImp projectGroupDetailsDAOImp;
	
	
	
	@SuppressWarnings({ "hiding", "unchecked" })
	@Override
	public <T> Container<T> addProjectGroupDetails(ProjectGroupDetail projectGroupDetail,BindingResult result) {
		
  
		Container<T> genericObject=null;
		new ValidateProjectGroupDetails().validate(projectGroupDetail, result);
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
			    
				genericObject = projectGroupDetailsDAOImp.addProjectGroupDetails(projectGroupDetail);
					
			}
		return genericObject;
	}

}

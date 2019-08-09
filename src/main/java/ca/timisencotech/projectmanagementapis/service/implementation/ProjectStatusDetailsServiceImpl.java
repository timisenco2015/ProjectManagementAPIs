package ca.timisencotech.projectmanagementapis.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import ca.timisencotech.projectmanagementapis.Application;
import ca.timisencotech.projectmanagementapis.dao.implementation.ProjectStatusDetailsDAOImp;
import ca.timisencotech.projectmanagementapis.domain.ProjectStatusDetail;
import ca.timisencotech.projectmanagementapis.exception.ValidationError;
import ca.timisencotech.projectmanagementapis.service.ProjectStatusDetailsService;
import ca.timisencotech.projectmanagementapis.validation.Container;
import ca.timisencotech.projectmanagementapis.validation.ValidateProjectStatusDetails;


@Service("ProjectStatusDetailsService")
@Transactional(propagation=Propagation.SUPPORTS, rollbackFor = Exception.class)
public class ProjectStatusDetailsServiceImpl<T> implements ProjectStatusDetailsService{
	
	
	@Autowired
	private ProjectStatusDetailsDAOImp projectStatusDetailsDAOImp;
	
	
	
	@SuppressWarnings({ "hiding", "unchecked" })
	@Override
	public <T> Container<T> addProjectStatusDetails(ProjectStatusDetail projectStatusDetail,BindingResult result) {
		
  
		Container<T> genericObject=null;
		new ValidateProjectStatusDetails().validate(projectStatusDetail, result);
		ValidationError  validationError = new ValidationError()	;
			
			if (result.hasErrors())
			{
				
				validationError.setErrorStatus("Failed");
				validationError.setMessage("Failed validation test for all or most of the fields");
				validationError.setAllErrorObject(result.getAllErrors());
	   
			 genericObject = (Container<T>) new  Container<ValidationError> (validationError,"Error Object");
			 Application.getLogger().info("project status validation error. Error info: "+validationError.getMessageObject());

			}
			
			else
			{
				Application.getLogger().info("addProjectStatusDetails method in ProjectStatusDetailsService Service Implementation. New project status has already been updated in the database");
			    
				genericObject = projectStatusDetailsDAOImp.addProjectStatusDetails(projectStatusDetail);
					
			}
		return genericObject;
	}

}

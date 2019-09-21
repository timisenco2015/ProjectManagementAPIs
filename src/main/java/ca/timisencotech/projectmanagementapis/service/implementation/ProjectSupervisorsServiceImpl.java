package ca.timisencotech.projectmanagementapis.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import ca.timisencotech.projectmanagementapis.Application;
import ca.timisencotech.projectmanagementapis.dao.implementation.ProjectSupervisorsDAOImp;
import ca.timisencotech.projectmanagementapis.domain.ProjectSupervisors;
import ca.timisencotech.projectmanagementapis.exception.ValidationError;
import ca.timisencotech.projectmanagementapis.service.ProjectSupervisorsService;
import ca.timisencotech.projectmanagementapis.validation.Container;
import ca.timisencotech.projectmanagementapis.validation.ValidateProjectSupervisors;


@Service("ProjectSupervisorsDetailsService")
@Transactional(propagation=Propagation.SUPPORTS, rollbackFor = Exception.class)
public class ProjectSupervisorsServiceImpl<T> implements ProjectSupervisorsService{
	
	
	@Autowired
	private ProjectSupervisorsDAOImp projectSupervisorsDAOImp;
	
	
	
	@SuppressWarnings({ "hiding", "unchecked" })
	@Override
	public <T> Container<T> addProjectSupervisorsDetails(ProjectSupervisors projectSupervisors,BindingResult result) {
		
  
		Container<T> genericObject=null;
		new ValidateProjectSupervisors().validate(projectSupervisors, result);
		ValidationError  validationError = new ValidationError()	;
			
			if (result.hasErrors())
			{
				
				validationError.setErrorStatus("Failed");
				validationError.setMessage("Failed validation test for all or most of the fields");
				validationError.setAllErrorObject(result.getAllErrors());
	   
			 genericObject = (Container<T>) new  Container<ValidationError> (validationError,"Error Object");
			 Application.getLogger().info("New uproject supervisor validation error. Error info: "+validationError.getMessageObject());

			}
			
			else
			{
				Application.getLogger().info("addStateProvince method in StatesProvinces Service Implementation. New user has already been added to the database");
			    
				genericObject = projectSupervisorsDAOImp.addProjectSupervisorsDetails(projectSupervisors);
			}
		return genericObject;
	}

}
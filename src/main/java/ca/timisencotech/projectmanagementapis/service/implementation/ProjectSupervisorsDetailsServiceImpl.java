package ca.timisencotech.projectmanagementapis.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import ca.timisencotech.projectmanagementapis.Application;
import ca.timisencotech.projectmanagementapis.dao.implementation.ProjectSupervisorsDetailsDAOImp;
import ca.timisencotech.projectmanagementapis.domain.ProjectSupervisorsDetail;
import ca.timisencotech.projectmanagementapis.exception.ValidationError;
import ca.timisencotech.projectmanagementapis.service.ProjectSupervisorsDetailsService;
import ca.timisencotech.projectmanagementapis.validation.Container;
import ca.timisencotech.projectmanagementapis.validation.ValidateProjectSupervisorsDetails;


@Service("ProjectSupervisorsDetailsService")
@Transactional(propagation=Propagation.SUPPORTS, rollbackFor = Exception.class)
public class ProjectSupervisorsDetailsServiceImpl<T> implements ProjectSupervisorsDetailsService{
	
	
	@Autowired
	private ProjectSupervisorsDetailsDAOImp projectSupervisorsDetailsDAOImp;
	
	
	
	@SuppressWarnings({ "hiding", "unchecked" })
	@Override
	public <T> Container<T> addProjectSupervisorsDetails(ProjectSupervisorsDetail projectSupervisorsDetail,BindingResult result) {
		
  
		Container<T> genericObject=null;
		new ValidateProjectSupervisorsDetails().validate(projectSupervisorsDetail, result);
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
			    
				genericObject = projectSupervisorsDetailsDAOImp.addProjectSupervisorsDetails(projectSupervisorsDetail);
			}
		return genericObject;
	}

}

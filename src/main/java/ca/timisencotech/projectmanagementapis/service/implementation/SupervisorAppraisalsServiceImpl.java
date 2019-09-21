package ca.timisencotech.projectmanagementapis.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import ca.timisencotech.projectmanagementapis.Application;
import ca.timisencotech.projectmanagementapis.dao.implementation.SupervisorAppraisalsDAOImp;
import ca.timisencotech.projectmanagementapis.domain.SupervisorAppraisals;
import ca.timisencotech.projectmanagementapis.exception.ValidationError;
import ca.timisencotech.projectmanagementapis.service.SupervisorAppraisalsService;
import ca.timisencotech.projectmanagementapis.validation.Container;
import ca.timisencotech.projectmanagementapis.validation.ValidateSupervisorAppraisal;




@Service("SupervisorAppraisalsDetailsService")
@Transactional(propagation=Propagation.SUPPORTS, rollbackFor = Exception.class)
public class SupervisorAppraisalsServiceImpl implements SupervisorAppraisalsService{
	
	
	@Autowired
	private SupervisorAppraisalsDAOImp supervisorAppraisalsDAOImp;
	
	
	@SuppressWarnings("unchecked")
	@Override
	public <T> Container<T> addSupervisorAppraisals(SupervisorAppraisals supervisorAppraisals,BindingResult result) {
		
		Container<T> genericObject=null;
		new ValidateSupervisorAppraisal().validate(supervisorAppraisals, result);
		ValidationError  validationError = new ValidationError()	;
			
			if (result.hasErrors())
			{
				
				validationError.setErrorStatus("Failed");
				validationError.setMessage("Failed validation test for all or most of the fields");
				validationError.setAllErrorObject(result.getAllErrors());
	   
			 genericObject = (Container<T>) new  Container<ValidationError> (validationError,"Error Object");
			 Application.getLogger().info("supervisor appraisal validation error. Error info: "+validationError.getMessageObject());

			}
			
			else
			{
				Application.getLogger().info("addSupervisorAppraisals method in SupervisorAppraisalsDetails Service Implementation. New SupervisorAppraisalDetails has already been saved into the database");
			    
				genericObject = supervisorAppraisalsDAOImp.addSupervisorAppraisals(supervisorAppraisals);
					
			}
		return genericObject;
		
		
		
	}

}

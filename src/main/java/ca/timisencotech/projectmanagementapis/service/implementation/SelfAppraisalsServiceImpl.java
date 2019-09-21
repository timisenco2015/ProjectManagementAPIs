package ca.timisencotech.projectmanagementapis.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import ca.timisencotech.projectmanagementapis.Application;
import ca.timisencotech.projectmanagementapis.dao.implementation.SelfAppraisalsDAOImp;
import ca.timisencotech.projectmanagementapis.domain.SelfAppraisals;
import ca.timisencotech.projectmanagementapis.exception.ValidationError;
import ca.timisencotech.projectmanagementapis.service.SelfAppraisalsService;
import ca.timisencotech.projectmanagementapis.validation.Container;
import ca.timisencotech.projectmanagementapis.validation.ValidateSelfAppraisal;




@Service("SelfAppraisalsDetailsService")
@Transactional(propagation=Propagation.SUPPORTS, rollbackFor = Exception.class)
public class SelfAppraisalsServiceImpl implements SelfAppraisalsService{
	
	
	@Autowired
	private SelfAppraisalsDAOImp selfAppraisalsDAOImp;
	
	
	@SuppressWarnings("unchecked")
	@Override
	public <T> Container<T> addSelfAppraisals(SelfAppraisals selfAppraisals,BindingResult result) {
		
		Container<T> genericObject=null;
		new ValidateSelfAppraisal().validate(selfAppraisals, result);
		ValidationError  validationError = new ValidationError()	;
			
			if (result.hasErrors())
			{
				
				validationError.setErrorStatus("Failed");
				validationError.setMessage("Failed validation test for all or most of the fields");
				validationError.setAllErrorObject(result.getAllErrors());
	   
			 genericObject = (Container<T>) new  Container<ValidationError> (validationError,"Error Object");
			 Application.getLogger().info("task status validation error. Error info: "+validationError.getMessageObject());

			}
			
			else
			{
				Application.getLogger().info("addSelfAppraisals method in SelfAppraisalsDetails Service Implementation. New selfAppraisalDetails has already been updated in the database");
			    
				genericObject = selfAppraisalsDAOImp.addSelfAppraisals(selfAppraisals);
					
			}
		return genericObject;
		
		
		
	}

}

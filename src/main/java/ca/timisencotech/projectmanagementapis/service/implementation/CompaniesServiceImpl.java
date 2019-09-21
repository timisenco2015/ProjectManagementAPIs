package ca.timisencotech.projectmanagementapis.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import ca.timisencotech.projectmanagementapis.Application;
import ca.timisencotech.projectmanagementapis.dao.implementation.CompaniesDAOImp;
import ca.timisencotech.projectmanagementapis.domain.Companies;
import ca.timisencotech.projectmanagementapis.exception.ValidationError;
import ca.timisencotech.projectmanagementapis.service.CompaniesService;
import ca.timisencotech.projectmanagementapis.validation.Container;
import ca.timisencotech.projectmanagementapis.validation.ValidateCompanies;




@Service("CompaniesService")
@Transactional(propagation=Propagation.SUPPORTS, rollbackFor = Exception.class)
public class CompaniesServiceImpl implements CompaniesService{
	
	
	@Autowired
	private CompaniesDAOImp companiesDAOImp;
	
	
	@SuppressWarnings("unchecked")
	@Override
	public <T> Container<T> addCompanies(Companies companies,BindingResult result) {
		
		Container<T> genericObject=null;
		new ValidateCompanies().validate(companies, result);
		ValidationError  validationError = new ValidationError()	;
		if (result.hasErrors())
		{
			
			validationError.setErrorStatus("Failed");
			validationError.setMessage("Failed validation test for all or most of the fields");
			validationError.setAllErrorObject(result.getAllErrors());
   
		 genericObject = (Container<T>) new  Container<ValidationError> (validationError,"Error Object");
		 Application.getLogger().info("add new company validation error. Error info: "+validationError.getMessageObject());

		}
		
		else
		{
			Application.getLogger().info("addCompanies method in CompaniesService Service Implementation. add company details");
		    
			genericObject=companiesDAOImp.addCompanies(companies);
					
		}
		return genericObject;
	}

}

package ca.timisencotech.projectmanagementapis.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import ca.timisencotech.projectmanagementapis.Application;
import ca.timisencotech.projectmanagementapis.dao.implementation.CompanyDAOImp;
import ca.timisencotech.projectmanagementapis.domain.Company;
import ca.timisencotech.projectmanagementapis.exception.ValidationError;
import ca.timisencotech.projectmanagementapis.service.CompanyService;
import ca.timisencotech.projectmanagementapis.validation.Container;
import ca.timisencotech.projectmanagementapis.validation.ValidateCompanies;




@Service("CompanyService")
@Transactional(propagation=Propagation.SUPPORTS, rollbackFor = Exception.class)
public class CompanyServiceImpl implements CompanyService{
	
	
	@Autowired
	private CompanyDAOImp companyDAOImp;
	
	
	@SuppressWarnings("unchecked")
	@Override
	public <T> Container<T> addCompany(Company company,BindingResult result) {
		
		Container<T> genericObject=null;
		new ValidateCompanies().validate(company, result);
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
		    
			genericObject=companyDAOImp.addCompany(company);
					
		}
		return genericObject;
	}

}

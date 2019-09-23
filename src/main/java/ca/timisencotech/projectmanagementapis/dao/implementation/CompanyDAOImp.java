package ca.timisencotech.projectmanagementapis.dao.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import ca.timisencotech.projectmanagementapis.exception.ApiError;
import ca.timisencotech.projectmanagementapis.Application;
import ca.timisencotech.projectmanagementapis.dao.CompanyDAO;
import ca.timisencotech.projectmanagementapis.domain.Company;

import ca.timisencotech.projectmanagementapis.dto.CompaniesDetails;
import ca.timisencotech.projectmanagementapis.dto.UserSignUpDetails;
import ca.timisencotech.projectmanagementapis.exception.PersistentException;
import ca.timisencotech.projectmanagementapis.repository.CompaniesRepo;
import ca.timisencotech.projectmanagementapis.repository.UserSignUpRepo;
import ca.timisencotech.projectmanagementapis.validation.Container;

@Repository
public class CompanyDAOImp implements CompanyDAO {
	
	@Autowired
	UserSignUpRepo userSignUpRepo;
	
	@Autowired
	CompaniesRepo companiesRepo;
	
	
	PersistentException persistentException = new PersistentException();

	@SuppressWarnings("unchecked")
	@Override
	public <T> Container<T> addCompany(Company company) {
		Container<T> genericObject=null; 
		String email = company.getRegisterBy();
		
	
		UserSignUpDetails findUserSignUpDetails = userSignUpRepo.findUserSignUpDetailsByEmail(email);
		if(findUserSignUpDetails==null)
		{
			genericObject = (Container<T>) new  Container<ApiError> (persistentException.handleSearchReturnNull("We dont have this email: "+email+" in our database"),"Error Object");
			Application.getLogger().info("addCompanies method in company DAO Implementation. At this point unable to find foreign key email in the database");
			
		}
		else
		{
		try {
			CompaniesDetails newCompaniesDetails = new CompaniesDetails();
			newCompaniesDetails.setAddress(company.getAddress());
			newCompaniesDetails.setCity(company.getCity());
			newCompaniesDetails.setCompanyName(company.getCompanyName());
			newCompaniesDetails.setCountry(company.getCountry());
			newCompaniesDetails.setPhoneNumber(company.getPhoneNumber());
			newCompaniesDetails.setPostalCode(company.getPostalCode());
			newCompaniesDetails.setUserSignUpDetails(findUserSignUpDetails);
			newCompaniesDetails.setStateProvince(company.getStateProvince());
		
			CompaniesDetails responseCompaniesDetails = companiesRepo.save(newCompaniesDetails);
			Company domainCompanies = new Company();
			domainCompanies.setAddress(responseCompaniesDetails.getAddress());
			domainCompanies.setCity(responseCompaniesDetails.getCity());
			domainCompanies.setCompanyName(responseCompaniesDetails.getCompanyName());
			domainCompanies.setCountry(responseCompaniesDetails.getCountry());
			domainCompanies.setPhoneNumber(responseCompaniesDetails.getPhoneNumber());
			domainCompanies.setPostalCode(responseCompaniesDetails.getPostalCode());
			domainCompanies.setRegisterBy(email);
			domainCompanies.setStateProvince(responseCompaniesDetails.getStateProvince());
			
			
			Application.getLogger().info("addCompanies method in company DAO Implementation. At this point new company has successful saved to the database. Return city from repo is"+domainCompanies);
					 
				  genericObject = (Container<T>) new Container<Company>(domainCompanies,"Class Object");
			    } 
			 
		
			 
			 catch (DataAccessException dataAccessException) {
			    	
				 Application.getLogger().info("addCompanies method in company DAO Implementation. At this point there is an error that as prevented saving new compamies to the database");
				 
				 genericObject = (Container<T>) new  Container<ApiError> (persistentException.handleDataAccessException((DataAccessException)dataAccessException),"Error Object");
		
			 
			 }
		}
		return genericObject;
	}


}

package ca.timisencotech.projectmanagementapis.dao.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import ca.timisencotech.projectmanagementapis.exception.ApiError;
import ca.timisencotech.projectmanagementapis.Application;
import ca.timisencotech.projectmanagementapis.dao.CompaniesDAO;
import ca.timisencotech.projectmanagementapis.domain.Companies;
import ca.timisencotech.projectmanagementapis.dto.CompaniesDetails;
import ca.timisencotech.projectmanagementapis.dto.UserSignUpDetails;
import ca.timisencotech.projectmanagementapis.exception.PersistentException;
import ca.timisencotech.projectmanagementapis.repository.CompaniesRepository;
import ca.timisencotech.projectmanagementapis.repository.UserSignUpRepository;
import ca.timisencotech.projectmanagementapis.validation.Container;

@Repository
public class CompaniesDAOImp implements CompaniesDAO {
	
	@Autowired
	UserSignUpRepository userSignUpRepository;
	
	@Autowired
	CompaniesRepository companiesRepository;
	
	
	PersistentException persistentException = new PersistentException();

	@SuppressWarnings("unchecked")
	@Override
	public <T> Container<T> addCompanies(Companies companies) {
		Container<T> genericObject=null; 
		String email = companies.getRegisterBy();
		
	
		UserSignUpDetails findUserSignUpDetails = userSignUpRepository.findUserSignUpDetailsByEmail(email);
		if(findUserSignUpDetails==null)
		{
			genericObject = (Container<T>) new  Container<ApiError> (persistentException.handleSearchReturnNull("We dont have this email: "+email+" in our database"),"Error Object");
			Application.getLogger().info("addCompanies method in Companies DAO Implementation. At this point unable to find foreign key email in the database");
			
		}
		else
		{
		try {
			CompaniesDetails newCompaniesDetails = new CompaniesDetails();
			newCompaniesDetails.setAddress(companies.getAddress());
			newCompaniesDetails.setCity(companies.getCity());
			newCompaniesDetails.setCompanyName(companies.getCompanyName());
			newCompaniesDetails.setCountry(companies.getCountry());
			newCompaniesDetails.setPhoneNumber(companies.getPhoneNumber());
			newCompaniesDetails.setPostalCode(companies.getPostalCode());
			newCompaniesDetails.setUserSignUpDetails(findUserSignUpDetails);
			newCompaniesDetails.setStateProvince(companies.getStateProvince());
		
			CompaniesDetails responseCompaniesDetails = companiesRepository.save(newCompaniesDetails);
			Companies domainCompanies = new Companies();
			domainCompanies.setAddress(responseCompaniesDetails.getAddress());
			domainCompanies.setCity(responseCompaniesDetails.getCity());
			domainCompanies.setCompanyName(responseCompaniesDetails.getCompanyName());
			domainCompanies.setCountry(responseCompaniesDetails.getCountry());
			domainCompanies.setPhoneNumber(responseCompaniesDetails.getPhoneNumber());
			domainCompanies.setPostalCode(responseCompaniesDetails.getPostalCode());
			domainCompanies.setRegisterBy(email);
			domainCompanies.setStateProvince(responseCompaniesDetails.getStateProvince());
			
			
			Application.getLogger().info("addCompanies method in Companies DAO Implementation. At this point new companies has successful saved to the database. Return city from repo is"+domainCompanies);
					 
				  genericObject = (Container<T>) new Container<Companies>(domainCompanies,"Class Object");
			    } 
			 
		
			 
			 catch (DataAccessException dataAccessException) {
			    	
				 Application.getLogger().info("addCompanies method in Companies DAO Implementation. At this point there is an error that as prevented saving new compamies to the database");
				 
				 genericObject = (Container<T>) new  Container<ApiError> (persistentException.handleDataAccessException((DataAccessException)dataAccessException),"Error Object");
		
			 
			 }
		}
		return genericObject;
	}


}

package ca.timisencotech.projectmanagementapis.dao.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import ca.timisencotech.projectmanagementapis.Application;
import ca.timisencotech.projectmanagementapis.dao.CountriesDAO;
import ca.timisencotech.projectmanagementapis.domain.Country;
import ca.timisencotech.projectmanagementapis.exception.ApiError;
import ca.timisencotech.projectmanagementapis.dto.Countries;
import ca.timisencotech.projectmanagementapis.exception.PersistentException;
import ca.timisencotech.projectmanagementapis.repository.CountriesRepository;
import ca.timisencotech.projectmanagementapis.validation.Container;


@Repository
public class CountriesDAOImp implements CountriesDAO {
	
	@Autowired
	CountriesRepository countriesRepo;
	
	PersistentException persistentException = new PersistentException();

	@SuppressWarnings("unchecked")
	@Override
	public <T> Container<T> addCountries(Country country) {
		Container<T> genericObject=null; 
		
		Countries newCountry = new Countries();
		newCountry.setCountryId(country.getCountryId());
		newCountry.setCountryName(country.getCountryName());
		newCountry.setCountryShortCode(country.getCountryShortCode());
		newCountry.setPhoneCode(country.getphoneCode());
	
			Countries countries = null;
			 try {
				 
				 countries = countriesRepo.save(newCountry);
				 Country responseCountry = new Country();
				  responseCountry.setCountryId(countries.getCountryId());
				  responseCountry.setCountryName(countries.getCountryName());
				  responseCountry.setCountryShortCode(countries.getCountryShortCode());
				  responseCountry.setPhoneCode(countries.getphoneCode());
				  Application.getLogger().info("addCountries method in Countries DAO Implementation. At this point new country has successful saved to the database. Return country from repo is"+responseCountry);
				    
				  genericObject = (Container<T>) new Container<Country>(responseCountry,"Class Object");
			 }
				  catch (DataAccessException dataAccessException) {
				    	
							
					  Application.getLogger().info("addCountries method in Countries DAO Implementation. At this point there is an error that has prevented saving new country to the database");
					  
					  genericObject = (Container<T>) new  Container<ApiError> (persistentException.handleDataAccessException((DataAccessException)dataAccessException),"Error Object");
					   
					
					 
					 }
			
				
		return genericObject;
	}


	
	@SuppressWarnings("unchecked")
	@Override
	public <T> Container<T> getCountryWithId(int countryId) {
		Container<T> genericObject=null; 
		
	
			Countries countries = null;
			 try {
				 
				 countries = countriesRepo.findByCountryId(countryId);
				 Country responseCountry = new Country();
				  responseCountry.setCountryId(countries.getCountryId());
				  responseCountry.setCountryName(countries.getCountryName());
				  responseCountry.setCountryShortCode(countries.getCountryShortCode());
				  responseCountry.setPhoneCode(countries.getphoneCode());
				  Application.getLogger().info("getCountryWithId method in Countries DAO Implementation. At this point country details has been fectched from database using the country id pass as argument.");
				   
				  genericObject = (Container<T>) new Container<Country>(responseCountry,"Class Object");
			 }
				  catch (DataAccessException dataAccessException) {
					  Application.getLogger().info("getCountryWithId method in Countries DAO Implementation. At this point there is an error that has prevented fecthing country details based on the country id pass as argument");
					  
							genericObject = (Container<T>) new  Container<ApiError> (persistentException.handleDataAccessException((DataAccessException)dataAccessException),"Error Object");
					   
					
					 
					 }
			
				
		return genericObject;
	}

	
	

}

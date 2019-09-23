package ca.timisencotech.projectmanagementapis.dao.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import ca.timisencotech.projectmanagementapis.Application;
import ca.timisencotech.projectmanagementapis.dao.StatesProvincesDAO;
import ca.timisencotech.projectmanagementapis.domain.StateProvince;
import ca.timisencotech.projectmanagementapis.dto.Countries;
import ca.timisencotech.projectmanagementapis.dto.StatesProvinces;
import ca.timisencotech.projectmanagementapis.exception.ApiError;
import ca.timisencotech.projectmanagementapis.exception.PersistentException;
import ca.timisencotech.projectmanagementapis.repository.CountriesRepo;
import ca.timisencotech.projectmanagementapis.repository.StatesProvincesRepo;
import ca.timisencotech.projectmanagementapis.validation.Container;
@Repository
public class StatesProvincesDAOImp implements StatesProvincesDAO {
	
	@Autowired
	CountriesRepo countriesRepo;
	
	@Autowired
	StatesProvincesRepo statesProvincesRepo;
	
	PersistentException persistentException = new PersistentException();

	@SuppressWarnings("unchecked")
	@Override
	public <T> Container<T> addStatesProvinces(StateProvince stateProvince) {
		Container<T> genericObject=null; 
		Countries findCountries = countriesRepo.findByCountryId(stateProvince.getCountryId());
		if(findCountries==null)
		{
			Application.getLogger().info("addStatesProvinces method in StatesProvinces DAO Implementation. At this point unable to find foreign key countryId in the database");
			 
			genericObject = (Container<T>) new  Container<ApiError> (persistentException.handleSearchReturnNull("We dont have this country Id: "+stateProvince.getCountryId()+" in our database"),"Error Object");
		}
		else
		{
		StatesProvinces newStateProvince = new StatesProvinces();
		newStateProvince.setCountries(findCountries);
		newStateProvince.setStateProvinceId(stateProvince.getStateProvinceId());
		newStateProvince.setStateProvinceName(stateProvince.getStateProvinceName());
		
		StatesProvinces statesProvinces = null;
			 try {
				 
				 statesProvinces = statesProvincesRepo.save(newStateProvince);
				 StateProvince responseStateProvince = new StateProvince();
				 
				 responseStateProvince.setCountryId(stateProvince.getCountryId());
				 responseStateProvince.setStateProvinceId(statesProvinces.getStateProvinceId());
				 responseStateProvince.setStateProvinceName(statesProvinces.getStateProvinceName());
				 
				 Application.getLogger().info("addStatesProvinces method in StatesProvinces DAO Implementation. At this point new states or provinces has successful saved to the database. Return country from repo is"+responseStateProvince);
				 
				  genericObject = (Container<T>) new Container<StateProvince>(responseStateProvince,"Class Object");
			    } catch (DataAccessException dataAccessException) {
			    	Application.getLogger().info("addStatesProvinces method in StatesProvinces DAO Implementation. At this point there is an error that has prevented saving new states or provinces to the database");
					  
			    	genericObject = (Container<T>) new  Container<ApiError> (persistentException.handleDataAccessException(dataAccessException),"Error Object");
					
			    }
		}
		return genericObject;
	}


}

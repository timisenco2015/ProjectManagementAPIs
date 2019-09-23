package ca.timisencotech.projectmanagementapis.dao.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import ca.timisencotech.projectmanagementapis.exception.ApiError;
import ca.timisencotech.projectmanagementapis.Application;
import ca.timisencotech.projectmanagementapis.dao.CityDAO;
import ca.timisencotech.projectmanagementapis.domain.City;
import ca.timisencotech.projectmanagementapis.dto.Cities;
import ca.timisencotech.projectmanagementapis.dto.StatesProvinces;
import ca.timisencotech.projectmanagementapis.exception.PersistentException;
import ca.timisencotech.projectmanagementapis.repository.CitiesRepo;
import ca.timisencotech.projectmanagementapis.repository.StatesProvincesRepo;
import ca.timisencotech.projectmanagementapis.validation.Container;

@Repository
public class CityDAOImp implements CityDAO {
	
	@Autowired
	CitiesRepo citiesRepo;
	
	@Autowired
	StatesProvincesRepo statesProvincesRepo;
	
	
	PersistentException persistentException = new PersistentException();

	@SuppressWarnings("unchecked")
	@Override
	public <T> Container<T> addCity(City city) {
		Container<T> genericObject=null; 
		
		Cities newCity = new Cities();
		newCity.setCityId(city.getCityId());
		newCity.setCityName(city.getCityName());
		StatesProvinces findStateProvinces = statesProvincesRepo.findByStateProvinceId(city.getStateId());
		if(findStateProvinces==null)
		{
			genericObject = (Container<T>) new  Container<ApiError> (persistentException.handleSearchReturnNull("We dont have this state or province Id: "+city.getStateId()+" in our database"),"Error Object");
			Application.getLogger().info("addCity method in City DAO Implementation. At this point unable to find foreign key statePronvinceId in the database");
			
		}
		else
		{
		newCity.setStatesProvinces(findStateProvinces);
		
			Cities cities = null;
			 try {
				 
				 cities = citiesRepo.save(newCity);
				  City responseCity = new City();
				  responseCity.setCityId(cities.getCityId());
				  responseCity.setCityName(cities.getCityName());
				  responseCity.setStateId(city.getStateId());	
				 
				  Application.getLogger().info("addCities method in Cities DAO Implementation. At this point new cities as successful saved to the database. Return city from repo is"+responseCity);
					 
				  genericObject = (Container<T>) new Container<City>(responseCity,"Class Object");
			    } 
			 
		
			 
			 catch (DataAccessException dataAccessException) {
			    	
				 Application.getLogger().info("addCities method in Cities DAO Implementation. At this point there is an error that as prevented saving new cities to the database");
				 
				 genericObject = (Container<T>) new  Container<ApiError> (persistentException.handleDataAccessException((DataAccessException)dataAccessException),"Error Object");
		
			 
			 }
		}
		return genericObject;
	}


}

package ca.timisencotech.projectmanagementapis.daoTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.timisencotech.projectmanagementapis.dao.implementation.CitiesDAOImp;
import ca.timisencotech.projectmanagementapis.domain.City;
import ca.timisencotech.projectmanagementapis.exception.ApiError;
import ca.timisencotech.projectmanagementapis.validation.Container;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CitiesDAOImpTest<T>
{
	
	 @Autowired
	 CitiesDAOImp citiesDAOImp;
	

	@Test
	public void addCitiesTest() 
	 {
		  City city = new City();
		  city.setCityId(35);
		  city.setCityName("osogbo");
		  city.setStateId(25);	

			 Container<T> cityContainer = citiesDAOImp.addCities(city);
					
			String typeOfObject = cityContainer.getObjectType();
			if(typeOfObject.equalsIgnoreCase("Class Object"))
			{
			 
				City resultCity=	(City)cityContainer.getObject();
			 assertEquals(35, resultCity.getCityId());
			 assertEquals(25, resultCity.getStateId());
			 assertEquals("osogbo", resultCity.getCityName());
			}
		
			
		//checks for unique constraint	
			city = new City();
			  city.setCityId(38);
			  city.setCityName("Osogbo");
			  city.setStateId(25);	
			  
			cityContainer = citiesDAOImp.addCities(city);
				typeOfObject = cityContainer.getObjectType();

				if (typeOfObject.equalsIgnoreCase("Error Object"))
			{
				ApiError apiError = (ApiError)cityContainer.getObject();
				assertEquals("Persistence Error", apiError.getStatus());			}
			
		 
	 }
	

	
	 
	
	
}

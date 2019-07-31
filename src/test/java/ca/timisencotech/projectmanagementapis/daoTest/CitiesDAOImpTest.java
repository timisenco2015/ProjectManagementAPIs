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
		  city.setCityName("Ire");
		  city.setStateId(23);	

			 Container<T> cityContainer = citiesDAOImp.addCities(city);
					
			String typeOfObject = cityContainer.getObjectType();
			if(typeOfObject.equalsIgnoreCase("Class Object"))
			{
			 
				City resultCity=	(City)cityContainer.getObject();
			 assertEquals(35, resultCity.getCityId());
			 assertEquals(23, resultCity.getStateId());
			 assertEquals("Iresi", resultCity.getCityName());
			}
			else if (typeOfObject.equalsIgnoreCase("Error Object"))
			{
				ApiError apiError = (ApiError)cityContainer.getObject();
				assertEquals("Constraint error", apiError.getMessage());
			}
			
			
		 
	 }
	
/*
	@Test
	public void addServiceConstraintErrorTest() 
	 {
		//checks for field(s) unique test
		 uniqueConstraintTest();
		
		 //checks for field(s) null test
		 nullConstraintTest();
		
	 }
	 
	
	 
	 private void uniqueConstraintTest()
	 {
		
		  City city = new City();
		  city.setCityId(37);
		  city.setCityName("Iresi");
		  city.setStateId(23);	
		  
		 Container<T> cityContainer = citiesDAOImp.addCities(city);
			String typeOfObject = cityContainer.getObjectType();
			if(typeOfObject.equalsIgnoreCase("Class Object"))
		{
				City resultCity=	(City)cityContainer.getObject();
				 assertEquals(37, resultCity.getCityId());
				 assertEquals(23, resultCity.getStateId());
				 assertEquals("Iresi", resultCity.getCityName());
			}
		else if (typeOfObject.equalsIgnoreCase("Error Object"))
		{
			ApiError apiError = (ApiError)cityContainer.getObject();
			assertEquals("Constraint error", apiError.getMessage());
		}
	 }
	 

	 private void nullConstraintTest()
	 {
		
		 
		 City city = new City();
		  city.setCityId(38);
		  
		  city.setStateId(23);	
		  Container<T> cityContainer = citiesDAOImp.addCities(city);
			String typeOfObject = cityContainer.getObjectType();
			if(typeOfObject.equalsIgnoreCase("Class Object"))
		{
		 
				City resultCity=	(City)cityContainer.getObject();
				 assertEquals(38, resultCity.getCityId());
				 assertEquals(23, resultCity.getStateId());
			}
		else if (typeOfObject.equalsIgnoreCase("Error Object"))
		{
			ApiError apiError = (ApiError)cityContainer.getObject();
			assertEquals("Constraint error", apiError.getMessage());
		}
	 }
	
	*/
}

package ca.timisencotech.projectmanagementapis.serviceTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.DataBinder;
import ca.timisencotech.projectmanagementapis.domain.City;
import ca.timisencotech.projectmanagementapis.exception.ApiError;
import ca.timisencotech.projectmanagementapis.service.CitiesService;
import ca.timisencotech.projectmanagementapis.validation.Container;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CitiesServiceImpTest<T>
{
	
	 @Autowired
	 CitiesService citiesService;
	

	@Test
	public void addServiceTest() 
	 {
		  City city = new City();
		  city.setCityId(29);
		  city.setCityName("Osogbo");
		  city.setStateId(23);	

			 DataBinder binder = new DataBinder(city);
			 Container<T> cityContainer = citiesService.addCity(city, binder.getBindingResult());
			String typeOfObject = cityContainer.getObjectType();
			if(typeOfObject.equalsIgnoreCase("Class Object"))
			{
			 
				City resultCity=	(City)cityContainer.getObject();
			 assertEquals(29, resultCity.getCityId());
			 assertEquals(23, resultCity.getStateId());
			 assertEquals("Osogbo", resultCity.getCityName());
			}
			else if (typeOfObject.equalsIgnoreCase("Error Object"))
			{
				ApiError apiError = (ApiError)cityContainer.getObject();
				assertEquals("Constraint error", apiError.getMessage());
			}
			
			
		 
	 }
	
	
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
		  city.setCityId(27);
		  city.setCityName("Osogbo");
		  city.setStateId(26);	
		  
		 DataBinder binder = new DataBinder(city);
		 Container<T> cityContainer = citiesService.addCity(city, binder.getBindingResult());
			String typeOfObject = cityContainer.getObjectType();
			if(typeOfObject.equalsIgnoreCase("Class Object"))
			{
				 
				 City resultCity=	(City)cityContainer.getObject();
				 assertEquals(27, resultCity.getCityId());
				 assertEquals(26, resultCity.getStateId());
				 assertEquals("Osogbo", resultCity.getCityName());
				 
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
		  city.setCityId(28);
		  
		  city.setStateId(26);	
		  
		 DataBinder binder = new DataBinder(city);
		 Container<T> cityContainer = citiesService.addCity(city, binder.getBindingResult());
			String typeOfObject = cityContainer.getObjectType();
			if(typeOfObject.equalsIgnoreCase("Class Object"))
		{
		 

				 City resultCity=	(City)cityContainer.getObject();
				 assertEquals(28, resultCity.getCityId());
				 assertEquals(26, resultCity.getStateId());
				 assertEquals("Osogbo", resultCity.getCityName());
				 }
		else if (typeOfObject.equalsIgnoreCase("Error Object"))
		{
			ApiError apiError = (ApiError) cityContainer.getObject();
			assertEquals("Constraint error", apiError.getMessage());
		}
	 }
	
	
}

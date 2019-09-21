package ca.timisencotech.projectmanagementapis.serviceTest;

import static org.junit.Assert.assertEquals;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.DataBinder;
import ca.timisencotech.projectmanagementapis.domain.City;
import ca.timisencotech.projectmanagementapis.exception.ApiError;
import ca.timisencotech.projectmanagementapis.exception.ErrorObject;
import ca.timisencotech.projectmanagementapis.exception.ValidationError;
import ca.timisencotech.projectmanagementapis.service.CitiesService;
import ca.timisencotech.projectmanagementapis.validation.Container;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CitiesServiceImpTest<T>
{
	
	 @Autowired
	 CitiesService citiesService;
	

	@Test
	public void addServiceTest() throws JSONException 
	 {
		  City city = new City();
		  city.setCityId(29);
		  city.setCityName("Ikirun");
		  city.setStateId(25);	

			 DataBinder binder = new DataBinder(city);
			 Container<T> cityContainer = citiesService.addCity(city, binder.getBindingResult());
			String typeOfObject = cityContainer.getObjectType();
			if(typeOfObject.equalsIgnoreCase("Class Object"))
			{
			 
				City resultCity=	(City)cityContainer.getObject();
			 assertEquals(29, resultCity.getCityId());
			 assertEquals(25, resultCity.getStateId());
			 assertEquals("Ikirun", resultCity.getCityName());
			}
		
			
			//checks for unique constraint
			
			  city = new City();
			  city.setCityId(40);
			  city.setCityName("Ikirun");
			  city.setStateId(25);
			  
			 binder = new DataBinder(city);
			 cityContainer = citiesService.addCity(city, binder.getBindingResult());
			 typeOfObject = cityContainer.getObjectType();
				if (typeOfObject.equalsIgnoreCase("Error Object"))
				{
					ErrorObject errorObject = (ErrorObject) cityContainer.getObject();
					if(errorObject instanceof ApiError)
					{
						ApiError apiError = (ApiError)cityContainer.getObject();
						assertEquals("Persistence Error", apiError.getStatus());
			
					}
				}
				
				
		//checks for validation errors
				
				city = new City();
				  city.setCityId(28);
				  
				  city.setStateId(26);	
				  
				binder = new DataBinder(city);
				cityContainer = citiesService.addCity(city, binder.getBindingResult());
				typeOfObject = cityContainer.getObjectType();
				if (typeOfObject.equalsIgnoreCase("Error Object"))
				{

					ErrorObject errorObject = (ErrorObject)cityContainer.getObject();
					
					 if (errorObject instanceof ValidationError)
					{
						ValidationError validationError = (ValidationError)errorObject;
						assertEquals("Failed", validationError.getMessageObject().getString("errorStatus"));
						assertEquals("Failed validation test for all or most of the fields", validationError.getMessageObject().getString("message"));
						
						
					}
				}
	 }
	
	
	

	
	
}

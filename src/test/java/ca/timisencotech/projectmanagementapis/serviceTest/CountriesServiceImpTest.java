package ca.timisencotech.projectmanagementapis.serviceTest;

import static org.junit.Assert.assertEquals;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.DataBinder;

import ca.timisencotech.projectmanagementapis.domain.Country;
import ca.timisencotech.projectmanagementapis.exception.ApiError;
import ca.timisencotech.projectmanagementapis.exception.ErrorObject;
import ca.timisencotech.projectmanagementapis.exception.ValidationError;
import ca.timisencotech.projectmanagementapis.service.CountriesService;
import ca.timisencotech.projectmanagementapis.validation.Container;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CountriesServiceImpTest<T> {
	
	 @Autowired
	 CountriesService countriesService;
	
	 
	 @Test
		public void addServiceTest() throws JSONException 
		 {
			//checks that add service can call country repo save method
		 	// and save new country to database
			 Country country = new  Country();
			 country.setCountryId(3);
			 country.setCountryName("Ghana");
			 country.setCountryShortCode("GH");
			 country.setPhoneCode("235");
			 DataBinder binder = new DataBinder(country);
			 Container<T> countryContainer = countriesService.addCountry(country, binder.getBindingResult());
			String typeOfObject = countryContainer.getObjectType();
			if(typeOfObject.equalsIgnoreCase("Class Object"))
			{
			 
			 Country resultCountry=	(Country)countryContainer.getObject();
			 assertEquals(3, resultCountry.getCountryId());
			 assertEquals("Ghana", resultCountry.getCountryName());
			 assertEquals("GH", resultCountry.getCountryShortCode());
			 assertEquals("235", resultCountry.getphoneCode());
			}
			
			
			//Checks for unique constraint
			
			country = new  Country();
			 country.setCountryId(2);
			 country.setCountryName("Nigeria");
			 country.setCountryShortCode("NG");
			 country.setPhoneCode("234");
			binder = new DataBinder(country);
			 countryContainer = countriesService.addCountry(country, binder.getBindingResult());
			typeOfObject = countryContainer.getObjectType();
			if (typeOfObject.equalsIgnoreCase("Error Object"))
			{
				ErrorObject errorObject = (ErrorObject) countryContainer.getObject();
				if(errorObject instanceof ApiError)
				{
					ApiError apiError = (ApiError) countryContainer.getObject();
					assertEquals("Persistence Error", apiError.getStatus());
		
				}
			}
			
			// checks for validation error
			
			country = new  Country();
			 country.setCountryId(2);
			 
			 country.setCountryShortCode("CAN");
			 country.setPhoneCode("1");
			binder = new DataBinder(country);
			countryContainer = countriesService.addCountry(country, binder.getBindingResult());
			typeOfObject = countryContainer.getObjectType();
			
			if (typeOfObject.equalsIgnoreCase("Error Object"))
			{

				ErrorObject errorObject = (ErrorObject)countryContainer.getObject();
				
				 if (errorObject instanceof ValidationError)
				{
					ValidationError validationError = (ValidationError)errorObject;
					assertEquals("Failed", validationError.getMessageObject().getString("errorStatus"));
					assertEquals("Failed validation test for all or most of the fields", validationError.getMessageObject().getString("message"));
					
					
				}
			}
		 }
			 
	
	 
	
	 
	
	 

	 

	 
		

}

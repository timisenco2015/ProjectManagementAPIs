package ca.timisencotech.projectmanagementapis.serviceTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.DataBinder;

import ca.timisencotech.projectmanagementapis.domain.Country;
import ca.timisencotech.projectmanagementapis.exception.ApiError;
import ca.timisencotech.projectmanagementapis.service.CountriesService;
import ca.timisencotech.projectmanagementapis.validation.Container;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CountriesServiceImpTest<T> {
	
	 @Autowired
	 CountriesService countriesService;
	
	 
	 @Test
		public void addServiceTest() 
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
			else if (typeOfObject.equalsIgnoreCase("Error Object"))
			{
				ApiError apiError = (ApiError)countryContainer.getObject();
				assertEquals("Unique constraint error", apiError.getMessage());
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
		 Country country = new  Country();
		 country.setCountryId(2);
		 country.setCountryName("Nigeria");
		 country.setCountryShortCode("NG");
		 country.setPhoneCode("234");
		 DataBinder binder = new DataBinder(country);
		 Container<T> countryContainer = countriesService.addCountry(country, binder.getBindingResult());
		String typeOfObject = countryContainer.getObjectType();
		if(typeOfObject.equalsIgnoreCase("Class Object"))
		{
		 
		 Country resultCountry=	(Country)countryContainer.getObject();
		 assertEquals(1, resultCountry.getCountryId());
		 assertEquals("Nigeria", resultCountry.getCountryName());
		 assertEquals("NG", resultCountry.getCountryShortCode());
		 assertEquals("234", resultCountry.getphoneCode());
		}
		else if (typeOfObject.equalsIgnoreCase("Error Object"))
		{
			ApiError apiError = (ApiError)countryContainer.getObject();
			assertEquals("Constraint error", apiError.getMessage());
		}
	 }
	 

	 private void nullConstraintTest()
	 {
		 Country country = new  Country();
		 country.setCountryId(2);
		 
		 country.setCountryShortCode("CAN");
		 country.setPhoneCode("1");
		 DataBinder binder = new DataBinder(country);
		 Container<T> countryContainer = countriesService.addCountry(country, binder.getBindingResult());
		String typeOfObject = countryContainer.getObjectType();
		if(typeOfObject.equalsIgnoreCase("Class Object"))
		{
		 
		 Country resultCountry=	(Country)countryContainer.getObject();
		 assertEquals(1, resultCountry.getCountryId());
		 assertEquals("Nigeria", resultCountry.getCountryName());
		 assertEquals("NG", resultCountry.getCountryShortCode());
		 assertEquals("234", resultCountry.getphoneCode());
		}
		else if (typeOfObject.equalsIgnoreCase("Error Object"))
		{
			ApiError apiError = (ApiError)countryContainer.getObject();
			assertEquals("Constraint error", apiError.getMessage());
		}
	 }
		 
		

}

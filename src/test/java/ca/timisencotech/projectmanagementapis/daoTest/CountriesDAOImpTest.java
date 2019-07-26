package ca.timisencotech.projectmanagementapis.daoTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.timisencotech.projectmanagementapis.dao.implementation.CountriesDAOImp;
import ca.timisencotech.projectmanagementapis.domain.Country;
import ca.timisencotech.projectmanagementapis.exception.ApiError;
import ca.timisencotech.projectmanagementapis.validation.Container;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CountriesDAOImpTest<T> {
	
	 @Autowired
	 CountriesDAOImp countriesDAOImp;
	
	 
	 @Test
		public void addServiceTest() 
		 {
			//checks that add service can call country repo save method
		 	// and save new country to database
			 Country country = new  Country();
			 country.setCountryId(5);
			 country.setCountryName("Mexico");
			 country.setCountryShortCode("MX");
			 country.setPhoneCode("238");
			 Container<T> countryContainer = countriesDAOImp.addCountries(country);
			String typeOfObject = countryContainer.getObjectType();
			if(typeOfObject.equalsIgnoreCase("Class Object"))
			{
			 
			 Country resultCountry=	(Country)countryContainer.getObject();
			 assertEquals(5, resultCountry.getCountryId());
			 assertEquals("Mexico", resultCountry.getCountryName());
			 assertEquals("MX", resultCountry.getCountryShortCode());
			 assertEquals("238", resultCountry.getphoneCode());
			}
			else if (typeOfObject.equalsIgnoreCase("Error Object"))
			{
				ApiError apiError = (ApiError)countryContainer.getObject();
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
		 Country country = new  Country();
		 country.setCountryId(6);
		 country.setCountryName("Mexico");
		 country.setCountryShortCode("MX");
		 country.setPhoneCode("238");
		 Container<T> countryContainer = countriesDAOImp.addCountries(country);
			String typeOfObject = countryContainer.getObjectType();
		if(typeOfObject.equalsIgnoreCase("Class Object"))
		{
		 
		 Country resultCountry=	(Country)countryContainer.getObject();
		 assertEquals(6, resultCountry.getCountryId());
		 assertEquals("Mexico", resultCountry.getCountryName());
		 assertEquals("MX", resultCountry.getCountryShortCode());
		 assertEquals("238", resultCountry.getphoneCode());
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
		 country.setCountryId(6);
		
		 country.setCountryShortCode("MX");
		 Container<T> countryContainer = countriesDAOImp.addCountries(country);
		String typeOfObject = countryContainer.getObjectType();
		if(typeOfObject.equalsIgnoreCase("Class Object"))
		{
		 
		 Country resultCountry=	(Country)countryContainer.getObject();
		 assertEquals(6, resultCountry.getCountryId());
		 assertEquals("Mexico", resultCountry.getCountryName());
		 assertEquals("MX", resultCountry.getCountryShortCode());
		 assertEquals("238", resultCountry.getphoneCode());
		}
		else if (typeOfObject.equalsIgnoreCase("Error Object"))
		{
			ApiError apiError = (ApiError)countryContainer.getObject();
			assertEquals("Constraint error", apiError.getMessage());
		}
	 }
		 
		

}

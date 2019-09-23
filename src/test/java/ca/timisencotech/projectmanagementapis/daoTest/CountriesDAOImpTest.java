package ca.timisencotech.projectmanagementapis.daoTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.timisencotech.projectmanagementapis.dao.implementation.CountryDAOImp;
import ca.timisencotech.projectmanagementapis.domain.Country;
import ca.timisencotech.projectmanagementapis.exception.ApiError;
import ca.timisencotech.projectmanagementapis.validation.Container;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CountriesDAOImpTest<T> {
	
	 @Autowired
	 CountryDAOImp countryDAOImp;
	
	 
	 @Test
		public void addCountryTest() 
		 {
			//checks that add service can call country repo save method
		 	// and save new country to database
			 Country country = new  Country();
			 country.setCountryId(5);
			 country.setCountryName("Arizona");
			 country.setCountryShortCode("AZ");
			 country.setPhoneCode("239");
			 Container<T> countryContainer = countryDAOImp.addCountry(country);
			String typeOfObject = countryContainer.getObjectType();
			if(typeOfObject.equalsIgnoreCase("Class Object"))
			{
			 
			 Country resultCountry=	(Country)countryContainer.getObject();
			 assertEquals(5, resultCountry.getCountryId());
			 assertEquals("Arizona", resultCountry.getCountryName());
			 assertEquals("AZ", resultCountry.getCountryShortCode());
			 assertEquals("239", resultCountry.getphoneCode());
			}
		
			
			//checks for unique constraint
			
			country = new  Country();
			 country.setCountryId(6);
			 country.setCountryName("Arizona");
			 country.setCountryShortCode("AZ");
			 country.setPhoneCode("239");
			  countryContainer = countryDAOImp.addCountry(country);
			typeOfObject = countryContainer.getObjectType();
		
			if (typeOfObject.equalsIgnoreCase("Error Object"))
			{
				
				ApiError apiError = (ApiError)countryContainer.getObject();
				assertEquals("Persistence Error", apiError.getStatus());
			}
			
			
			
		 }
			 
	
	 
	
	

}

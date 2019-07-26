package ca.timisencotech.projectmanagementapis.dtoTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ca.timisencotech.projectmanagementapis.dto.Countries;
import ca.timisencotech.projectmanagementapis.dto.StatesProvinces;


@RunWith(SpringRunner.class)
@SpringBootTest
public class StatesProvincesTest 
{
	@Test
	public void testSettersGetters() 
	{
		StatesProvinces statesProvinces = new StatesProvinces();
	Countries countries = new Countries();
		
		
		
		//check setter and getter for state or province id
		// A)

		statesProvinces.setStateProvinceId(1);
		int testResult1 = 1;
		assertEquals(testResult1, statesProvinces.getStateProvinceId());
		
		// B)
		
		statesProvinces.setStateProvinceId(2);
		testResult1 = 2;
		assertEquals(testResult1, statesProvinces.getStateProvinceId());
		
		// C)
		
		statesProvinces.setStateProvinceId(3);
		testResult1 = 3;
		assertEquals(testResult1, statesProvinces.getStateProvinceId());
		
		//check setter and getter for province or state name
		// A)
		
		statesProvinces.setStateProvinceName("Andaman and Nicobar Islands");
		String testResult2 = "Andaman and Nicobar Islands";
		assertEquals(testResult2, statesProvinces.getStateProvinceName());
		
		// B)
		statesProvinces.setStateProvinceName("Andhra Pradesh");
		testResult2 = "Andhra Pradesh";
		assertEquals(testResult2, statesProvinces.getStateProvinceName());
		
		
		// C)
		statesProvinces.setStateProvinceName("Arunachal Pradesh");
		testResult2 = "Arunachal Pradesh";
		assertEquals(testResult2, statesProvinces.getStateProvinceName());
		
		
		
		//check setter and getter for country id
				// A)
				
		countries = new Countries();
		countries.setCountryId(1);
		countries.setCountryName("Nigeria");
		countries.setCountryShortCode("NIG");
		countries.setPhoneCode("234");
		statesProvinces.setCountries(countries);
		
		int testResult3 = 1;
		assertEquals(testResult3,statesProvinces.getCountries().getCountryId());
				
				//check all methods

				assertEquals(3, statesProvinces.getStateProvinceId());
				assertEquals("Arunachal Pradesh", statesProvinces.getStateProvinceName());
				assertEquals(1, statesProvinces.getCountries().getCountryId());
				
	}

}

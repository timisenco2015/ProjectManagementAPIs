package ca.timisencotech.projectmanagementapis.dtoTest;

import static org.junit.Assert.assertEquals;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ca.timisencotech.projectmanagementapis.dto.Cities;
import ca.timisencotech.projectmanagementapis.dto.Countries;
import ca.timisencotech.projectmanagementapis.dto.StatesProvinces;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CitiesTest 
{
	@Test
	public void testSettersGetters() 
	{
		Cities cities = new Cities();
		StatesProvinces statesProvinces = new StatesProvinces();
		Countries countries = new Countries();
		
		countries.setCountryId(1);
		countries.setCountryName("Nigeria");
		countries.setCountryShortCode("NIG");
		countries.setPhoneCode("234");
		
		
		statesProvinces.setCountries(countries);
		statesProvinces.setStateProvinceId(23);
		statesProvinces.setStateProvinceName("Osun State");
		
		
	
		
		
		//check setter and getter for city id
		// A)

		cities.setCityId(1);
		int testResult1 = 1;
		assertEquals(testResult1, cities.getCityId());
		
		// B)
		
		cities.setCityId(2);
		 testResult1 = 2;
		assertEquals(testResult1, cities.getCityId());
		
		// C)
		
		cities.setCityId(3);
		 testResult1 = 3;
		assertEquals(testResult1, cities.getCityId());
		
		//check setter and getter for city id
		// A)
		
		cities.setCityName("Bombuflat");
		String testResult2 = "Bombuflat";
		assertEquals(testResult2, cities.getCityName());
		
		// B)
		cities.setCityName("Garacharma");
		 testResult2 = "Garacharma";
		assertEquals(testResult2, cities.getCityName());
		
		// C)
		cities.setCityName("Port Blair");
		 testResult2 = "Port Blair";
		assertEquals(testResult2, cities.getCityName());
		
		//check setter and getter for state id
		// A)
		int testResult3 = 23;
		statesProvinces = new StatesProvinces();
		statesProvinces.setCountries(countries);
		statesProvinces.setStateProvinceId(23);
		statesProvinces.setStateProvinceName("Osun State");
		cities.setStatesProvinces(statesProvinces);
		
		assertEquals(testResult3, cities.getStatesProvinces().getStateProvinceId());
		
		// B)
		testResult3 = 28;
		statesProvinces = new StatesProvinces();
		statesProvinces.setCountries(countries);
		statesProvinces.setStateProvinceId(28);
		statesProvinces.setStateProvinceName("Oyo State");
		cities.setStatesProvinces(statesProvinces);
		
		assertEquals(testResult3, cities.getStatesProvinces().getStateProvinceId());
		
		// C)
		
		testResult3 = 28;
		statesProvinces = new StatesProvinces();
		statesProvinces.setCountries(countries);
		statesProvinces.setStateProvinceId(28);
		statesProvinces.setStateProvinceName("Ekiti State");
		cities.setStatesProvinces(statesProvinces);
		
		assertEquals(testResult3, cities.getStatesProvinces().getStateProvinceId());
		
		
		//check all methods

		assertEquals(3, cities.getCityId());
		assertEquals("Port Blair", cities.getCityName());
		assertEquals(28, cities.getStatesProvinces().getStateProvinceId());
		
	}

}

package ca.timisencotech.projectmanagementapis.dtoTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ca.timisencotech.projectmanagementapis.dto.Countries;



@RunWith(SpringRunner.class)
@SpringBootTest
public class CountriesTest 
{
	@Test
	public void testSettersGetters() 
	{
		Countries countries = new Countries();
		
		//check setter and getter for country id
		// A)

		countries.setCountryId(1);;
		int testResult1 = 1;
		assertEquals(testResult1, countries.getCountryId());
		
		// B)
		
		countries.setCountryId(2);
		testResult1 = 2;
		assertEquals(testResult1, countries.getCountryId());
		
		// C)
		
		countries.setCountryId(3);
		testResult1 = 3;
		assertEquals(testResult1, countries.getCountryId());
		
		//check setter and getter for country name
		// A)
		countries.setCountryName("Afghanistan");
		String testResult2 = "Afghanistan";
		assertEquals(testResult2, countries.getCountryName());
		
		// B)
		countries.setCountryName("Albania");
		testResult2 = "Albania";
		assertEquals(testResult2, countries.getCountryName());
		
		
		// C)
		countries.setCountryName("Algeria");
		testResult2 = "Algeria";
		assertEquals(testResult2, countries.getCountryName());
		
		
		
		//check setter and getter for country code
				// A)
		countries.setCountryShortCode("AF");
		String testResult3 = "AF";
		assertEquals(testResult3, countries.getCountryShortCode());
				
		
		countries.setCountryShortCode("AL");
		testResult3 = "AL";
		assertEquals(testResult3, countries.getCountryShortCode());
		
		
		countries.setCountryShortCode("DZ");
		testResult3 = "DZ";
		assertEquals(testResult3, countries.getCountryShortCode());
		
		
		
		//check setter and getter for country code
		// A)
		countries.setPhoneCode("93");
		String testResult4 = "93";
		assertEquals(testResult4, countries.getphoneCode());
		

		countries.setPhoneCode("93");
		 testResult4 = "93";
		assertEquals(testResult4, countries.getphoneCode());
		

		countries.setPhoneCode("355");
		testResult4 = "355";
		assertEquals(testResult4, countries.getphoneCode());
		
		
		//check all methods

		assertEquals(3, countries.getCountryId());
		assertEquals("Algeria", countries.getCountryName());
		assertEquals("DZ", countries.getCountryShortCode());
		assertEquals("355", countries.getphoneCode());

		
	}

}

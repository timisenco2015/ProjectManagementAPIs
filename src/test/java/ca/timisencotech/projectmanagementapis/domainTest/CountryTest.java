package ca.timisencotech.projectmanagementapis.domainTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ca.timisencotech.projectmanagementapis.domain.Country;



@RunWith(SpringRunner.class)
@SpringBootTest
public class CountryTest 
{
	@Test
	public void testSettersGetters() 
	{
		Country country = new Country();
		
		//check setter and getter for country id
		// A)

		country.setCountryId(1);;
		int testResult1 = 1;
		assertEquals(testResult1, country.getCountryId());
		
		// B)
		
		country.setCountryId(2);
		testResult1 = 2;
		assertEquals(testResult1, country.getCountryId());
		
		// C)
		
		country.setCountryId(3);
		testResult1 = 3;
		assertEquals(testResult1, country.getCountryId());
		
		//check setter and getter for country name
		// A)
		country.setCountryName("Afghanistan");
		String testResult2 = "Afghanistan";
		assertEquals(testResult2, country.getCountryName());
		
		// B)
		country.setCountryName("Albania");
		testResult2 = "Albania";
		assertEquals(testResult2, country.getCountryName());
		
		
		// C)
		country.setCountryName("Algeria");
		testResult2 = "Algeria";
		assertEquals(testResult2, country.getCountryName());
		
		
		
		//check setter and getter for country code
				// A)
		country.setCountryShortCode("AF");
		String testResult3 = "AF";
		assertEquals(testResult3, country.getCountryShortCode());
				
		
		country.setCountryShortCode("AL");
		testResult3 = "AL";
		assertEquals(testResult3, country.getCountryShortCode());
		
		
		country.setCountryShortCode("DZ");
		testResult3 = "DZ";
		assertEquals(testResult3, country.getCountryShortCode());
		
		
		
		//check setter and getter for country code
		// A)
		country.setPhoneCode("93");
		String testResult4 = "93";
		assertEquals(testResult4, country.getphoneCode());
		

		country.setPhoneCode("93");
		 testResult4 = "93";
		assertEquals(testResult4, country.getphoneCode());
		

		country.setPhoneCode("355");
		testResult4 = "355";
		assertEquals(testResult4, country.getphoneCode());
		
		
		//check all methods

		assertEquals(3, country.getCountryId());
		assertEquals("Algeria", country.getCountryName());
		assertEquals("DZ", country.getCountryShortCode());
		assertEquals("355", country.getphoneCode());

		
	}

}

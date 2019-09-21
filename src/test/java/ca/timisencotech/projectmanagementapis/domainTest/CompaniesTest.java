package ca.timisencotech.projectmanagementapis.domainTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.timisencotech.projectmanagementapis.domain.Companies;



@RunWith(SpringRunner.class)
@SpringBootTest
public class CompaniesTest 
{
	@Test
	public void testSettersGetters() 
	{
		Companies companies = new  Companies();
		
		
		//check setter and getter for address
		companies.setAddress("616 Armitgae Crescent");
		String testResult1 = "616 Armitgae Crescent";
		assertEquals(testResult1, companies.getAddress());
		
		
		
		//check setter and getter for city
		companies.setCity("Sherwood Park");
		String testResult2 = "Sherwood Park";
		assertEquals(testResult2, companies.getCity());
		
		//check setter and getter for company name
		companies.setCompanyName("TimiTech");
		String testResult3 = "TimiTech";
		assertEquals(testResult3, companies.getCompanyName());
		
		
		//check setter and getter for country name
		companies.setCountry("Canada");
		String testResult4 = "Canada";
		assertEquals(testResult4, companies.getCountry());
		
		
		//check setter and getter for phone number
		companies.setPhoneNumber("2059634577");
		String testResult5 = "2059634577";
		assertEquals(testResult5, companies.getPhoneNumber());
		
		
		//check setter and getter for postal code
		companies.setPostalCode("T8H 0T7");
		String testResult6 = "T8H 0T7";
		assertEquals(testResult6, companies.getPostalCode());
		
		
		
		//check setter and getter for register by
		companies.setRegisterBy("userAAEmail@gmail.com");
		String testResult7 = "userAAEmail@gmail.com";
		assertEquals(testResult7, companies.getRegisterBy());
				
		
		companies.setStateProvince("Edmonton");
		String testResult8 = "Edmonton";
		assertEquals(testResult8, companies.getStateProvince());
		
		
		

		assertEquals(testResult1, companies.getAddress());
		assertEquals(testResult2, companies.getCity());
		assertEquals(testResult3, companies.getCompanyName());
		assertEquals(testResult4, companies.getCountry());
		assertEquals(testResult5, companies.getPhoneNumber());
		assertEquals(testResult6, companies.getPostalCode());
		assertEquals(testResult7, companies.getRegisterBy());
		assertEquals(testResult8, companies.getStateProvince());
	}

}

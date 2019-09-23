package ca.timisencotech.projectmanagementapis.domainTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.timisencotech.projectmanagementapis.domain.Company;



@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyTest 
{
	@Test
	public void testSettersGetters() 
	{
		Company company = new  Company();
		
		
		//check setter and getter for address
		company.setAddress("616 Armitgae Crescent");
		String testResult1 = "616 Armitgae Crescent";
		assertEquals(testResult1, company.getAddress());
		
		
		
		//check setter and getter for city
		company.setCity("Sherwood Park");
		String testResult2 = "Sherwood Park";
		assertEquals(testResult2, company.getCity());
		
		//check setter and getter for company name
		company.setCompanyName("TimiTech");
		String testResult3 = "TimiTech";
		assertEquals(testResult3, company.getCompanyName());
		
		
		//check setter and getter for country name
		company.setCountry("Canada");
		String testResult4 = "Canada";
		assertEquals(testResult4, company.getCountry());
		
		
		//check setter and getter for phone number
		company.setPhoneNumber("2059634577");
		String testResult5 = "2059634577";
		assertEquals(testResult5, company.getPhoneNumber());
		
		
		//check setter and getter for postal code
		company.setPostalCode("T8H 0T7");
		String testResult6 = "T8H 0T7";
		assertEquals(testResult6, company.getPostalCode());
		
		
		
		//check setter and getter for register by
		company.setRegisterBy("userAAEmail@gmail.com");
		String testResult7 = "userAAEmail@gmail.com";
		assertEquals(testResult7, company.getRegisterBy());
				
		
		company.setStateProvince("Edmonton");
		String testResult8 = "Edmonton";
		assertEquals(testResult8, company.getStateProvince());
		
		
		

		assertEquals(testResult1, company.getAddress());
		assertEquals(testResult2, company.getCity());
		assertEquals(testResult3, company.getCompanyName());
		assertEquals(testResult4, company.getCountry());
		assertEquals(testResult5, company.getPhoneNumber());
		assertEquals(testResult6, company.getPostalCode());
		assertEquals(testResult7, company.getRegisterBy());
		assertEquals(testResult8, company.getStateProvince());
	}

}

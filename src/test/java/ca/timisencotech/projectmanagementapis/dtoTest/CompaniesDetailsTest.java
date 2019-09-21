package ca.timisencotech.projectmanagementapis.dtoTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.timisencotech.projectmanagementapis.dto.CompaniesDetails;
import ca.timisencotech.projectmanagementapis.dto.UserSignUpDetails;
import ca.timisencotech.projectmanagementapis.repository.UserSignUpRepository;



@RunWith(SpringRunner.class)
@SpringBootTest
public class CompaniesDetailsTest 
{
	@Autowired
	UserSignUpRepository userSignUpRepository;
	
	@Test
	public void testSettersGetters() 
	{
		
		UserSignUpDetails findUserSignUpDetails= userSignUpRepository.findUserSignUpDetailsByEmail("userAAEmail@gmail.com");
		
		CompaniesDetails companiesDetails = new CompaniesDetails();
		
		//check setter and getter for address
				companiesDetails.setAddress("616 Armitgae Crescent");
				String testResult1 = "616 Armitgae Crescent";
				assertEquals(testResult1, companiesDetails.getAddress());
				
				
				
				//check setter and getter for city
				companiesDetails.setCity("Sherwood Park");
				String testResult2 = "Sherwood Park";
				assertEquals(testResult2, companiesDetails.getCity());
				
				//check setter and getter for company name
				companiesDetails.setCompanyName("TimiTech");
				String testResult3 = "TimiTech";
				assertEquals(testResult3, companiesDetails.getCompanyName());
				
				
				//check setter and getter for country name
				companiesDetails.setCountry("Canada");
				String testResult4 = "Canada";
				assertEquals(testResult4, companiesDetails.getCountry());
				
				
				//check setter and getter for phone number
				companiesDetails.setPhoneNumber("2059634577");
				String testResult5 = "2059634577";
				assertEquals(testResult5, companiesDetails.getPhoneNumber());
				
				
				//check setter and getter for postal code
				companiesDetails.setPostalCode("T8H 0T7");
				String testResult6 = "T8H 0T7";
				assertEquals(testResult6, companiesDetails.getPostalCode());
				
				
				
				//check setter and getter for signup details
				companiesDetails.setUserSignUpDetails(findUserSignUpDetails);
				assertEquals(findUserSignUpDetails, companiesDetails.getUserSignUpDetails());
						
				
				companiesDetails.setStateProvince("Edmonton");
				String testResult8 = "Edmonton";
				assertEquals(testResult8, companiesDetails.getStateProvince());
				
				
				

				assertEquals(testResult1, companiesDetails.getAddress());
				assertEquals(testResult2, companiesDetails.getCity());
				assertEquals(testResult3, companiesDetails.getCompanyName());
				assertEquals(testResult4, companiesDetails.getCountry());
				assertEquals(testResult5, companiesDetails.getPhoneNumber());
				assertEquals(testResult6, companiesDetails.getPostalCode());
				assertEquals(findUserSignUpDetails, companiesDetails.getUserSignUpDetails());
				assertEquals(testResult8, companiesDetails.getStateProvince());

		
	}

}

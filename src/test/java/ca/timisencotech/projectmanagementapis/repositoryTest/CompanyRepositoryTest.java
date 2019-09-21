package ca.timisencotech.projectmanagementapis.repositoryTest;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.timisencotech.projectmanagementapis.dto.CompaniesDetails;
import ca.timisencotech.projectmanagementapis.dto.UserSignUpDetails;
import ca.timisencotech.projectmanagementapis.repository.CompaniesRepository;
import ca.timisencotech.projectmanagementapis.repository.UserSignUpRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyRepositoryTest {
		 
		@Autowired
		  private CompaniesRepository companiesRepository;
		
		@Autowired
		UserSignUpRepository userSignUpRepository;

		  @Test
		  public void saveTest() {
			  
			  
			CompaniesDetails companiesDetails = new CompaniesDetails();
			companiesDetails.setAddress("616 Armitgae Crescent");
			companiesDetails.setCity("Sherwood Park");
			companiesDetails.setCompanyName("AyoTech");
			companiesDetails.setCountry("Canada");
			companiesDetails.setPhoneNumber("2059634577");
			companiesDetails.setPostalCode("T8H 0T7");
			
			UserSignUpDetails findUserSignUpDetails= userSignUpRepository.findUserSignUpDetailsByEmail("userAAEmail@gmail.com");
			
			companiesDetails.setUserSignUpDetails(findUserSignUpDetails);
			companiesDetails.setStateProvince("Edmonton");
			companiesRepository.save(companiesDetails);
			assertNotNull(companiesRepository.findCompaniesDetails("AyoTech"));
		  }
		  
	
		  
		  
		  @Test
		  public void findByCountryIdTest() {
			  assertNotNull(companiesRepository.findCompaniesDetails("AyoTech"));
			   }

	}




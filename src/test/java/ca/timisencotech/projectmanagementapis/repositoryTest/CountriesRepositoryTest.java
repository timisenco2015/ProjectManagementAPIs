package ca.timisencotech.projectmanagementapis.repositoryTest;


import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ca.timisencotech.projectmanagementapis.dto.Countries;
import ca.timisencotech.projectmanagementapis.repository.CountriesRepo;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CountriesRepositoryTest {
		 
		@Autowired
		  private CountriesRepo countriesRepo;

		  @Test
		  public void saveTest() {
			  
			  
			  Countries countries = new Countries();
		   
			  countries.setCountryId(1);
			  countries.setCountryShortCode("NG");
				countries.setPhoneCode("234");
				countries.setCountryName("Nigeria");
				countriesRepo.save(countries);
				
				assertNotNull( countriesRepo.findByCountryId(1));
		  }
		  
	
		  
		  
		  @Test
		  public void findByCountryIdTest() {
			  
			
				
				assertNotNull( countriesRepo.findByCountryId(1));
		  }

	}




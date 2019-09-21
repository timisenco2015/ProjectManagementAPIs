package ca.timisencotech.projectmanagementapis.repositoryTest;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;

import ca.timisencotech.projectmanagementapis.dto.Countries;
import ca.timisencotech.projectmanagementapis.repository.CountriesRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CountriesRepositoryTest {
		 
		@Autowired
		  private CountriesRepository countriesRepository;

		  @Test
		  public void saveTest() {
			  
			  
			  Countries countries = new Countries();
		   
			  countries.setCountryId(1);
			  countries.setCountryShortCode("NG");
				countries.setPhoneCode("234");
				countries.setCountryName("Nigeria");
				countriesRepository.save(countries);
				
				assertNotNull( countriesRepository.findByCountryId(1));
		  }
		  
	
		  
		  
		  @Test
		  public void findByCountryIdTest() {
			  
			
				
				assertNotNull( countriesRepository.findByCountryId(1));
		  }

	}




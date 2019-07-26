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
				
				assertNotNull( countriesRepository.findByCountryId(1));
		  }
		  
	
		  @Test
		  public void  uniqueViolationTest() {
			  
			  
			  Countries countries = new Countries();
		   
			  // Check for country name uniqueness
			  
			  countries.setCountryId(2);
				countries.setCountryName("Nigeria");
				countries.setCountryShortCode("NG");
				countries.setPhoneCode("1");
				
				DataIntegrityViolationException exception = Assertions.assertThrows(DataIntegrityViolationException.class, () -> {
					 countriesRepository.save(countries);
				   });
					
				assertTrue(exception.getMostSpecificCause().toString().contains("Duplicate entry 'Nigeria'"));
						
				 // Check for country short code uniqueness
				  
				  countries.setCountryId(2);
					countries.setCountryName("Nigeriaa");
					countries.setCountryShortCode("NG");
					countries.setPhoneCode("1");
					
					 exception = Assertions.assertThrows(DataIntegrityViolationException.class, () -> {
						 countriesRepository.save(countries);
					   });
					 assertTrue(exception.getMostSpecificCause().toString().contains("Duplicate entry 'NG'"));
						
				     
		  
		  
		  
		  }
		 
		  
		  @Test
		  public void notNullViolationTest() {
			  
			  
			  Countries countries1 = new Countries();
		   
			  //check country name set to null
			
			  countries1.setCountryId(2);
				countries1.setCountryShortCode("BL");
				countries1.setPhoneCode("1");
				
			
			  
				DataIntegrityViolationException exception = Assertions.assertThrows(DataIntegrityViolationException.class, () -> {
				  countriesRepository.save(countries1);
			    });

			 assertTrue(exception.getMostSpecificCause().toString().contains("Column 'countryname' cannot be null"));
				
			     
			  
			  //check country short code set to null
			 Countries countries2 = new Countries();
			  countries2.setCountryId(2);
				countries2.setCountryName("Nigeriaa");
				countries2.setPhoneCode("1");
				
			
			  
			   exception = Assertions.assertThrows(DataIntegrityViolationException.class, () -> {
				  countriesRepository.save(countries2);
			    });

			  assertTrue(exception.getMostSpecificCause().toString().contains("Column 'sortname' cannot be null"));
				
		  
			  
	  //check phone code set to null
			  Countries countries3 = new Countries(); 
			  countries3.setCountryId(3);
				countries3.setCountryName("Nigeria");
				countries3.setCountryShortCode("NG");
			
			
			  
			 exception = Assertions.assertThrows(DataIntegrityViolationException.class, () -> {
				  countriesRepository.save(countries3);
			    });

			   assertTrue(exception.getMostSpecificCause().toString().contains("Column 'phonecode' cannot be null"));
				
			  
		  }
		  
		  
		  @Test
		  public void findByCountryIdTest() {
			  
			
				
				assertNotNull( countriesRepository.findByCountryId(1));
		  }

	}




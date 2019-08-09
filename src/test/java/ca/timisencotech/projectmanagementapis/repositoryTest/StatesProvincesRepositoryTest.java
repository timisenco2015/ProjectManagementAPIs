package ca.timisencotech.projectmanagementapis.repositoryTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.test.context.junit4.SpringRunner;

import ca.timisencotech.projectmanagementapis.dto.Countries;
import ca.timisencotech.projectmanagementapis.dto.StatesProvinces;
import ca.timisencotech.projectmanagementapis.repository.StatesProvincesRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
public class StatesProvincesRepositoryTest {
		 
		@Autowired
		  private StatesProvincesRepository statesProvincesRepository;

		  @Test
		  public void saveTest() {
			  
			  
			  StatesProvinces statesProvinces = new StatesProvinces();
		   
			  Countries countries = new Countries();
				
				countries.setCountryId(1);
				countries.setCountryName("Nigeria");
				countries.setCountryShortCode("NIG");
				countries.setPhoneCode("234");


			  
			  statesProvinces.setStateProvinceId(26);
			  statesProvinces.setStateProvinceName("Osun State");
			  statesProvinces.setCountries(countries);
			
			  statesProvincesRepository.save(statesProvinces);
			 
			
			  assertNotNull(statesProvincesRepository.findByStateProvinceId(26));
		  }
		  
		  
		  
		  @Test
		  public void  uniqueViolationTest() {
			  
			  
			  Countries countries = new Countries();
				countries.setCountryId(2);
				countries.setCountryName("Nigeria");
				countries.setCountryShortCode("NIG");
				countries.setPhoneCode("234");
		   
			  // Check for country name uniqueness
				StatesProvinces statesProvinces = new StatesProvinces();
				   
				  statesProvinces.setStateProvinceId(27);
				  statesProvinces.setStateProvinceName("Osun State");
				  statesProvinces.setCountries(countries);
				
				DataIntegrityViolationException exception = Assertions.assertThrows(DataIntegrityViolationException.class, () -> {
					statesProvincesRepository.save(statesProvinces);
				   });
				assertTrue(exception.getMostSpecificCause().toString().contains("Duplicate entry 'Osun State'"));
						
			
		  
		  
		  
		  }
		 
		  
		  @Test
		  public void notNullViolationTest() {
			  
			  
			  Countries countries = new Countries();
				countries.setCountryId(2);
				countries.setCountryName("Nigeria");
				countries.setCountryShortCode("NIG");
				countries.setPhoneCode("234");
		   
		   
			  //check province id set to null
				 StatesProvinces statesProvinces1 = new StatesProvinces();
				   
				
				  statesProvinces1.setStateProvinceName("Osun States");
				  statesProvinces1.setCountries(countries);
				
			
			  
				  InvalidDataAccessApiUsageException exception = Assertions.assertThrows(InvalidDataAccessApiUsageException.class, () -> {
					statesProvincesRepository.save(statesProvinces1);
			    });
				
			 assertTrue(exception.getMostSpecificCause().toString().contains("Not-null property references a transient value"));
				
			     
			  
			  //check province name set to null
			 StatesProvinces statesProvinces2 = new StatesProvinces();
			   
			 statesProvinces2.setStateProvinceId(26);
			  statesProvinces2.setCountries(countries);
			
			  DataIntegrityViolationException  exception1 = Assertions.assertThrows(DataIntegrityViolationException.class, () -> {
				   statesProvincesRepository.save( statesProvinces2);
			    });
			
			  assertTrue(exception1.getMostSpecificCause().toString().contains("Column 'stateprovincename' cannot be null"));
				
		  
			  
	  //check countries or country id set to null
			  StatesProvinces statesProvinces3 = new StatesProvinces();
			   
				 statesProvinces3.setStateProvinceId(26);
				  statesProvinces3.setStateProvinceName("Osun States");
				 
				
				  DataIntegrityViolationException   exception2 = Assertions.assertThrows(DataIntegrityViolationException.class, () -> {
					   statesProvincesRepository.save( statesProvinces3);
				    });
				  assertTrue(exception2.getMostSpecificCause().toString().contains("Column 'countryid' cannot be null"));
				
		  }


	}




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

import ca.timisencotech.projectmanagementapis.dto.Cities;
import ca.timisencotech.projectmanagementapis.dto.Countries;
import ca.timisencotech.projectmanagementapis.dto.StatesProvinces;
import ca.timisencotech.projectmanagementapis.repository.CitiesRepo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CitiesRepositoryTest {
		 
		@Autowired
		  private CitiesRepo citiesRepo;

		  @Test
		  public void saveTest() {
			  
			  
			  Cities cities = new Cities();
			  
			  
			  	Countries countries = new Countries();
				
				countries.setCountryId(2);
				countries.setCountryName("Canada");
				countries.setCountryShortCode("CAN");
				countries.setPhoneCode("1");
				
				StatesProvinces statesProvinces = new StatesProvinces();
				 statesProvinces.setStateProvinceId(26);
				  statesProvinces.setStateProvinceName("Osun State");
				  statesProvinces.setCountries(countries);
				
			  
		   
			  cities.setCityId(1);
			  cities.setCityName("Port Blair");
			cities.setStatesProvinces(statesProvinces);
			  citiesRepo.save(cities);
			 assertNotNull(citiesRepo.findByCityId(1));
		  }
		  
		  @Test
		  public void  uniqueViolationTest() {
			  
			  
			  Countries countries = new Countries();
				countries.setCountryId(2);
				countries.setCountryName("Nigeria");
				countries.setCountryShortCode("NIG");
				countries.setPhoneCode("234");
		   
				StatesProvinces statesProvinces = new StatesProvinces();
				 statesProvinces.setStateProvinceId(26);
				  statesProvinces.setStateProvinceName("Osun State");
				  statesProvinces.setCountries(countries);
				
			  
				
			  // Check for country name uniqueness
				  Cities cities1 = new Cities();
				  cities1.setCityId(2);
				  cities1.setCityName("Port Blair");
				cities1.setStatesProvinces(statesProvinces);
				  
				
				DataIntegrityViolationException exception = Assertions.assertThrows(DataIntegrityViolationException.class, () -> {
					citiesRepo.save(cities1);
				   });
				
				assertTrue(exception.getMostSpecificCause().toString().contains("Duplicate entry 'Port Blair'"));
						
			
		  
		  
		  
		  }
		 
		 
		  @Test
		  public void notNullViolationTest() {
			  
			  
			  Countries countries = new Countries();
				countries.setCountryId(2);
				countries.setCountryName("Nigeria");
				countries.setCountryShortCode("NIG");
				countries.setPhoneCode("234");
		   
				StatesProvinces statesProvinces = new StatesProvinces();
				 statesProvinces.setStateProvinceId(27);
				  statesProvinces.setStateProvinceName("Osun State");
				  statesProvinces.setCountries(countries);
				
				
				  
			  //check province id set to null
				 Cities cities1 = new Cities();
				   
				
				  cities1.setCityName("Osogbo");
					cities1.setStatesProvinces(statesProvinces);
					  
					 InvalidDataAccessApiUsageException exception = Assertions.assertThrows( InvalidDataAccessApiUsageException.class, () -> {
					  citiesRepo.save(cities1);
			    });
			assertTrue(exception.getMostSpecificCause().toString().contains("Not-null property references a transient value"));
				
			     
			  
			  //check city name set to null
			 Cities cities2 = new Cities();  
			 cities2.setCityId(2);
			cities2.setStatesProvinces(statesProvinces);
			  
			
			  DataIntegrityViolationException  exception1 = Assertions.assertThrows(DataIntegrityViolationException.class, () -> {
				  citiesRepo.save(cities2);
			    });
				assertTrue(exception1.getMostSpecificCause().toString().contains("Column 'cityname' cannot be null"));
				
		  
			  
	  //check countries or country id set to null
			  Cities cities3 = new Cities();  
				 
			  cities3.setCityId(2);
			  cities3.setCityName("Port Blair");
				  DataIntegrityViolationException   exception2 = Assertions.assertThrows(DataIntegrityViolationException.class, () -> {
					  citiesRepo.save(cities3);
				    });
				 assertTrue(exception2.getMostSpecificCause().toString().contains("Column 'stateprovinceid' cannot be null"));
				
		  }
		  
		  
		  @Test
		  public void findTest()
		  {
			  
		  }

	}




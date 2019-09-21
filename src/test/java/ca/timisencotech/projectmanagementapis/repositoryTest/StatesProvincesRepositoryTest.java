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
import ca.timisencotech.projectmanagementapis.repository.CountriesRepository;
import ca.timisencotech.projectmanagementapis.repository.StatesProvincesRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
public class StatesProvincesRepositoryTest {
		 
		@Autowired
		private StatesProvincesRepository statesProvincesRepository;

		@Autowired
		CountriesRepository countriesRepository;
		
		  @Test
		  public void saveTest() {
			  
			  
			  StatesProvinces statesProvinces = new StatesProvinces();
		   
			
				Countries findCountries =	countriesRepository.findByCountryId(1);
			  
			  statesProvinces.setStateProvinceId(26);
			  statesProvinces.setStateProvinceName("kwara State");
			  statesProvinces.setCountries(findCountries);
			
			  statesProvincesRepository.save(statesProvinces);
			 
			
			  assertNotNull(statesProvincesRepository.findByStateProvinceId(26));
		  }
		  
		  
		  
		

	}




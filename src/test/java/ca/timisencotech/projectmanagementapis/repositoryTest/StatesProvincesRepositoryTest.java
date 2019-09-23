package ca.timisencotech.projectmanagementapis.repositoryTest;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.timisencotech.projectmanagementapis.dto.Countries;
import ca.timisencotech.projectmanagementapis.dto.StatesProvinces;
import ca.timisencotech.projectmanagementapis.repository.CountriesRepo;
import ca.timisencotech.projectmanagementapis.repository.StatesProvincesRepo;


@RunWith(SpringRunner.class)
@SpringBootTest
public class StatesProvincesRepositoryTest {
		 
		@Autowired
		private StatesProvincesRepo statesProvincesRepo;

		@Autowired
		CountriesRepo countriesRepo;
		
		  @Test
		  public void saveTest() {
			  
			  
			  StatesProvinces statesProvinces = new StatesProvinces();
		   
			
				Countries findCountries =	countriesRepo.findByCountryId(1);
			  
			  statesProvinces.setStateProvinceId(26);
			  statesProvinces.setStateProvinceName("kwara State");
			  statesProvinces.setCountries(findCountries);
			
			  statesProvincesRepo.save(statesProvinces);
			 
			
			  assertNotNull(statesProvincesRepo.findByStateProvinceId(26));
		  }
		  
		  
		  
		

	}




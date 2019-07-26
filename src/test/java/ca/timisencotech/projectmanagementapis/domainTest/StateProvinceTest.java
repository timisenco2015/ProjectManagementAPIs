package ca.timisencotech.projectmanagementapis.domainTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ca.timisencotech.projectmanagementapis.domain.StateProvince;



@RunWith(SpringRunner.class)
@SpringBootTest
public class StateProvinceTest 
{
	@Test
	public void testSettersGetters() 
	{
		StateProvince stateProvince = new StateProvince();
		
		
		//check setter and getter for state or province id
		// A)

		stateProvince.setStateProvinceId(1);
		int testResult1 = 1;
		assertEquals(testResult1, stateProvince.getStateProvinceId());
		
		// B)
		
		stateProvince.setStateProvinceId(2);
		testResult1 = 2;
		assertEquals(testResult1, stateProvince.getStateProvinceId());
		
		// C)
		
		stateProvince.setStateProvinceId(3);
		testResult1 = 3;
		assertEquals(testResult1, stateProvince.getStateProvinceId());
		
		//check setter and getter for province or state name
		// A)
		
		stateProvince.setStateProvinceName("Andaman and Nicobar Islands");
		String testResult2 = "Andaman and Nicobar Islands";
		assertEquals(testResult2, stateProvince.getStateProvinceName());
		
		// B)
		stateProvince.setStateProvinceName("Andhra Pradesh");
		testResult2 = "Andhra Pradesh";
		assertEquals(testResult2, stateProvince.getStateProvinceName());
		
		
		// C)
		stateProvince.setStateProvinceName("Arunachal Pradesh");
		testResult2 = "Arunachal Pradesh";
		assertEquals(testResult2, stateProvince.getStateProvinceName());
		
		
		
		//check setter and getter for country id
				// A)
				
				stateProvince.setCountryId(101);
				int testResult3 = 101;
				assertEquals(testResult3, stateProvince.getCountryId());
				
				//check all methods

				assertEquals(3, stateProvince.getStateProvinceId());
				assertEquals("Arunachal Pradesh", stateProvince.getStateProvinceName());
				assertEquals(101, stateProvince.getCountryId());
				
	}

}

package ca.timisencotech.projectmanagementapis.domainTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ca.timisencotech.projectmanagementapis.domain.City;




@RunWith(SpringRunner.class)
@SpringBootTest
public class CityTest 
{
	@Test
	public void testSettersGetters() 
	{
		City city = new City();
		
		
		//check setter and getter for city id
		// A)

		city.setCityId(1);
		int testResult1 = 1;
		assertEquals(testResult1, city.getCityId());
		
		// B)
		
		city.setCityId(2);
		 testResult1 = 2;
		assertEquals(testResult1, city.getCityId());
		
		// C)
		
		city.setCityId(3);
		 testResult1 = 3;
		assertEquals(testResult1, city.getCityId());
		
		//check setter and getter for city id
		// A)
		
		city.setCityName("Bombuflat");
		String testResult2 = "Bombuflat";
		assertEquals(testResult2, city.getCityName());
		
		// B)
		city.setCityName("Garacharma");
		 testResult2 = "Garacharma";
		assertEquals(testResult2, city.getCityName());
		
		// C)
		city.setCityName("Port Blair");
		 testResult2 = "Port Blair";
		assertEquals(testResult2, city.getCityName());
		
		//check setter and getter for state id
		// A)
		city.setStateId(01);
		int testResult3 = 01;
		assertEquals(testResult3, city.getStateId());
		
		// B)
		
		city.setStateId(02);
		testResult3 = 02;
		assertEquals(testResult3, city.getStateId());
		
		
		// C)
		
		city.setStateId(03);
		testResult3 = 03;
		assertEquals(testResult3, city.getStateId());
		
		
		//check all methods

		assertEquals(3, city.getCityId());
		assertEquals("Port Blair", city.getCityName());
		assertEquals(03, city.getStateId());
		
	}

}

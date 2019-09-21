package ca.timisencotech.projectmanagementapis.daoTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.timisencotech.projectmanagementapis.dao.implementation.StatesProvincesDAOImp;
import ca.timisencotech.projectmanagementapis.domain.StateProvince;
import ca.timisencotech.projectmanagementapis.exception.ApiError;
import ca.timisencotech.projectmanagementapis.validation.Container;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StatesProvincesDAOImpTest<T> {
	
	
	 @Autowired
	 StatesProvincesDAOImp statesProvincesDAOImp;
	 
	 
	 @Test
		public void addServiceTest() 
		 {
	
		 
		 StateProvince stateProvince = new StateProvince();
		 stateProvince.setCountryId(1);
		 stateProvince.setStateProvinceId(24);
		 stateProvince.setStateProvinceName("Ogun State");
			 Container<T> stateProvinceContainer = statesProvincesDAOImp.addStatesProvinces(stateProvince);
			String typeOfObject = stateProvinceContainer.getObjectType();
			if(typeOfObject.equalsIgnoreCase("Class Object"))
			{
			 
				StateProvince resultStateProvince=	(StateProvince)stateProvinceContainer.getObject();
			 assertEquals(1, resultStateProvince.getCountryId());
			 assertEquals(24, resultStateProvince.getStateProvinceId());
			 assertEquals("Ogun State", resultStateProvince.getStateProvinceName());
			}
			
			
			
			//Check for unique constraint
			
			stateProvince = new StateProvince();
			 stateProvince.setCountryId(1);
			 stateProvince.setStateProvinceId(25);
			 stateProvince.setStateProvinceName("Ogun State");
			 stateProvinceContainer =statesProvincesDAOImp.addStatesProvinces(stateProvince);
			typeOfObject = stateProvinceContainer.getObjectType();
			if (typeOfObject.equalsIgnoreCase("Error Object"))
			{
				
				ApiError apiError = (ApiError)stateProvinceContainer.getObject();
				assertEquals("Persistence Error", apiError.getStatus());
			}
			
		 }
	 
	 
		 
		
		 
		 
		 

		

}

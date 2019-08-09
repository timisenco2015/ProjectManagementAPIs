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
		 stateProvince.setCountryId(5);
		 stateProvince.setStateProvinceId(24);
		 stateProvince.setStateProvinceName("Ogun State");
			 Container<T> stateProvinceContainer = statesProvincesDAOImp.addStatesProvinces(stateProvince);
			String typeOfObject = stateProvinceContainer.getObjectType();
			if(typeOfObject.equalsIgnoreCase("Class Object"))
			{
			 
				StateProvince resultStateProvince=	(StateProvince)stateProvinceContainer.getObject();
			 assertEquals(5, resultStateProvince.getCountryId());
			 assertEquals(24, resultStateProvince.getStateProvinceId());
			 assertEquals("Ogun State", resultStateProvince.getStateProvinceName());
			}
			else if (typeOfObject.equalsIgnoreCase("Error Object"))
			{
				ApiError apiError = (ApiError)stateProvinceContainer.getObject();
				assertEquals("Unique constraint error", apiError.getMessage());
			}
			
			
			
		 }
	 
	 
	 @Test
		public void addServiceConstraintErrorTest() 
		 {
			//checks for field(s) unique test
			 uniqueConstraintTest();
			
			 //checks for field(s) null test
			 nullConstraintTest();
			
		 }
		 
		
		 
		 private void uniqueConstraintTest()
		 {
			
			 StateProvince stateProvince = new StateProvince();
			 stateProvince.setCountryId(5);
			 stateProvince.setStateProvinceId(25);
			 stateProvince.setStateProvinceName("Ogun State");
			 Container<T> stateProvinceContainer =statesProvincesDAOImp.addStatesProvinces(stateProvince);
				String typeOfObject = stateProvinceContainer.getObjectType();
				if(typeOfObject.equalsIgnoreCase("Class Object"))
			{
			 
					 
					StateProvince resultStateProvince=	(StateProvince)stateProvinceContainer.getObject();
				 assertEquals(3, resultStateProvince.getCountryId());
				 assertEquals(27, resultStateProvince.getStateProvinceId());
				 assertEquals("Ogun State", resultStateProvince.getStateProvinceName());
				}
			else if (typeOfObject.equalsIgnoreCase("Error Object"))
			{
				ApiError apiError = (ApiError)stateProvinceContainer.getObject();
				assertEquals("Constraint error", apiError.getMessage());
			}
		 }
		 

		 private void nullConstraintTest()
		 {
			
			 
			 StateProvince stateProvince = new StateProvince();
			 stateProvince.setCountryId(5);
			 stateProvince.setStateProvinceId(28);
			 Container<T> stateProvinceContainer =statesProvincesDAOImp.addStatesProvinces(stateProvince);
				String typeOfObject = stateProvinceContainer.getObjectType();
				if(typeOfObject.equalsIgnoreCase("Class Object"))
			{
			 
					 
					StateProvince resultStateProvince=	(StateProvince)stateProvinceContainer.getObject();
				 assertEquals(3, resultStateProvince.getCountryId());
				 assertEquals(27, resultStateProvince.getStateProvinceId());
				 assertEquals("Ogun State", resultStateProvince.getStateProvinceName());
				}
			else if (typeOfObject.equalsIgnoreCase("Error Object"))
			{
				ApiError apiError = (ApiError)stateProvinceContainer.getObject();
				assertEquals("Constraint error", apiError.getMessage());
			}
		 }
			 
			

}

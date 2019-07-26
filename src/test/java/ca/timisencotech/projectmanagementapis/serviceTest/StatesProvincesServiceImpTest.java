package ca.timisencotech.projectmanagementapis.serviceTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.DataBinder;
import ca.timisencotech.projectmanagementapis.domain.StateProvince;
import ca.timisencotech.projectmanagementapis.exception.ApiError;
import ca.timisencotech.projectmanagementapis.service.StatesProvincesService;
import ca.timisencotech.projectmanagementapis.validation.Container;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StatesProvincesServiceImpTest<T> {
	
	
	 @Autowired
	 StatesProvincesService statesProvincesService;
	 
	 
	 @Test
		public void addServiceTest() 
		 {
	
		 
		 StateProvince stateProvince = new StateProvince();
		 stateProvince.setCountryId(3);
		 stateProvince.setStateProvinceId(23);
		 stateProvince.setStateProvinceName("Kwara State");
			
			 DataBinder binder = new DataBinder(stateProvince);
			 Container<T> stateProvinceContainer = statesProvincesService.addStateProvince(stateProvince, binder.getBindingResult());
			String typeOfObject = stateProvinceContainer.getObjectType();
			if(typeOfObject.equalsIgnoreCase("Class Object"))
			{
			 
				StateProvince resultStateProvince=	(StateProvince)stateProvinceContainer.getObject();
			 assertEquals(3, resultStateProvince.getCountryId());
			 assertEquals(23, resultStateProvince.getStateProvinceId());
			 assertEquals("Kwara State", resultStateProvince.getStateProvinceName());
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
			 stateProvince.setCountryId(3);
			 stateProvince.setStateProvinceId(24);
			 stateProvince.setStateProvinceName("Kwara State");
			 
			 DataBinder binder = new DataBinder(stateProvince);
			 Container<T> stateProvinceContainer = statesProvincesService.addStateProvince(stateProvince, binder.getBindingResult());
				String typeOfObject = stateProvinceContainer.getObjectType();
				if(typeOfObject.equalsIgnoreCase("Class Object"))
			{
			 
					 
					StateProvince resultStateProvince=	(StateProvince)stateProvinceContainer.getObject();
				 assertEquals(3, resultStateProvince.getCountryId());
				 assertEquals(23, resultStateProvince.getStateProvinceId());
				 assertEquals("Osun State", resultStateProvince.getStateProvinceName());
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
			 stateProvince.setCountryId(3);
			 stateProvince.setStateProvinceId(24);
			 
			 DataBinder binder = new DataBinder(stateProvince);
			 Container<T> stateProvinceContainer = statesProvincesService.addStateProvince(stateProvince, binder.getBindingResult());
				String typeOfObject = stateProvinceContainer.getObjectType();
				if(typeOfObject.equalsIgnoreCase("Class Object"))
			{
			 
					 
					StateProvince resultStateProvince=	(StateProvince)stateProvinceContainer.getObject();
				 assertEquals(3, resultStateProvince.getCountryId());
				 assertEquals(23, resultStateProvince.getStateProvinceId());
				 assertEquals("Osun State", resultStateProvince.getStateProvinceName());
				}
			else if (typeOfObject.equalsIgnoreCase("Error Object"))
			{
				ApiError apiError = (ApiError)stateProvinceContainer.getObject();
				assertEquals("Constraint error", apiError.getMessage());
			}
		 }
			 
			

}

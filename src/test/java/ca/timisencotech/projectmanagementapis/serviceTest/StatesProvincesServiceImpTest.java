package ca.timisencotech.projectmanagementapis.serviceTest;

import static org.junit.Assert.assertEquals;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.DataBinder;
import ca.timisencotech.projectmanagementapis.domain.StateProvince;
import ca.timisencotech.projectmanagementapis.exception.ApiError;
import ca.timisencotech.projectmanagementapis.exception.ErrorObject;
import ca.timisencotech.projectmanagementapis.exception.ValidationError;
import ca.timisencotech.projectmanagementapis.service.StatesProvincesService;
import ca.timisencotech.projectmanagementapis.validation.Container;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StatesProvincesServiceImpTest<T> {
	
	
	 @Autowired
	 StatesProvincesService statesProvincesService;
	 
	 
	 @Test
		public void addServiceTest() throws JSONException 
		 {
	
		 
		 StateProvince stateProvince = new StateProvince();
		 stateProvince.setCountryId(1);
		 stateProvince.setStateProvinceId(27);
		 stateProvince.setStateProvinceName("Oyo State");
			
			 DataBinder binder = new DataBinder(stateProvince);
			 Container<T> stateProvinceContainer = statesProvincesService.addStateProvince(stateProvince, binder.getBindingResult());
			String typeOfObject = stateProvinceContainer.getObjectType();
			if(typeOfObject.equalsIgnoreCase("Class Object"))
			{
			 
				StateProvince resultStateProvince=	(StateProvince)stateProvinceContainer.getObject();
			 assertEquals(1, resultStateProvince.getCountryId());
			 assertEquals(27, resultStateProvince.getStateProvinceId());
			 assertEquals("Oyo State", resultStateProvince.getStateProvinceName());
			}
			
			
			
		//checks for unique constraints	
			 stateProvince = new StateProvince();
			 stateProvince.setCountryId(1);
			 stateProvince.setStateProvinceId(26);
			 stateProvince.setStateProvinceName("Kwara State");
			 
			  binder = new DataBinder(stateProvince);
			  stateProvinceContainer = statesProvincesService.addStateProvince(stateProvince, binder.getBindingResult());
				 typeOfObject = stateProvinceContainer.getObjectType();
				 if (typeOfObject.equalsIgnoreCase("Error Object"))
					{
						ErrorObject errorObject = (ErrorObject) stateProvinceContainer.getObject();
						if(errorObject instanceof ApiError)
						{
							ApiError apiError = (ApiError) stateProvinceContainer.getObject();
							assertEquals("Persistence Error", apiError.getStatus());
				
						}
					}
				 
				 
				// checks for validation errors 
				 stateProvince = new StateProvince();
				 stateProvince.setCountryId(3);
				 stateProvince.setStateProvinceId(24);
				 
				 binder = new DataBinder(stateProvince);
				stateProvinceContainer = statesProvincesService.addStateProvince(stateProvince, binder.getBindingResult());
				typeOfObject = stateProvinceContainer.getObjectType();
				if (typeOfObject.equalsIgnoreCase("Error Object"))
				{

					ErrorObject errorObject = (ErrorObject)stateProvinceContainer.getObject();
					
					 if (errorObject instanceof ValidationError)
					{
						ValidationError validationError = (ValidationError)errorObject;
						assertEquals("Failed", validationError.getMessageObject().getString("errorStatus"));
						assertEquals("Failed validation test for all or most of the fields", validationError.getMessageObject().getString("message"));
						
						
					}
				}
				 
		 		}
			
		 
	 
	 

		 
		
		 
		
		 

		
			

}

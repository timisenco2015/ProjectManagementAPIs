package ca.timisencotech.projectmanagementapis.serviceTest;

import static org.junit.Assert.assertEquals;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.DataBinder;
import ca.timisencotech.projectmanagementapis.domain.Company;
import ca.timisencotech.projectmanagementapis.exception.ApiError;
import ca.timisencotech.projectmanagementapis.exception.ErrorObject;
import ca.timisencotech.projectmanagementapis.exception.ValidationError;
import ca.timisencotech.projectmanagementapis.service.CompanyService;
import ca.timisencotech.projectmanagementapis.validation.Container;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyServiceImpTest<T> {
	
	 @Autowired
	 CompanyService companyService;
	
	 
	 @Test
		public void addCompanyTest() throws JSONException 
		 {
			//checks that add service can call country repo save method
		 	// and save new country to database
		 Company company = new  Company();
			company.setAddress("616 Armitgae Crescent");
			company.setCity("Sherwood Park");
			company.setCompanyName("HouseTech");
			company.setCountry("Canada");
			company.setPhoneNumber("2059634577");
			company.setPostalCode("T8H 0T7");
			company.setRegisterBy("userAAEmail@gmail.com");
			company.setStateProvince("Edmonton");
			 DataBinder binder = new DataBinder(company);
			 Container<T> companiesContainer = companyService.addCompany(company, binder.getBindingResult());
			String typeOfObject = companiesContainer.getObjectType();
			if(typeOfObject.equalsIgnoreCase("Class Object"))
			{
			 
				Company resultCompanies=	(Company)companiesContainer.getObject();
			 assertEquals("616 Armitgae Crescent", resultCompanies.getAddress());
			 assertEquals("Sherwood Park", resultCompanies.getCity());
			 assertEquals("HouseTech", resultCompanies.getCompanyName());
			 assertEquals("Canada", resultCompanies.getCountry());
			 assertEquals("2059634577", resultCompanies.getPhoneNumber());
			 assertEquals("T8H 0T7", resultCompanies.getPostalCode());
			 assertEquals("userAAEmail@gmail.com", resultCompanies.getRegisterBy());
			 assertEquals("Edmonton", resultCompanies.getStateProvince());
							
			
			
			}
			
			
			//Checks for unique constraint
			
			 company = new  Company();
				company.setAddress("616 Armitgae Crescent");
				company.setCity("Sherwood Park");
				company.setCompanyName("HouseTech");
				company.setCountry("Canada");
				company.setPhoneNumber("2059634577");
				company.setPostalCode("T8H 0T7");
				company.setRegisterBy("userAAEmail@gmail.com");
				company.setStateProvince("Edmonton");
				binder = new DataBinder(company);
				companiesContainer = companyService.addCompany(company, binder.getBindingResult());
				typeOfObject = companiesContainer.getObjectType();
				if (typeOfObject.equalsIgnoreCase("Error Object"))
			{
				ErrorObject errorObject = (ErrorObject) companiesContainer.getObject();
				if(errorObject instanceof ApiError)
				{
					ApiError apiError = (ApiError) errorObject;
					assertEquals("Persistence Error", apiError.getStatus());
		
				}
			}
			
			// checks for validation error
			
				 company = new  Company();
					company.setAddress("616 Armitgae Crescent");
					company.setCity("Sherwood Park");
					company.setCountry("Canada");
					company.setPhoneNumber("2059634577");
					company.setPostalCode("T8H 0T7");
					company.setRegisterBy("userAAEmail@gmail.com");
					company.setStateProvince("Edmonton");
					binder = new DataBinder(company);
					companiesContainer = companyService.addCompany(company, binder.getBindingResult());
					typeOfObject = companiesContainer.getObjectType();
					if (typeOfObject.equalsIgnoreCase("Error Object"))
			{

				ErrorObject errorObject = (ErrorObject)companiesContainer.getObject();
				
				 if (errorObject instanceof ValidationError)
				{
					ValidationError validationError = (ValidationError)errorObject;
					assertEquals("Failed", validationError.getMessageObject().getString("errorStatus"));
					assertEquals("Failed validation test for all or most of the fields", validationError.getMessageObject().getString("message"));
					
					
				}
			}
		 }
			 
	
	 
	
	 
	
	 

	 

	 
		

}

package ca.timisencotech.projectmanagementapis.daoTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.timisencotech.projectmanagementapis.dao.implementation.CompaniesDAOImp;
import ca.timisencotech.projectmanagementapis.domain.Companies;
import ca.timisencotech.projectmanagementapis.exception.ApiError;
import ca.timisencotech.projectmanagementapis.validation.Container;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyDAOImpTest<T> {
	
	 @Autowired
	 CompaniesDAOImp companiesDAOImp;
	
	 
	 @Test
		public void addServiceTest() 
		 {
			//checks that add service can call country repo save method
		 	// and save new country to database
			Companies companies = new  Companies();
			companies.setAddress("616 Armitgae Crescent");
			companies.setCity("Sherwood Park");
			companies.setCompanyName("TimiTech");
			companies.setCountry("Canada");
			companies.setPhoneNumber("2059634577");
			companies.setPostalCode("T8H 0T7");
			companies.setRegisterBy("userAAEmail@gmail.com");
			companies.setStateProvince("Edmonton");
			
			 Container<T> companiesContainer =companiesDAOImp.addCompanies(companies) ;
			String typeOfObject = companiesContainer.getObjectType();
			if(typeOfObject.equalsIgnoreCase("Class Object"))
			{
			 
				Companies resultCompanies=	(Companies)companiesContainer.getObject();
			 assertEquals("616 Armitgae Crescent", resultCompanies.getAddress());
			 assertEquals("Sherwood Park", resultCompanies.getCity());
			 assertEquals("TimiTech", resultCompanies.getCompanyName());
			 assertEquals("Canada", resultCompanies.getCountry());
			 assertEquals("2059634577", resultCompanies.getPhoneNumber());
			 assertEquals("T8H 0T7", resultCompanies.getPostalCode());
			 assertEquals("userAAEmail@gmail.com", resultCompanies.getRegisterBy());
			 assertEquals("Edmonton", resultCompanies.getStateProvince());
							
			}
		
			
			//checks for unique constraint
			
			 companies = new  Companies();
			companies.setAddress("616 Armitgae Crescent");
			companies.setCity("Sherwood Park");
			companies.setCompanyName("TimiTech");
			companies.setCountry("Canada");
			companies.setPhoneNumber("2059634577");
			companies.setPostalCode("T8H 0T7");
			companies.setRegisterBy("userAAEmail@gmail.com");
			companies.setStateProvince("Edmonton");
			companiesContainer =companiesDAOImp.addCompanies(companies) ;
			typeOfObject = companiesContainer.getObjectType();
			if (typeOfObject.equalsIgnoreCase("Error Object"))
			{
				
				ApiError apiError = (ApiError)companiesContainer.getObject();
				assertEquals("Persistence Error", apiError.getStatus());
			}
			
			
			
		 }
			 
	
	 
	
	

}

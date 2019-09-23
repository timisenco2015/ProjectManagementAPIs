package ca.timisencotech.projectmanagementapis.daoTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.timisencotech.projectmanagementapis.dao.implementation.CompanyDAOImp;
import ca.timisencotech.projectmanagementapis.domain.Company;
import ca.timisencotech.projectmanagementapis.exception.ApiError;
import ca.timisencotech.projectmanagementapis.validation.Container;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyDAOImpTest<T> {
	
	 @Autowired
	 CompanyDAOImp companyDAOImp;
	
	 
	 @Test
		public void addCompanyTest() 
		 {
			//checks that add service can call country repo save method
		 	// and save new country to database
			Company company = new  Company();
			company.setAddress("616 Armitgae Crescent");
			company.setCity("Sherwood Park");
			company.setCompanyName("TimiTech");
			company.setCountry("Canada");
			company.setPhoneNumber("2059634577");
			company.setPostalCode("T8H 0T7");
			company.setRegisterBy("userAAEmail@gmail.com");
			company.setStateProvince("Edmonton");
			
			 Container<T> companiesContainer =companyDAOImp.addCompany(company) ;
			String typeOfObject = companiesContainer.getObjectType();
			if(typeOfObject.equalsIgnoreCase("Class Object"))
			{
			 
				Company resultCompanies=	(Company)companiesContainer.getObject();
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
			
			company = new  Company();
			company.setAddress("616 Armitgae Crescent");
			company.setCity("Sherwood Park");
			company.setCompanyName("TimiTech");
			company.setCountry("Canada");
			company.setPhoneNumber("2059634577");
			company.setPostalCode("T8H 0T7");
			company.setRegisterBy("userAAEmail@gmail.com");
			company.setStateProvince("Edmonton");
			companiesContainer =companyDAOImp.addCompany(company) ;
			typeOfObject = companiesContainer.getObjectType();
			if (typeOfObject.equalsIgnoreCase("Error Object"))
			{
				
				ApiError apiError = (ApiError)companiesContainer.getObject();
				assertEquals("Persistence Error", apiError.getStatus());
			}
			
			
			
		 }
			 
	
	 
	
	

}

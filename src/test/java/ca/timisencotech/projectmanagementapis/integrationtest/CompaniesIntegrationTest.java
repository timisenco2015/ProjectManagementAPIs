package ca.timisencotech.projectmanagementapis.integrationtest;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import ca.timisencotech.projectmanagementapis.domain.Companies;
import ca.timisencotech.projectmanagementapis.domain.Country;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class CompaniesIntegrationTest<T> {

	  @Autowired
	  private TestRestTemplate restTemplate;
	 

	
	 @Test
		public void addCountryTest() 
		 {
			Companies companies = new  Companies();
			companies.setAddress("616 Armitgae Crescent");
			companies.setCity("Sherwood Park");
			companies.setCompanyName("TestTech");
			companies.setCountry("Canada");
			companies.setPhoneNumber("2059634577");
			companies.setPostalCode("T8H 0T7");
			companies.setRegisterBy("userAAEmail@gmail.com");
			companies.setStateProvince("Edmonton");
		 
		 List <MediaType> mediaTypeList = new ArrayList<MediaType>();
		 mediaTypeList.add(MediaType.APPLICATION_JSON);
		 HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_JSON);
	        headers.setAccept(mediaTypeList);
	       HttpEntity<Companies> entity = new HttpEntity<>(companies, headers);
	       
	        ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:8080/projectmanagement/registerCompany", entity,String.class);
	       // String expectedOutput = "{object:{countryId:20,countryShortCode:ITY,countryName:Italy,phoneCode:290},objectType:Class Object}";
	        assertEquals(HttpStatus.OK, response.getStatusCode());
	        assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getContentType());
	        //assertEquals(expectedOutput, response.getBody());
	       }
	
}

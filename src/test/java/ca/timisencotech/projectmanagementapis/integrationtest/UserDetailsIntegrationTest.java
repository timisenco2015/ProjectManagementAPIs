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
import ca.timisencotech.projectmanagementapis.domain.UserDetail;




@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class UserDetailsIntegrationTest {
	
	 @Autowired
	  private TestRestTemplate restTemplate;
	 

	 @Test
	 public void addUserDetailsTest() 
		 {
			
		 UserDetail userDetail = new UserDetail();
		 
		  userDetail.setFirstName("Bola");
		  userDetail.setLastName("Ige");
		  userDetail.setMiddleName("A");
		  userDetail.setPhoneNo("2048623746");
		  userDetail.setUserAddress("52 George Street");
		  userDetail.setUserEmail("dayo@gmail.com");
		  userDetail.setUserGender("FeMale");
		//  userDetail.setCountryPhoneCode("234");
		 System.out.println("--> "+userDetail);
		 List <MediaType> mediaTypeList = new ArrayList<MediaType>();
		 mediaTypeList.add(MediaType.APPLICATION_JSON);
		 HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_JSON);
	        headers.setAccept(mediaTypeList);
	       HttpEntity<UserDetail> entity = new HttpEntity<>(userDetail, headers);
	       
	        ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:8080/projectmanagement/addUser", entity,String.class);
	      // String expectedOutput = "{object:{countryId:20,countryShortCode:ITY,countryName:Italy,phoneCode:290},objectType:Class Object}";
	        System.out.println(response.getBody());
	        assertEquals(HttpStatus.OK, response.getStatusCode());
	        assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getContentType());
	     //   assertEquals(expectedOutput, response.getBody());
	       } 
	 
	 
	
	 

}

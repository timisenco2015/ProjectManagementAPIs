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
import ca.timisencotech.projectmanagementapis.domain.User;




@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class UserIntegrationTest {
	
	 @Autowired
	  private TestRestTemplate restTemplate;
	 

	 @Test
	 public void addNewUserTest() 
		 {
			
		 User user = new User();
		 
		  user.setFirstName("Bola");
		  user.setLastName("Ige");
		  user.setMiddleName("A");
		  user.setPhoneNo("2048623746");
		  user.setUserAddress("52 George Street");
		  user.setUserEmail("userEmailA@gmail.com");
		  user.setUserGender("Male");
		 List <MediaType> mediaTypeList = new ArrayList<MediaType>();
		 mediaTypeList.add(MediaType.APPLICATION_JSON);
		 HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_JSON);
	        headers.setAccept(mediaTypeList);
	       HttpEntity<User> entity = new HttpEntity<>(user, headers);
	       
	        ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:8080/users/addnewuser", entity,String.class);
	      // String expectedOutput = "{object:{countryId:20,countryShortCode:ITY,countryName:Italy,phoneCode:290},objectType:Class Object}";
	     assertEquals(HttpStatus.OK, response.getStatusCode());
	     assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getContentType());
	     //   assertEquals(expectedOutput, response.getBody());
	       } 
	 
	 
	
	 

}

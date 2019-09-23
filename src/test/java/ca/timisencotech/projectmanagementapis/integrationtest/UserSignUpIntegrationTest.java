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
import ca.timisencotech.projectmanagementapis.domain.UserSignUp;



@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class UserSignUpIntegrationTest {
	
	 @Autowired
	  private TestRestTemplate restTemplate;
	 

	
	 @Test
	public void addUserLoginTest() 
		 {
			
		
			UserSignUp userSignUp = new UserSignUp();
			userSignUp.setPassword("Test@2019");
			userSignUp.setEmail("userEmail@gmail.com");
			
			
		  
		 
		 List <MediaType> mediaTypeList = new ArrayList<MediaType>();
		 mediaTypeList.add(MediaType.APPLICATION_JSON);
		 HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_JSON);
	        headers.setAccept(mediaTypeList);
	       HttpEntity<UserSignUp> entity = new HttpEntity<>(userSignUp, headers);
	        ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:8080/usersignup/newusersignup", entity,String.class);
	      // String expectedOutput = "{object:{countryId:20,countryShortCode:ITY,countryName:Italy,phoneCode:290},objectType:Class Object}";
	        assertEquals(HttpStatus.OK, response.getStatusCode());
	        assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getContentType());
	     //   assertEquals(expectedOutput, response.getBody());
	       }
	 
	

	 

	 
	 @Test
	public void updateUserPasswordTest() 
		 {
			
			UserSignUp userSignUp = new UserSignUp();
			userSignUp.setPassword("Test@2022");
			userSignUp.setEmail("userEmail@gmail.com");
			
			
		 
		 List <MediaType> mediaTypeList = new ArrayList<MediaType>();
		 mediaTypeList.add(MediaType.APPLICATION_JSON);
		 HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_JSON);
	        headers.setAccept(mediaTypeList);
	       HttpEntity<UserSignUp> entity = new HttpEntity<>(userSignUp, headers);
	     //  System.out.println("--==>"+entity.getBody());
	        ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:8080/usersignup/changePassword", entity,String.class);
	      // String expectedOutput = "{object:{countryId:20,countryShortCode:ITY,countryName:Italy,phoneCode:290},objectType:Class Object}";
	        assertEquals(HttpStatus.OK, response.getStatusCode());
	        assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getContentType());
	     //   assertEquals(expectedOutput, response.getBody());
	       }
}

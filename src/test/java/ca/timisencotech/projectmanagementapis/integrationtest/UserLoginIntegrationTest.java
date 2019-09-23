package ca.timisencotech.projectmanagementapis.integrationtest;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
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
import ca.timisencotech.projectmanagementapis.domain.UserLogin;



@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class UserLoginIntegrationTest {
	
	 @Autowired
	  private TestRestTemplate restTemplate;
	 


	 
	
	 @Test
	public void confirmUserLoginTest() 
		 {
			
		 Date date= new Date();
			Timestamp loginTime = new Timestamp(date.getTime());
			
			UserLogin userLogin = new UserLogin();
			userLogin.setPassword("Test@2022");
			userLogin.setLoginTime(loginTime);
			userLogin.setUserEmail("userEmail@gmail.com");
		  
		 
		 List <MediaType> mediaTypeList = new ArrayList<MediaType>();
		 mediaTypeList.add(MediaType.APPLICATION_JSON);
		 HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_JSON);
	        headers.setAccept(mediaTypeList);
	       HttpEntity<UserLogin> entity = new HttpEntity<>(userLogin, headers);
	     //  System.out.println("--==>"+entity.getBody());
	        ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:8080/userlogin/confirmlogindetails", entity,String.class);
	      // String expectedOutput = "{object:{countryId:20,countryShortCode:ITY,countryName:Italy,phoneCode:290},objectType:Class Object}";
	        assertEquals(HttpStatus.OK, response.getStatusCode());
	        assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getContentType());
	     //   assertEquals(expectedOutput, response.getBody());
	       }
	 

	
}

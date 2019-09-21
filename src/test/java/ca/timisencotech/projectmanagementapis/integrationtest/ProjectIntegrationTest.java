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
import ca.timisencotech.projectmanagementapis.domain.Project;




@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class ProjectIntegrationTest {
	
	 @Autowired
	  private TestRestTemplate restTemplate;
	 

	
	 @Test
	public void addprojectDetailsTest() 
		 {
			
		 Date date= new Date();
			Timestamp loginTime = new Timestamp(date.getTime());
			
		
			Project project = new Project();
			
			project.setProjectName("Sherwd Project");
			
			project.setCreatedDate(loginTime);
			
			loginTime = new Timestamp(date.getTime());
			project.setStartDate(loginTime);
			
			loginTime = new Timestamp(date.getTime());
			project.setEndDate(loginTime);
		 
			project.setCreatedBy("userEmail@gmail.com");
			
			project.setDescription("dsfdsfdsvdsdfdsfdfdfd");
			
			
		 List <MediaType> mediaTypeList = new ArrayList<MediaType>();
		 mediaTypeList.add(MediaType.APPLICATION_JSON);
		 HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_JSON);
	        headers.setAccept(mediaTypeList);
	       HttpEntity<Project> entity = new HttpEntity<>(project, headers);
	        ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:8080/projectmanagement/addNewProject", entity,String.class);
	      // String expectedOutput = "{object:{countryId:20,countryShortCode:ITY,countryName:Italy,phoneCode:290},objectType:Class Object}";
	        assertEquals(HttpStatus.OK, response.getStatusCode());
	        assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getContentType());
	    //   assertEquals(expectedOutput, response.getBody());
	       }
	 
	
	
}

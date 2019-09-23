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
import ca.timisencotech.projectmanagementapis.domain.ProjectGroup;




@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class ProjectGroupIntegrationTest {
	
	 @Autowired
	  private TestRestTemplate restTemplate;
	 

	
	 @Test
	public void addProjectGroupTest() 
		 {
			
		 Date date= new Date();
			
		
			ProjectGroup projectGroup = new ProjectGroup();
			projectGroup.setCreatedBy("userAEmail@gmail.com");
			
			Timestamp createdDate = new Timestamp(date.getTime());
			projectGroup.setCreatedDate(createdDate);
			
			projectGroup.setDescription("adfdsds");
			projectGroup.setGroupName("Group 3");
			projectGroup.setIsActive(true);
			projectGroup.setProjectName("Sherwood Project");
			
			
			
		 List <MediaType> mediaTypeList = new ArrayList<MediaType>();
		 mediaTypeList.add(MediaType.APPLICATION_JSON);
		 HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_JSON);
	        headers.setAccept(mediaTypeList);
	       HttpEntity<ProjectGroup> entity = new HttpEntity<>(projectGroup, headers);
	        ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:8080/projectgroup/createprojectgroup", entity,String.class);
	      // String expectedOutput = "{object:{countryId:20,countryShortCode:ITY,countryName:Italy,phoneCode:290},objectType:Class Object}";
	        assertEquals(HttpStatus.OK, response.getStatusCode());
	        assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getContentType());
	   //   assertEquals(expectedOutput, response.getBody());
	       }
	 
	
	
}

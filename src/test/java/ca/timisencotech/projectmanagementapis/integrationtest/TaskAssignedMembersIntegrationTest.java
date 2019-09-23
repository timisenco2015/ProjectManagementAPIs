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
import ca.timisencotech.projectmanagementapis.domain.TaskAssignedMembers;




@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class TaskAssignedMembersIntegrationTest {
	
	 @Autowired
	  private TestRestTemplate restTemplate;
	 

	
	 @Test
	public void assignMemberTaskTest() 
		 {
			
		 Date date= new Date();
			Timestamp dateAssigned = new Timestamp(date.getTime());
			
			
			TaskAssignedMembers taskAssignedMembers = new TaskAssignedMembers();
			taskAssignedMembers.setActive(true);
			taskAssignedMembers.setAssignedBy("userAEmail@gmail.com");
			taskAssignedMembers.setAssignedTo("userHEmail@gmail.com");
			taskAssignedMembers.setDateAssigned(dateAssigned);
			taskAssignedMembers.setDescription("gfghftdrdg");
			taskAssignedMembers.setProjectName("Sherwood Project");
			taskAssignedMembers.setTaskName("Sub task1");
			
			
		 List <MediaType> mediaTypeList = new ArrayList<MediaType>();
		 mediaTypeList.add(MediaType.APPLICATION_JSON);
		 HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_JSON);
	        headers.setAccept(mediaTypeList);
	       HttpEntity<TaskAssignedMembers> entity = new HttpEntity<>(taskAssignedMembers, headers);
	        ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:8080/taskassignedmembers/assigntasktomember", entity,String.class);
	      // String expectedOutput = "{object:{countryId:20,countryShortCode:ITY,countryName:Italy,phoneCode:290},objectType:Class Object}";
	        assertEquals(HttpStatus.OK, response.getStatusCode());
	        assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getContentType());
	    //   assertEquals(expectedOutput, response.getBody());
	       }
	 
	
	
}

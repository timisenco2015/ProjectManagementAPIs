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
import ca.timisencotech.projectmanagementapis.domain.SupervisorAppraisals;




@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class SupervisorAppraisalsIntegrationTest {
	
	 @Autowired
	  private TestRestTemplate restTemplate;
	 

	
	 @Test
	public void addNewSelfAppraisalTest() 
		 {
		 Date date= new Date();
		 SupervisorAppraisals supervisorAppraisals=new SupervisorAppraisals();
			supervisorAppraisals.setStandardA("QuestionA");
			supervisorAppraisals.setStandardAPoint(4);
			supervisorAppraisals.setStandardB("QuestionB");
			supervisorAppraisals.setStandardBPoint(3);
			supervisorAppraisals.setStandardC("QuestionC");
			supervisorAppraisals.setStandardCPoint(4);
			supervisorAppraisals.setStandardD("QuestionD");
			supervisorAppraisals.setStandardDPoint(2);
			supervisorAppraisals.setStandardE("QuestionE");
			supervisorAppraisals.setStandardEPoint(3);
			supervisorAppraisals.setStandardF("QuestionF");
			supervisorAppraisals.setStandardFPoint(4);
			supervisorAppraisals.setStandardG("QuestionG");
			supervisorAppraisals.setStandardGPoint(5);
			supervisorAppraisals.setStandardH("QuestionH");
			supervisorAppraisals.setStandardHPoint(2);
			supervisorAppraisals.setStandardI("QuestionI");
			supervisorAppraisals.setStandardIPoint(1);
			supervisorAppraisals.setStandardJ("QuestionJ");
			supervisorAppraisals.setStandardJPoint(2);
			supervisorAppraisals.setSupervisorName("userAEmail@gmail.com");
			supervisorAppraisals.setSubordinateMember("userHEmail@gmail.com");
			supervisorAppraisals.setTaskName("Sub Task1");
			supervisorAppraisals.setProjectName("Sherwood Project");
			supervisorAppraisals.setDescription("fdgdjdydtf");
			Timestamp appraisedStartDate = new Timestamp(date.getTime());
			supervisorAppraisals.setAppraisedStartDate(appraisedStartDate);
		
			Timestamp appraisedEndDate = new Timestamp(date.getTime());
			supervisorAppraisals.setAppraisedEndDate(appraisedEndDate);
			
			
			
		 List <MediaType> mediaTypeList = new ArrayList<MediaType>();
		 mediaTypeList.add(MediaType.APPLICATION_JSON);
		 HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_JSON);
	        headers.setAccept(mediaTypeList);
	       HttpEntity<SupervisorAppraisals> entity = new HttpEntity<>(supervisorAppraisals, headers);
	        ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:8080/projectmanagement/supervisorAppraisal", entity,String.class);
	      // String expectedOutput = "{object:{countryId:20,countryShortCode:ITY,countryName:Italy,phoneCode:290},objectType:Class Object}";
	        assertEquals(HttpStatus.OK, response.getStatusCode());
	        assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getContentType());
	    //   assertEquals(expectedOutput, response.getBody());
	       }
	 
	
	
}

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
import ca.timisencotech.projectmanagementapis.domain.SelfAppraisals;



@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class SelfAppraisalsIntegrationTest {
	
	 @Autowired
	  private TestRestTemplate restTemplate;
	 

	
	 @Test
	public void addNewSelfAppraisalTest() 
		 {
		 Date date= new Date();
		 SelfAppraisals selfAppraisals=new SelfAppraisals();
			selfAppraisals.setStandardA("QuestionA");
			selfAppraisals.setStandardAPoint(4);
			selfAppraisals.setStandardB("QuestionB");
			selfAppraisals.setStandardBPoint(3);
			selfAppraisals.setStandardC("QuestionC");
			selfAppraisals.setStandardCPoint(4);
			selfAppraisals.setStandardD("QuestionD");
			selfAppraisals.setStandardDPoint(2);
			selfAppraisals.setStandardE("QuestionE");
			selfAppraisals.setStandardEPoint(3);
			selfAppraisals.setStandardF("QuestionF");
			selfAppraisals.setStandardFPoint(4);
			selfAppraisals.setStandardG("QuestionG");
			selfAppraisals.setStandardGPoint(5);
			selfAppraisals.setStandardH("QuestionH");
			selfAppraisals.setStandardHPoint(2);
			selfAppraisals.setStandardI("QuestionI");
			selfAppraisals.setStandardIPoint(1);
			selfAppraisals.setStandardJ("QuestionJ");
			selfAppraisals.setStandardJPoint(2);
			selfAppraisals.setSubordinateMember("userHEmail@gmail.com");
			selfAppraisals.setTaskName("Sub Task1");
			selfAppraisals.setProjectName("Sherwood Project");
			selfAppraisals.setDescription("fdgdjdydtf");
			Timestamp appraisedStartDate = new Timestamp(date.getTime());
			selfAppraisals.setAppraisedStartDate(appraisedStartDate);
		
			Timestamp appraisedEndDate = new Timestamp(date.getTime());
			selfAppraisals.setAppraisedEndDate(appraisedEndDate);
			
			
		 List <MediaType> mediaTypeList = new ArrayList<MediaType>();
		 mediaTypeList.add(MediaType.APPLICATION_JSON);
		 HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_JSON);
	        headers.setAccept(mediaTypeList);
	       HttpEntity<SelfAppraisals> entity = new HttpEntity<>(selfAppraisals, headers);
	        ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:8080/selfappraisal/appraiseyourself", entity,String.class);
	      // String expectedOutput = "{object:{countryId:20,countryShortCode:ITY,countryName:Italy,phoneCode:290},objectType:Class Object}";
	        assertEquals(HttpStatus.OK, response.getStatusCode());
	        assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getContentType());
	    //   assertEquals(expectedOutput, response.getBody());
	       }
	 
	
	
}

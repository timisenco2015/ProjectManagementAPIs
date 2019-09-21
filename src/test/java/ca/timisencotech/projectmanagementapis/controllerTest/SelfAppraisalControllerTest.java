package ca.timisencotech.projectmanagementapis.controllerTest;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.fasterxml.jackson.databind.ObjectMapper;
import ca.timisencotech.projectmanagementapis.controller.SelfAppraisalController;
import ca.timisencotech.projectmanagementapis.domain.SelfAppraisals;
import ca.timisencotech.projectmanagementapis.service.SelfAppraisalsService;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SelfAppraisalControllerTest {
	 @Autowired
		private MockMvc mockMvc;
		
		@Mock
		private SelfAppraisalsService selfAppraisalsService;
		
		@InjectMocks
		private SelfAppraisalController selfAppraisalController;
		
		@Before
		public void setUp() throws Exception
		{
			mockMvc = MockMvcBuilders.standaloneSetup(selfAppraisalController).build();
		}

		
		@Test
		public void testAddNewUser() throws Exception
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
				
			
			
			mockMvc.perform( MockMvcRequestBuilders
				      .post("/projectmanagement/inidividualAppraisal")
				      .content(asJsonString(selfAppraisals))
				      .contentType(MediaType.APPLICATION_JSON)
				      .accept(MediaType.APPLICATION_JSON))
				      .andExpect(status().isOk());
				     
		
		}
		
		public static String asJsonString(final Object obj) {
		    try {
		        return new ObjectMapper().writeValueAsString(obj);
		    } catch (Exception e) {
		        throw new RuntimeException(e);
		    }
		}
		

}

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
import ca.timisencotech.projectmanagementapis.controller.SupervisorAppraisalController;
import ca.timisencotech.projectmanagementapis.domain.SupervisorAppraisals;
import ca.timisencotech.projectmanagementapis.service.SupervisorAppraisalsService;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SupervisorAppraisalControllerTest {
	 @Autowired
		private MockMvc mockMvc;
		
		@Mock
		private SupervisorAppraisalsService supervisorAppraisalsService;
		
		@InjectMocks
		private SupervisorAppraisalController supervisorAppraisalController;
		
		@Before
		public void setUp() throws Exception
		{
			mockMvc = MockMvcBuilders.standaloneSetup(supervisorAppraisalController ).build();
		}

		
		@Test
		public void testAddNewUser() throws Exception
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
				supervisorAppraisals.setSubordinateMember("userAEmail@gmail.com");
				supervisorAppraisals.setTaskName("Sub Task1");
				supervisorAppraisals.setProjectName("Sherwood Project");
				supervisorAppraisals.setDescription("fdgdjdydtf");
				Timestamp appraisedStartDate = new Timestamp(date.getTime());
				supervisorAppraisals.setAppraisedStartDate(appraisedStartDate);
			
				Timestamp appraisedEndDate = new Timestamp(date.getTime());
				supervisorAppraisals.setAppraisedEndDate(appraisedEndDate);
				
			
			
			mockMvc.perform( MockMvcRequestBuilders
				      .post("/projectmanagement/supervisorAppraisal")
				      .content(asJsonString(supervisorAppraisals))
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
